package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptExamplesTest extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setup(ITestContext context) {
        launchBrowser("chrome");
        driver = super.driver;
        context.setAttribute("webDriver", driver);
    }

    @Test
    public void verifyJavaScripts() {
        driver.get("https://online.actitime.com/cybersuccess1/");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        //type cast driver var into JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //enter text using javascript
        js.executeScript("arguments[0].value='test@yopmail.com';", driver.findElement(By.id("username")));
//        //get the title of the page
        String title = js.executeScript("return document.title;").toString();
        ExtentReportUtil.getTest().info(title);
//        js.executeScript("arguments[0].click();",driver.findElement(By.id("loginButton")));
//        js.executeScript("arguments[0].click();",loginButton);
/*
        driver.get("https://amazon.in");
        //scroll down using javascript
        js.executeScript("window.scrollBy(0,1000);");
        //scroll up using javascript
        js.executeScript("window.scrollBy(0,-500);");
        //scroll to the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
*/
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
