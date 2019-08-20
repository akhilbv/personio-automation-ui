package com.personio.pom;

import com.personio.automation.ui.type.html.Div;
import com.personio.automation.ui.type.html.Link;
import com.personio.automation.ui.web.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationSideBar extends Div {

    public NavigationSideBar(RemoteWebDriver driver) {

        super(driver, "sidebar", By.ByType.Id);
    }

    public Link configurationSettings() {
        return new Link(getDriver(), "a[data-test-id='navsidebar-settings']", By.ByType.CSS);
    }

    public void selectNavItem(String navItem)
    {
        Link navItemLink = new Link(getDriver(),getElement(),"a[data-test-id='navsidebar-"+navItem+"']", By.ByType.CSS);
        navItemLink.click();
    }
}
