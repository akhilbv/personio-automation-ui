package com.personio.pom.tabs;

import com.personio.automation.ui.type.html.*;
import com.personio.automation.ui.web.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/*Properties of On boarding steps page
 */
public class OnBoardingStepsTab extends Div {

    public OnBoardingStepsTab(RemoteWebDriver driver) {
        super(driver, "div.tab-pane.active", By.ByType.CSS);
    }

    public TextField stepName() {
        return new TextField(getDriver(), "input[name='step_name']", By.ByType.CSS);
    }

    public Button addStepButton() {
        return new Button(getDriver(), "button[type='submit']", By.ByType.CSS);
    }

    public ListItem stepList() {
        return new ListItem(getDriver(), "step_list", By.ByType.Id);
    }

    public Link addItemLink() {
        return new Link(getDriver(), getElement(), "div.block-section.tab-pane.active a[href='#modal-add-item']", By.ByType.CSS);
    }

    public ModalDialogue addStepDialogue() {
        return new ModalDialogue(getDriver(), "div#modal-add-item div.modal-content", By.ByType.CSS);
    }

    public ModalDialogue dialogue() {
        return new ModalDialogue(getDriver(), "div.modal-content", By.ByType.CSS);
    }

    public Select itemType() {
        WebElement select = new SelectItem(getDriver(), "item_type", By.ByType.Name).getElement();
        return new Select(select);
    }

    public Table stepItemsTable() {
        return new Table(getDriver(), getElement(), "div.block-section.tab-pane.active table tbody", By.ByType.CSS);
    }

    public Button saveChanges() {
        return new Button(getDriver(), getElement(), "div.block-section.tab-pane.active button.btn.btn-sm.btn-primary", By.ByType.CSS);
    }

    public Button deleteButton() {
        return new Button(getDriver(), "div.block-section.tab-pane.active a[href='#modal-delete-step'] i", By.ByType.CSS);
    }

    public ModalDialogue deleteConfirmation() {
        return new ModalDialogue(getDriver(), "div#modal-delete-step div.modal-content", By.ByType.CSS);
    }

    public void deleteSteps(String stepName) {
        while(stepList().contains(stepName)) {
            stepList().getListItem(stepName).click();
            deleteButton().click();
            deleteConfirmation().delete().click();
        }
    }

    public void deleteStep(String stepName) {
        if (stepList().contains(stepName)) {
            stepList().getListItem(stepName).click();
        }
        deleteButton().click();
    }

}
