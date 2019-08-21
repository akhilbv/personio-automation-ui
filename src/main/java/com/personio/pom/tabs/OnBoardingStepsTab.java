package com.personio.pom.tabs;

        import com.personio.automation.ui.type.html.*;
        import com.personio.automation.ui.web.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.openqa.selenium.support.ui.Select;

/*Properties of On boarding steps page
 */
public class OnBoardingStepsTab extends Div {

    public OnBoardingStepsTab(RemoteWebDriver driver) {
        super(driver, "tab-pane.active", By.ByType.CSS);
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
        return new Link(getDriver(), getElement(), "a[href='#modal-add-item']", By.ByType.CSS);
    }

    public ModalDialogue addStepDialogue() {
        return new ModalDialogue(getDriver(), "div#modal-add-item div.modal-content", By.ByType.CSS);
    }

    public Select itemType() {
        WebElement select = new SelectItem(getDriver(), "item_type", By.ByType.Name).getElement();
        return new Select(select);
    }

    public TextArea stepItemTextArea(int index,String stepName) {
        return new TextArea (getDriver(), "//div[./h4[contains(text(), '" + stepName + "')]]//textarea", By.ByType.Xpath, index);
    }
}
