package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.personio.automation.ui.web.By.by;

/* properties for application dialogue
 */
public class ModalDialogue extends Div {
    public ModalDialogue(RemoteWebDriver driver, String identifier) {
        super(driver, identifier);
    }

    public ModalDialogue(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        super(driver, identifier, identifierType);
        waitForVisibility();
    }

    public ModalDialogue(RemoteWebDriver driver, String identifier, By.ByType identifierType, int index) {
        super(driver, identifier, identifierType, index);
    }

    public ModalDialogue(RemoteWebDriver driver, WebElement element) {
        super(driver, element);
    }

    public ModalDialogue(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        super(driver, parentElement, identifier, identifierType);
    }

    public String getHeader() {
        return getElement().findElement(by(By.ByType.CSS, "h4.modal-title")).getText();
    }

    public void close() {
        new Button(getDriver(), getElement(), "button.close", By.ByType.CSS).click();
    }

    public void cancel() {
        new Button(getDriver(), getElement(), "button.btn.btn-default", By.ByType.CSS).click();
    }

    public void accept() {
        new Button(getDriver(), getElement(),"button.btn.btn-primary", By.ByType.CSS).getElement().click();
    }

    public Div dialogueContent() {
        return new Div(getDriver(), getElement(), "div.modal-body", By.ByType.CSS);
    }
}
