package com.seleniumToolkit.selenium.test;

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject;
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest;

import io.qameta.allure.Feature;
import com.seleniumToolkit.selenium.framework.driver.WebDriverManager;
import org.testng.annotations.Test;

public class EnabledFalseTest {

    @Test(groups = {"allTests"}, enabled = false)
    @SeleniumTest()
    @Feature("Enabled False")
    public void webseiteVerfügbar(){
        AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();
        ReportAssert.assertEquals(WebDriverManager.getWebdriver().getTitle(), "Selenium-Toolkit");
    }

}
