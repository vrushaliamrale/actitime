package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import com.actitimeautomation.pages.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TaskTests extends BaseClass {
    WebDriver driver;
    ExtentTest extentTest = ExtentReportUtil.objectMap.get("extentTest");

    @BeforeClass
    public void setup(ITestContext context) {
        launchBrowser("chrome");
        driver = super.driver;
        context.setAttribute("webDriver", driver);
    }

    @Test
    public void verifyTasks() throws Exception {
        driver.manage().window().minimize();

        //Navigate to website
        driver.get("https://online.actitime.com/successautomation/");

        //create object of LoginPage class
        LoginPage loginPage = new LoginPage(driver);

        //perform login operation
        loginPage.login("successautomation@yopmail.com", "Test@1234");

        //wait for 5 sec
        Thread.sleep(5000);

        //click on Tasks module
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();

        //wait for 5 sec
        Thread.sleep(5000);

        //locate select all check box and verify it is displayed
        boolean selectAllCheckbox = driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).isDisplayed();


        if (selectAllCheckbox) {
            //click on select all check box
            driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).click();

            //wait for 5 sec
            Thread.sleep(5000);

            //verify check box is selected or not
            boolean selectedCheckbox = driver.findElement(By.xpath("//table[@class='taskRowsTable']/descendant::tr[1]//div[@class='img']")).isSelected();

            if (selectedCheckbox) {
                extentTest.info("All check boxes are selected.....");
            } else {
                extentTest.info("Unable to select all checkboxes....");
            }
        } else {

            extentTest.info("The select all check box is not displayed on screen hence cannot perform further action...");
        }


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
