package com.seleniumToolkit.selenium.test;

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.pageObject.GetStarted;
import com.seleniumToolkit.selenium.pageObject.Home;
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject;
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class DependencyTest_Startseite {


    @Test(groups = {"allTests", "dependencyTests"})
    @SeleniumTest()
    @Feature("DependencyTest")
    public void buttonGetStartedWorked(){
        Home home = AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();
        ReportAssert.assertEquals(home.getTextOfTitle(),"How Easy To Run Selenium Tests?", "Should Fail to demonstrate Skip-Test");
        GetStarted getStarted = home.topMenuPageObject.clickGetStartedMenu();
        getStarted.waitUntilUrlContains(getStarted.URL);
        ReportAssert.assertEquals(getStarted.getTextOfTitle(),"Contact.", "Should Fail to demonstrate Skip-Test");
    }

    @Test(groups = {"allTests", "dependencyTests"}, dependsOnMethods = "buttonGetStartedWorked")
    @SeleniumTest()
    @Feature("DependencyTest")
    public void shouldFail(){
        Home home = AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();
        ReportAssert.assertEquals(home.getTextOfTitle(),"Fail", "Should Fail to demonstrate Skip-Test");
    }

    @Test(groups = {"allTests", "dependencyTests"}, dependsOnMethods = "shouldFail")
    @SeleniumTest()
    @Feature("DependencyTest")
    public void skippedBecauseDepends(){
        Home home = AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();
        ReportAssert.assertEquals(home.getTextOfTitle(),"Should not be executed because the dependency");
    }

}
