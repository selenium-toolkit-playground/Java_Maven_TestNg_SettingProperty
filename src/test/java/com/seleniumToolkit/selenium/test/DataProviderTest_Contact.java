package com.seleniumToolkit.selenium.test;

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.helper.ExcelAdapter;
import com.seleniumToolkit.selenium.pageObject.GetStarted;
import com.seleniumToolkit.selenium.pageObject.Home;
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject;
import org.testng.annotations.DataProvider;
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import io.qameta.allure.Feature;

public class DataProviderTest_Contact {

    @Test(groups = {"allTests", "dependencyTests", "dataProvider"}, dataProvider = "contactProvider")
    @SeleniumTest()
    @Feature("DataProvider")
    public void contactWithStandardDataproviderParallel(String name
                                               ,String email
                                               ,String phone
                                               ,String message
                                               ,int errorSize){
        testContact(name, email, phone, message, errorSize);
    }

    @Test(groups = {"allTests", "dependencyTests", "dataProvider"}, dataProvider = "contactProviderFromExcel")
    @SeleniumTest()
    @Feature("DataProvider")
    public void contactWithExcelDataproviderNotParallel(String name
                                               ,String email
                                               ,String phone
                                               ,String message
                                               ,int errorSize){
        testContact(name, email, phone, message, errorSize);
    }

    private void testContact(String name
            ,String email
            ,String phone
            ,String message
            ,int errorSize){
        Home home = AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();

        GetStarted getStarted = home.topMenuPageObject.clickGetStartedMenu();

        if(Strings.isNotNullAndNotEmpty(name)){
            getStarted.enterName(name);
        }
        if(Strings.isNotNullAndNotEmpty(email)){
            getStarted.enterEmail(email);
        }
        if(Strings.isNotNullAndNotEmpty(phone)){
            getStarted.enterPhoneNumber(phone);
        }
        if(Strings.isNotNullAndNotEmpty(message)){
            getStarted.enterMessage(message);
        }
        getStarted.clickSubmitButton();
        ReportAssert.assertEquals(getStarted.getErrorFieldSize(), errorSize, "Test the Size of Errorlist");
    }
    
    @DataProvider(parallel = true)
    public Object[][] contactProvider() {
        return new Object[][]{
                {"Michel", "no Vailid", "052 000 00 00", "", 3},
                {"Michel", "info@selenium-toolkit.com", "", "", 2},
        };
    }

    @DataProvider(parallel = false)
    public Object[][] contactProviderFromExcel() throws Exception {
        Object[][] testObjArray = ExcelAdapter.getTableArray("testdata/contactInput.xlsx","Daten");
        return (testObjArray);
    }

}
