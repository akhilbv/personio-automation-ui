package com.personio.pom.SubPages;

import com.personio.automation.ui.type.html.Div;

import com.personio.automation.ui.type.html.ListItem;
import com.personio.automation.ui.web.By;
import com.personio.pom.tabs.OnBoardingStepsTab;
import org.openqa.selenium.remote.RemoteWebDriver;

/* Properties for on boarding page
 */
public class OnBoardingPage extends Div {

    public OnBoardingPage(RemoteWebDriver driver) {
        super(driver, "employee_details_tab", By.ByType.Id);
    }

    public ListItem Tab(String tabName) {
        return new ListItem(getDriver(), getElement(), "//li/a[contains(text(),'" + tabName + "')]", By.ByType.Xpath);
    }

    public OnBoardingStepsTab onBoardingStepsTab() {
      return new OnBoardingStepsTab(getDriver());
    }
}
