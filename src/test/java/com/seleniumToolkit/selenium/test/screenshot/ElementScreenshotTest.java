package com.seleniumToolkit.selenium.test.screenshot;

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.pageObject.Home;
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject;
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest;
import com.seleniumToolkit.selenium.framework.screenshot.core.Capture;
import com.seleniumToolkit.selenium.framework.screenshot.core.ScreenShootMaker;
import org.testng.annotations.Test;

import java.io.File;

public class ElementScreenshotTest extends AbstractScreenshotTest{

    @Test(groups = {"allTests", "screenshot"})
    @SeleniumTest()
    public void screenshot() {
        String screenshotFilePath = "screenshots/ElementScreenshotTest_screenshot.png";
        deleteFileIfExist(screenshotFilePath);
        Home home = AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();
        home.prepareFixedElementsForScreenshot();
        ScreenShootMaker.page.shoot(Capture.FULL_SCROLL).cropAround(home.solutionButton, 0, 0).withName("ElementScreenshotTest_screenshot").save();
        home.resetFixedElementsForScreenshot();

        File screenshotFile = new File(screenshotFilePath);
        ReportAssert.assertTrue(screenshotFile.exists(), "File should exist");
    }
}
