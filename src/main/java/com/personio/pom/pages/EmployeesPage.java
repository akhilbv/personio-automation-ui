package com.personio.pom.pages;

import com.personio.automation.ui.type.html.Button;
import com.personio.automation.ui.type.html.Link;
import com.personio.automation.ui.type.html.TextField;
import com.personio.automation.ui.web.Browser;
import com.personio.automation.ui.web.By;
import com.personio.automation.ui.web.Page;

public class EmployeesPage extends Page {
    private Browser browser;
    private EmployeeProfilePage employeeProfilePage;

    public EmployeesPage(Browser browser) {
        super(browser);
        this.browser = browser;
    }

    public EmployeeProfilePage employeeProfilePage() {
        return new EmployeeProfilePage(browser);
    }

    public TextField employeeSearchBox() {
        return new TextField(getDriver(), "div#staff_table_filter input[type='search']", By.ByType.CSS);
    }

    public Button searchButton() {
        return new Button(getDriver(), "search-button", By.ByType.Id);
    }

    public void searchForEmployee(String employeeName) {
        employeeSearchBox().sendKeys(employeeName);
        searchButton().click();
        waitForAjaxAndJSToLOad();
    }

    public void selectEmployeeProfile(String employeeName) {
        Link employeeLink = new Link(getDriver(), employeeName, By.ByType.linkText);
        employeeLink.click();
        waitForAjaxAndJSToLOad();
    }
}
