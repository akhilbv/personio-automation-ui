package com.personio.automation.ui.type.html;

import com.personio.automation.ui.web.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import static com.personio.automation.ui.web.By.by;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

/*Base class for the Html elements.
 * Extend this class to get the basic html properties for an element*/

public class BaseHtmlElement {
    private WebElement element;
    private RemoteWebDriver driver;
    private WebElement parentElement;
    private String identifier;
    private By.ByType identifierType;
    private String elementId = null;
    private int actionWaitTimeout;
    private int elementWaitTimeout;

    private static final Logger LOGGER = Logger.getLogger("automation");

    /*Identifying the element based on the wild search.
     *The method will try to find the element using all identifiers and will return based on teh best match
     * */
    public BaseHtmlElement(RemoteWebDriver driver, String identifier) {
        this.driver = driver;
        this.identifier = identifier;
        try {
            this.element = this.driver.findElement(by(driver, identifier));
        } catch (NoSuchElementException | NullPointerException ex) {
            throw new AssertionError("Element with identifier " + identifier + " is not found");
        }

        getProperties();
    }

    /*
    Identifying the element based on identifier and type
    */

    public BaseHtmlElement(RemoteWebDriver driver, String identifier, By.ByType identifierType) {
        this.driver = driver;
        this.identifier = identifier;
        this.identifierType = identifierType;

        try {
            this.element = this.driver.findElement(by(identifierType, identifier));
        } catch (NoSuchElementException | NullPointerException ex) {
            this.element = null;
        }

        getProperties();
    }

    /*
    Identifying the element based on identifier and index
     */
    public BaseHtmlElement(RemoteWebDriver driver, String identifier,By.ByType identifierType, int index) {
        this.driver = driver;
        this.identifier = identifier;

        List<WebElement> elements = this.driver.findElements(by(identifierType, identifier));
        if (elements.size() > index) {
            this.element = elements.get(index);
        } else {
            element = null;
        }

        getProperties();
    }

    /*
    Initialising the base element with another which was already found
    */
    public BaseHtmlElement(RemoteWebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
        this.identifier = null;

        getProperties();
    }

    /*
    Identifying the child element from the parent element
    */
    public BaseHtmlElement(RemoteWebDriver driver, WebElement parentElement, String identifier, By.ByType identifierType) {
        this.driver = driver;
        this.parentElement = parentElement;
        this.identifier = identifier;
        this.identifierType = identifierType;

        try {
            this.element = this.parentElement.findElement(by(identifierType, identifier));
        } catch (NoSuchElementException | NullPointerException ex) {
            this.element = null;
        }
        getProperties();
    }

    /*
    For getting the timeout required to wait after any actions eg: mouse click , key board event etc
*/
    public int getActionWaitTimeOut() {
        if (actionWaitTimeout == 0) {
            getProperties();
        }
        return actionWaitTimeout;
    }

    public WebElement getElement() {
        return this.element;
    }

    public RemoteWebDriver getDriver() {
        return this.driver;
    }

    public WebElement getParentElement() {
        return this.element.findElement(xpath(".."));
    }

    /*
    For scrolling to the base element
    */
    public void scrollIntoView() {
        JavascriptExecutor javascriptExecutor = driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement());
    }

    /*
    For scrolling to the given element
    */
    public void scrollIntoView(WebElement element) {
        JavascriptExecutor javascriptExecutor = driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /*
    For entering text to an element
    */
    public void sendKeys(String textTobeEnter) {
        waitForVisibility();
        scrollIntoView();
        getElement().sendKeys(textTobeEnter);
    }

    /*
    For entering the keyboard keys
    */
    public void sendKeys(CharSequence keys) {
        scrollIntoView();
        Actions action = new Actions(driver);
        action.sendKeys(getElement(), keys).build().perform();
    }

    /*
    For Mouse click on the element using the actions
    */
    public void mouseClick() {
        scrollIntoView();
        WebDriverWait clickWait = new WebDriverWait(this.driver, this.getActionWaitTimeOut());
        clickWait.until(ExpectedConditions.elementToBeClickable(this.getElement()));
        Actions action = new Actions(driver);
        action.moveToElement(getElement())
                .click().build().perform();
    }

    /*
    For clicking on the element
    */
    public void click() {
        WebDriverWait clickWait = new WebDriverWait(this.driver, this.getActionWaitTimeOut());
        this.element = clickWait.until(ExpectedConditions.presenceOfElementLocated(by(identifierType,identifier)));
        Actions actions = new Actions(this.driver);
        actions.moveToElement(this.element).click().perform();
    }


    public String getElementId() {
        if (elementId == null) {
            this.getElement().getAttribute("id");
        }
        return elementId;
    }

    public String getValue() {
        return getElement().getText();
    }

    public String getTitle() {
        return getElement().getAttribute("title");
    }

    public String getAttribute(String attribute) {
        return getElement().getAttribute(attribute);
    }

    /*
   returns whether a field is visible or not
   */
    public boolean isVisible() {
        if (this.element != null)
            return element.isDisplayed();
        else
            return false;
    }

    /*
    wait for the presence of  element in dom untill timeout
    */
    public void waitForLoad() {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, this.elementWaitTimeout);
            this.element = wait.until(ExpectedConditions.presenceOfElementLocated(By.by(identifierType, identifier)));
        } catch (NullPointerException | NoSuchElementException ex) {
            throw new AssertionError("Element not loaded within " + elementWaitTimeout + " seconds");
        }
    }

    /*
    wait for the visibility of element until timeout
     */
    public void waitForVisibility() {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, this.elementWaitTimeout);
            this.element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.by(identifierType, identifier)));
        } catch (NullPointerException | NoSuchElementException ex) {
            throw new AssertionError("Element not visible within " + elementWaitTimeout + " seconds");
        }
    }

    /*
    For setting the wait timeouts
     */
    public void getProperties() {

        try {
            ResourceBundle configProperties = ResourceBundle.getBundle("config");
            String actionWait = System.getProperty("actionWaitTimeout");
            String elementWait = System.getProperty("elementWaitTimeout");
            if (actionWait == null) {
                actionWait = configProperties.getString("actionWaitTimeout");
            }
            if (elementWait == null) {
                elementWait = configProperties.getString("elementWaitTimeout");
            }

            actionWaitTimeout = Integer.parseInt(actionWait);
            elementWaitTimeout = Integer.parseInt(elementWait);
        } catch (MissingResourceException ex) {
            actionWaitTimeout = 20;
            elementWaitTimeout = 20;
            LOGGER.info("Unable to find the config.properties. " + actionWaitTimeout + " seconds set as wait timeout");
        }
    }

}
