package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExcelHandling;
import com.actitimeautomation.common.ExtentReportUtil;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetAndInsertAllCustomersInExcelTest extends BaseClass {
    WebDriver driver;
    @BeforeClass
    public void setup(ITestContext context) {
        launchBrowser("chrome");
        driver = super.driver;
        context.setAttribute("webDriver", driver);
    }
    @Test
    public void verifyExcelInsertOperation() throws Exception {
        driver.get("https://online.actitime.com/cybersuccess1/login.do");
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("cst70_api@yopmail.com","12345678");
        //wait for 5 sec
        Thread.sleep(5000);
        //click on tasks module
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(5000);
        //get all customer names
        List<WebElement> allCustomers =driver.findElements(By.xpath("//div[contains(@class, 'customerNode')]//div[@class='text']"));
        ExtentReportUtil.getTest().info(String.valueOf(allCustomers.size()));
        //create a two dimensional array
        Object [][]  data = new Object[allCustomers.size()][1];

        for (int i = 0; i<=allCustomers.size()-1;i++){
            String customerName = allCustomers.get(i).getText();
            data[i][0]= customerName;
        }
        ExcelHandling excelHandling = new ExcelHandling();
        String filePath = "/Users/harshaddange/TestData.xlsx";
        excelHandling.writeExcelData(filePath, "customerData", data);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
