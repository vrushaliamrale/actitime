package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropExampleTest extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setup(ITestContext context){
        launchBrowser("chrome");
        driver= super.driver;
        context.setAttribute("webDriver", driver);
    }
    @Test
    public void verifyDragAndDrop() throws InterruptedException {
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        //wait for 5 sec
        Thread.sleep(5000);
        String  windowId = driver.getWindowHandle();
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@rel-title='Photo Manager']//iframe")));
//        driver.switchTo().frame(1);
//        driver.switchTo().frame("")
       WebElement srcElement= driver.findElement(By.xpath("//ul[@id='gallery']/li[1]/img"));
       WebElement dstElement = driver.findElement(By.id("trash"));
        Actions actions = new Actions(driver);
//        actions.clickAndHold(srcElement).release(dstElement).build().perform();
        actions.dragAndDrop(srcElement,dstElement).build().perform();
        ExtentReportUtil.getTest().info("drag and drop performed successfully from source to dest");
        //switch control back to webpage
        driver.switchTo().window(windowId);
        ExtentReportUtil.getTest().info(driver.getTitle());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
