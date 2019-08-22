package com.personio.pom.pages;

import com.personio.automation.ui.type.html.Div;
import com.personio.automation.ui.type.html.Link;
import com.personio.automation.ui.web.Browser;
import com.personio.automation.ui.web.By;
import com.personio.automation.ui.web.Page;
import com.personio.pom.SubPages.OnBoardingPage;


public class SettingsPage extends Page {
    private OnBoardingPage onBoardingPage;

    public SettingsPage(Browser browser) {
        super(browser);
        waitForPage("Settings");
    }

    public Div statusMessage() {
        return new Div(getDriver(), "div#errorMessages div.alert.alert-success", By.ByType.CSS);
    }

    public void selectSettings(String settingsItem) {
        Link settingsItemLink = new Link(getDriver(), "a[data-test-id='settings-listitem-" + settingsItem + "']", By.ByType.CSS);
        settingsItemLink.click();
    }

    public OnBoardingPage onBoardingPage() {
        if (onBoardingPage == null) {
            onBoardingPage = new OnBoardingPage(getDriver());
        }
        return onBoardingPage;
    }
}
