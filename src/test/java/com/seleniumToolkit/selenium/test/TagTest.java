package com.seleniumToolkit.selenium.test;

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.pageObject.GetStarted;
import com.seleniumToolkit.selenium.pageObject.Home;
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject;
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest;
import org.testng.annotations.Test;

public class TagTest {

    @Test(groups = {"allTests"})
    @SeleniumTest(browser = "browserName=chrome,browserName=firefox")
    public void sample() {
        Home home = AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();
        ReportAssert.assertEquals(home.getTextOfTitle(), "How Easy To Run Selenium Tests?");

        GetStarted getStarted = home.topMenuPageObject.clickGetStartedMenu();
        getStarted.enterName("Michel");
    }
}
