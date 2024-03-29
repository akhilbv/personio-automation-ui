package com.personio.pom.pages;

import com.personio.automation.ui.web.Browser;
import com.personio.automation.ui.web.By;
import com.personio.automation.ui.web.Page;

/*
   Page Class for Dashboard
*/
public class DashBoard extends Page {
    public DashBoard(Browser browser) {
        super(browser);
        waitForPage("Dashboard");
        waitForAjaxAndJSToLOad();
        waitForElement(By.ByType.Id, "dashboard-v2-container");
    }
}
