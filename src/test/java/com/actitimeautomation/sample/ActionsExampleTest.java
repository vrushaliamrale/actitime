package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsExampleTest extends BaseClass {
    WebDriver driver;
    @BeforeClass
    public void setup(ITestContext context) {
        launchBrowser("chrome");
        driver = super.driver;
        context.setAttribute("webDriver", driver);
    }

    @Test
    public void actionClassExamples() throws InterruptedException {
        driver.get("https://online.actitime.com/cybersuccess1/");
        Actions actions = new Actions(driver);
//        actions.contextClick(driver.findElement(By.id("username"))).build().perform();
        actions.sendKeys(driver.findElement(By.id("username")), "cst70_api@yopmail.com").build().perform();
        actions.sendKeys(driver.findElement(By.name("pwd")), "12345678").build().perform();
        actions.click(driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"))).build().perform();
//        actions.moveToElement(driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"))).click().build().perform();
        //wait for 5 sec
        Thread.sleep(5000);
        actions.click(driver.findElement(By.id("container_tasks"))).build().perform();
        //wait for 5 sec
        Thread.sleep(5000);
        //scroll to element and perform click operation using actions class
        actions.scrollToElement(driver.findElement(By.xpath("//div[text()='Big Bang Company' and @class='text']")))
                .click(driver.findElement(By.xpath("//div[text()='Big Bang Company' and @class='text']")))
                .build()
                .perform();
        ExtentReportUtil.getTest().info("click action performed successfully using scrollToElement method");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
