package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class GetAllLinksTest extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void  setup(ITestContext context){
        launchBrowser("chrome");
        driver = super.driver;
        context.setAttribute("webDriver", driver);
    }
    @Test
    public void verifyAllLinks() throws Exception {
        driver.navigate().to("https://amazon.in");
        //get all link tag
        List<WebElement> tagElements = driver.findElements(By.tagName("a"));
        ExtentReportUtil.getTest().info(String.valueOf(tagElements.size()));
        ExtentReportUtil.getTest().info("failed links are as follows:");
        for(WebElement element :tagElements){
             String link= element.getAttribute("href");
             if(link != null && !link.startsWith("javascript")){
                 //convert string url into actual url
                 URL url = new URL(link);
                 URLConnection connection = url.openConnection();
                 //convert urlconnection into httpurlconnection
                HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
                httpURLConnection.connect();
                int statusCode =  httpURLConnection.getResponseCode();
                //print broken urls
                 if( statusCode>299){
                     ExtentReportUtil.getTest().info(statusCode+ " " +link);
                 }
                 //close the connection
                 httpURLConnection.disconnect();
             }
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
