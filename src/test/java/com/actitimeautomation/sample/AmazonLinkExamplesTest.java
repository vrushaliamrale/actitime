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

import java.util.List;

public class AmazonLinkExamplesTest extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setup(ITestContext context) {
        launchBrowser("chrome");
        driver = super.driver;
        context.setAttribute("webDriver", driver);
    }

    @Test
    public void verifyLinks() throws InterruptedException {
        driver.navigate().to("https://amazon.in");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Electronics");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(5000);
        List<WebElement> itemsNames = driver.findElements(By.xpath("//div[starts-with(@cel_widget_id,'MAIN-SEARCH_RESULTS')]/descendant::h2//span"));

        List<WebElement> itemsPrice = driver.findElements(By.xpath("//div[starts-with(@cel_widget_id,'MAIN-SEARCH_RESULTS')]/descendant::span[@class='a-price']/span[2]"));

        if (itemsNames.size() == itemsPrice.size()) {

            for (int i = 0; i < itemsPrice.size(); i++) {

                WebElement priceElement = itemsPrice.get(i);

                String price = priceElement.getText();

                WebElement nameElement = itemsNames.get(i);

                String name = nameElement.getText();

                ExtentReportUtil.getTest().info(price + " " + name);

                System.out.println();

            }
        }

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
