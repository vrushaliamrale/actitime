package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.CommonUtil;
import com.actitimeautomation.common.ExtentReportUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class VerifyAllLabelsTest extends BaseClass {
    WebDriver driver;
    CommonUtil commonUtil;

    @BeforeClass
    public void setup(ITestContext context) {
        launchBrowser("chrome");
        driver = super.driver;
        driver.navigate().to("https://www.amazon.in/");
        commonUtil = new CommonUtil(driver);
        context.setAttribute("webDriver", driver);
    }

    @Test
    public void verifyAllLabels() {
        commonUtil.waitForAllElementToVisible(By.tagName("input"));
        //get all label elements
        List<WebElement> labelList = driver.findElements(By.tagName("input"));
        ExtentReportUtil.getTest().info(String.valueOf(labelList.size()));
        //iterate through each label element
        for (WebElement element : labelList) {
            String label = element.getAttribute("placeholder");
            if (label != null && !label.isBlank()) {
                ExtentReportUtil.getTest().info(label);
            }
        }

    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
