package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsOperationsTest extends BaseClass {

    WebDriver driver;
    @BeforeClass
    public void setup(ITestContext context){
        launchBrowser("chrome");
        driver = super.driver;
        context.setAttribute("webDriver", driver);
    }
    @Test
    public void verifyWindowHandling(){
        //navigate to website
        driver.navigate().to("https://online.actitime.com/cybersuccess1/login.do");
        driver.findElement(By.linkText("actiTIME Inc.")).click();
        String parentWindowId=  driver.getWindowHandle();
        ExtentReportUtil.getTest().info(parentWindowId);
        //get all window/tab ids
        Set<String> allWindowIds=  driver.getWindowHandles();
        ExtentReportUtil.getTest().info(allWindowIds.toString());
        //iterate through all ids
        for(String id :  allWindowIds){
            //check if id is not equals with parentId
            if(!id.equals(parentWindowId)){
                ExtentReportUtil.getTest().info("Second Tab Id: " + id);
                //switch to second tab
                driver.switchTo().window(id);
                //print the title
                String childWindowTitle= driver.getTitle();
                ExtentReportUtil.getTest().info(childWindowTitle);
                //close second tab
                driver.close();
                break;
            }
        }
        //switch control back to parent tab
        driver.switchTo().window(parentWindowId);
//        driver.switchTo().defaultContent();
        //get the title of parent tab
        ExtentReportUtil.getTest().info("Parent tab title :  "+driver.getTitle());
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
