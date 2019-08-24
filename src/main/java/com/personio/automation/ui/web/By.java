package com.personio.automation.ui.web;

import com.paulhammant.ngwebdriver.ByAngular;
import com.personio.automation.ui.AutomationError;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

    /*
        Creates selenium web element locators
   */
public class By extends org.openqa.selenium.By {


    public enum ByType {Id, Name, Class, CSS, Xpath, TagName, linkText, Model, Binding, Repeater}

    /*
        Creates selenium web element locators based on the provided identifier and locator type
   */
    public static org.openqa.selenium.By by(ByType identifierType, String identifier) {
        switch (identifierType) {
            case Id:
                return org.openqa.selenium.By.id(identifier);

            case Name:
                return org.openqa.selenium.By.name(identifier);

            case Class:
                return org.openqa.selenium.By.className(identifier);

            case CSS:
                return org.openqa.selenium.By.cssSelector(identifier);

            case Xpath:
                return org.openqa.selenium.By.xpath(identifier);

            case TagName:
                return org.openqa.selenium.By.tagName(identifier);

            case linkText:
                return org.openqa.selenium.By.linkText(identifier);

            case Model:
                return ByAngular.model(identifier);

            case Binding:
                return ByAngular.binding(identifier);

            case Repeater:
                return ByAngular.binding(identifier);

            default:
                throw new NoSuchElementException("Invalid element identifier type " + identifierType);
        }
    }

     /*
    Creates selenium web element locators based on the provided identifier.
    It will try to find the best match for the locator type
   */

    public static org.openqa.selenium.By by(RemoteWebDriver driver, String identifier) {
        if (identifier.contains(".") || identifier.contains("[")) {
            if (!driver.findElements(cssSelector(identifier)).isEmpty()) {
                return org.openqa.selenium.By.cssSelector(identifier);
            }
        }
        if (identifier.startsWith("//") && !driver.findElements(xpath(identifier)).isEmpty()) {

            return org.openqa.selenium.By.xpath(identifier);

        }

        if (identifier.startsWith("ng-")) {
            if (!driver.findElements(ByAngular.model(identifier)).isEmpty()) {
                return ByAngular.model(identifier);
            }
            if (!driver.findElements(ByAngular.repeater(identifier)).isEmpty()) {
                return ByAngular.repeater(identifier);
            }

            if (!driver.findElements(ByAngular.binding(identifier)).isEmpty()) {
                return ByAngular.binding(identifier);
            }
        }

        if (!driver.findElements(id(identifier)).isEmpty()) {
            return org.openqa.selenium.By.id(identifier);
        }

        if (!driver.findElements(name(identifier)).isEmpty()) {
            return org.openqa.selenium.By.name(identifier);
        }

        if (!driver.findElements(className(identifier)).isEmpty()) {
            return org.openqa.selenium.By.className(identifier);
        }

        if (!driver.findElements(linkText(identifier)).isEmpty()) {
            return org.openqa.selenium.By.linkText(identifier);
        }
        throw new NoSuchElementException("Element with identifier " + identifier + "is not found on the page ");
    }

    // never use this method. Declared for overriding the super class
    @Override
    public List<WebElement> findElements(SearchContext context) {
        throw new AutomationError("Do not use this method since it is declared for overriding the super class");
    }
}
