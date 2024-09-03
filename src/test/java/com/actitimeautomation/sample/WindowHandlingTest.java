package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowHandlingTest extends BaseClass {

    WebDriver driver;

    @BeforeClass
    public void setup(ITestContext context) {
        launchBrowser("chrome");
        driver = super.driver;
        context.setAttribute("webDriver", driver);
    }

    @Test
    public void verifyWindowsSwitches() {
        //navigate to website
        driver.navigate().to("https://online.actitime.com/cybersuccess1/login.do");
        //get the id of current page
        String parentTabId = driver.getWindowHandle();
        //open new window
        driver.switchTo().newWindow(WindowType.WINDOW);
    /*
        //open new tab
        driver.switchTo().newWindow(WindowType.TAB);
    */
        driver.navigate().to("https://redbus.in");

        //print title of current page
        ExtentReportUtil.getTest().info(driver.getTitle());

        //print the url of page
        String url = driver.getCurrentUrl();
        ExtentReportUtil.getTest().info(url);

        //close the current tab
        driver.close();

        //switch control to default page
        driver.switchTo().window(parentTabId);

        //print the parent page title
        ExtentReportUtil.getTest().info(driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
