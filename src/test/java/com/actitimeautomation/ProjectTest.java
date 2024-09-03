package com.actitimeautomation;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.CommonUtil;
import com.actitimeautomation.common.ExtentReportUtil;
import com.actitimeautomation.common.PropertyHandling;
import com.actitimeautomation.pages.CustomerPage;
import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.pages.ProjectPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ProjectTest extends BaseClass {
    WebDriver driver;
    PropertyHandling propertyHandling;
    CustomerPage customerPage;
    LoginPage loginPage;
    ProjectPage projectPage;
    CommonUtil commonUtil;

    @BeforeClass
    public void setup(ITestContext context) throws Exception {
        propertyHandling = new PropertyHandling();
        String browser = propertyHandling.getProperty("browser");
        launchBrowser(browser);
        driver= super.driver;
        String url = propertyHandling.getProperty("actitimeUrl");
        driver.get(url);
        loginPage = new LoginPage(driver);
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        loginPage.login(username,password);
        customerPage = new CustomerPage(driver);
        projectPage =new ProjectPage(driver);
        commonUtil = new CommonUtil(driver);
        //set the driver context
        context.setAttribute("webDriver", driver);

    }
    @Test
    public void verifyCreateProject() throws Exception {
        commonUtil.waitForElementClickable(customerPage.taskModule);
        //take screenshot
        //commonUtil.takeScreenShot("verifyCreateProject");
        ExtentReportUtil.getTest().info("click on task module");
        //click task module
        driver.findElement(customerPage.taskModule).click();
        //click on Add New button
        ExtentReportUtil.getTest().info("click on add new button");
        driver.findElement(customerPage.addNewButton).click();
        //click on New Project
        projectPage.createNewProjectButton.click();
        //Complete  rest of the code to create project and verify the same
        ExtentReportUtil.getTest().info("project created successfully");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
