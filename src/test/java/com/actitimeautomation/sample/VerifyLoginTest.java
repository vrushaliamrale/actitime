package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.CommonUtil;
import com.actitimeautomation.common.ExtentReportUtil;
import com.actitimeautomation.common.PropertyHandling;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class VerifyLoginTest extends BaseClass {

    WebDriver driver;
    LoginPage loginPage;
    CommonUtil commonUtil;
    PropertyHandling propertyHandling;

    @BeforeClass
    public void setup(ITestContext context) throws IOException {
        propertyHandling = new PropertyHandling();
        String browser = propertyHandling.getProperty("browser");
        launchBrowser(browser);
        driver = super.driver;
        String url = propertyHandling.getProperty("actitimeUrl");
        driver.navigate().to(url);
        loginPage = new LoginPage(driver);
        commonUtil = new CommonUtil(driver);
        context.setAttribute("webDriver",driver);
    }

    @Test
    public void verifyLogin() throws Exception {
        String username =propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        loginPage.login(username, password);
        commonUtil.waitForElementToPresent(By.xpath("//span[starts-with(text(),'Username or Password')]"));
        String errorMsg1 = driver.findElement(By.xpath("//span[starts-with(text(),'Username or Password')]")).getText();
        ExtentReportUtil.getTest().info(errorMsg1);
        //Verify error message through Soft Assertion
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(errorMsg1, "Username or Password is invalid. Please try again...");
        //Verify error message through hard Assertion
//        Assert.assertEquals(errorMsg1, "Username or Password is invalid. Please try again...")
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
