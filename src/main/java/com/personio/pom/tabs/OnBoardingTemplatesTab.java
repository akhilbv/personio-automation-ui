package com.personio.pom.tabs;

import com.personio.automation.ui.type.html.*;
import com.personio.automation.ui.web.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OnBoardingTemplatesTab extends Div {

    public OnBoardingTemplatesTab(RemoteWebDriver driver) {
        super(driver, "div.tab-pane.active", By.ByType.CSS);
    }

    public TextField templateName() {
        return new TextField(getDriver(), "template_name", By.ByType.Name);
    }

    public ListItem templateList() {
        return new ListItem(getDriver(), "template_list", By.ByType.Id);
    }

    public Link addStepLink() {
        return new Link(getDriver(), getElement(), "div.block-section.tab-pane.active a[href='#modal-add-step']", By.ByType.CSS);
    }

    public Button addTemplateButton() {
        return new Button(getDriver(), getElement(), "button.btn.btn-primary", By.ByType.CSS);
    }

    public ModalDialogue addStepDialogue() {
        return new ModalDialogue(getDriver(), "div#modal-add-step div.modal-content", By.ByType.CSS);
    }

    public SearchSelect stepList() {
        return new SearchSelect(getDriver(), "step_id", By.ByType.Name);
    }

    public SelectItem responsible() {
        return new SelectItem(getDriver(), "responsible", By.ByType.Name);
    }

    public TextField deadLine() {
        return new TextField(getDriver(), "due_date_offset", By.ByType.Name);
    }

    public SelectItem deadlineDirection() {
        return new SelectItem(getDriver(), "offset_direction", By.ByType.Name);
    }

    public Table addedSteps()
    {
        return new Table(getDriver(),getElement(),"div.block-section.tab-pane.active table tbody", By.ByType.CSS);
    }
}
