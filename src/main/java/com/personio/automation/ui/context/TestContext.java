package com.personio.automation.ui.context;

import com.personio.automation.ui.web.Browser;
import com.personio.pom.NavigationSideBar;
import com.personio.pom.pages.DashBoard;
import com.personio.pom.pages.EmployeesPage;
import com.personio.pom.pages.LoginPage;
import com.personio.pom.pages.SettingsPage;

/*
    Test Context which manages the test. Entry point for initialising the browser sessions
*/
public class TestContext {
    public static Browser browser;
    public String userName;
    private DashBoard dashBoard;
    private LoginPage loginPage;
    private NavigationSideBar navigationSideBar;
    private SettingsPage settingsPage;
    private EmployeesPage employeesPage;

    // initialising the browser session if test context is not initialised with browser
    public TestContext() {
        if (TestContext.browser == null) {
            TestContext.browser = new Browser();
        }
    }

    // for accessing the initialised browser object to other classes
    public static Browser getBrowser() {
        return TestContext.browser;
    }

    // For quitting the browser session. executes after the test scenario
    public static void testTearDown() {
        if (getBrowser() != null) {
            getBrowser().quitDriver();
            TestContext.browser = null;
        }
    }

    // Initialising the object for Login page to access the properties
    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(getBrowser());
        }
        return loginPage;
    }

    // Initialising the object for Home page to access the properties
    public DashBoard dashBoard() {
        if (dashBoard == null) {
            dashBoard = new DashBoard(getBrowser());
        }
        return dashBoard;
    }

    public NavigationSideBar navigationSideBar()
    {
        if(navigationSideBar == null)
        {
            navigationSideBar = new NavigationSideBar(getBrowser().getDriver());
        }
        return navigationSideBar;
    }

    public SettingsPage settingsPage()
    {
        if (settingsPage == null)
        {
            settingsPage = new SettingsPage(getBrowser());
        }
        return settingsPage;
    }

    public EmployeesPage employeesPage()
    {
        if (employeesPage == null)
        {
            employeesPage = new EmployeesPage(getBrowser());
        }
        return employeesPage;
    }
}
