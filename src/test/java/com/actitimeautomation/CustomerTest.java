package com.actitimeautomation;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import com.actitimeautomation.common.PropertyHandling;
import com.actitimeautomation.pages.CustomerPage;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerTest extends BaseClass {

    WebDriver driver;
    PropertyHandling propertyHandling;
    CustomerPage customerPage;

    @BeforeClass
    public void setup(ITestContext context) throws Exception {
        propertyHandling = new PropertyHandling();
        String browser = propertyHandling.getProperty("browser");
        launchBrowser(browser);
        driver = super.driver;
        context.setAttribute("webDriver", driver);
        driver.get(propertyHandling.getProperty("actitimeUrl"));
        LoginPage loginPage= new LoginPage(driver);
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        loginPage.login(username, password);
        customerPage = new CustomerPage(driver);
    }

    @Test
    public void verifyCreateCustomer(){
        ExtentReportUtil.getTest().info("successfully logged in to application");
        customerPage.createCustomer("Cyber Success");
        customerPage.verifyCustomer("Cyber Success");
        ExtentReportUtil.getTest().info("newly created customer verified successfully");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
