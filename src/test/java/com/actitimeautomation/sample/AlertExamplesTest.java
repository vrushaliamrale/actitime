package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertExamplesTest extends BaseClass {
    WebDriver driver;
    @BeforeClass
    public void setup(ITestContext context){
        launchBrowser("firefox");
        driver= super.driver;
        context.setAttribute("webDriver",driver);
    }
    @Test
    public void verifyAlerts() throws InterruptedException {
        driver.get("http://google.com");

        //type cast driver var into JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("prompt('This is a sample alert !');");

        Thread.sleep(10000);

        //accept the alert
//        driver.switchTo().alert().accept();

        //dismiss the alert
//        driver.switchTo().alert().dismiss();


        Alert  alert = driver.switchTo().alert();

        //enter the text
        alert.sendKeys("Hello");

        //get the text of alert
        String text = alert.getText();

        ExtentReportUtil.getTest().info(text);

//        driver.switchTo().alert().accept();

   }
   @AfterClass
    public void tearDown(){
        driver.quit();
   }

}
