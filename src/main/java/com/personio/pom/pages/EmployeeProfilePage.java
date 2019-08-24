package com.personio.pom.pages;

import com.personio.automation.ui.type.html.Button;
import com.personio.automation.ui.type.html.Div;
import com.personio.automation.ui.type.html.Link;
import com.personio.automation.ui.type.html.SelectItem;
import com.personio.automation.ui.web.Browser;
import com.personio.automation.ui.web.By;
import com.personio.automation.ui.web.Page;

public class EmployeeProfilePage extends Page {
    public EmployeeProfilePage(Browser browser) {
        super(browser);
        waitForAjaxAndJSToLOad();
        waitForElement(By.ByType.Id,"profile-headline");
    }

    public Div profileHeadLine() {
        return new Div(getDriver(), "profile-headline", By.ByType.Id);
    }

    public void selectTab(String tabName) {
        new Link(getDriver(), tabName, By.ByType.linkText).click();
    }

    public void assignTemplate(String templateName) {
        Link templateLink = new Link(getDriver(), templateName, By.ByType.linkText);
        if (templateLink == null || !templateLink.isEnabled()) {
            Link assignTemplate = new Link(getDriver(), "Assign new onboarding template", By.ByType.linkText);
            if (assignTemplate != null) {
                assignTemplate.click();
                SelectItem templateList = new SelectItem(getDriver(), "template_id", By.ByType.Name);
                templateList.selectItem(templateName);
                Button assignButton = new Button(getDriver(), "div#modal-assign-template div.modal-footer button[type='submit']", By.ByType.CSS);
                assignButton.click();
                waitForAjaxAndJSToLOad();
                return;
            } else {
                throw new AssertionError("Created template:" + templateName + " is not listed for the employee");
            }
        }
        templateLink.click();
        waitForAjaxAndJSToLOad();
    }

    public boolean toDoListContains(String templateName) {
        Link toDoList = new Link(getDriver(), templateName, By.ByType.linkText);
        if (toDoList != null) {
            return true;
        }
        return false;
    }
}
