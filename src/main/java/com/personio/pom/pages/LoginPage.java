package com.personio.pom.pages;

        import com.personio.automation.ui.type.html.Button;
        import com.personio.automation.ui.type.html.TextField;
        import com.personio.automation.ui.web.Browser;
        import com.personio.automation.ui.web.By;
        import com.personio.automation.ui.web.Page;

/*
   Page Class for Login page
*/
public class LoginPage extends Page {
    private TextField userName;
    private TextField password;
    private Button login;

    public LoginPage(Browser browser) {
        super(browser);
        waitForPage("Personio");
    }

    private TextField userName() {
        if (userName == null) {
            userName = new TextField(getDriver(), "email", By.ByType.Id);
        }
        return userName;
    }

    private TextField password() {
        if (password == null) {
            password = new TextField(getDriver(), "password", By.ByType.Id);
        }
        return password;
    }

    private Button loginButton() {
        if (login == null) {
            login = new Button(getDriver(), "button[type=submit]", By.ByType.CSS);
        }
        return login;
    }

    /*
      For login to the application
   */
    public void login(String userName, String password) {
        userName().sendKeys(userName);
        password().sendKeys(password);
        loginButton().click();
    }
}
