package com.personio.pom.pages;

import com.personio.automation.ui.type.html.Link;
import com.personio.automation.ui.web.Browser;
import com.personio.automation.ui.web.By;
import com.personio.automation.ui.web.Page;


public class SettingsPage extends Page {
    public SettingsPage(Browser browser) {
        super(browser);
        waitForPage("Settings");
    }

    public void selectSettings(String settingsItem) {
        Link settingsItemLink = new Link(getDriver(), "a[data-test-id='settings-listitem-" + settingsItem + "']", By.ByType.CSS);
        settingsItemLink.click();
    }


}
