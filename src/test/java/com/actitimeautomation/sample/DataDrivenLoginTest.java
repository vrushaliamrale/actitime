package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExcelHandling;
import com.actitimeautomation.common.ExtentReportUtil;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataDrivenLoginTest extends BaseClass {
    WebDriver driver;
    @BeforeClass
    public void setup(ITestContext context){
        launchBrowser("chrome");
        driver = super.driver;
        context.setAttribute("webDriver", driver);
    }
    @Test
    public void dataDriverTest() throws Exception {
        driver.navigate().to("https://online.actitime.com/cybersuccess1");
        LoginPage loginPage= new LoginPage(driver);
        ExcelHandling excelHandling= new ExcelHandling();
        String filePath = "/Users/harshaddange/TestData.xlsx";
        Object[][] excelData = excelHandling.getExcelData(filePath, "sheet1");
        for (int i = 0; i <= excelData.length - 1; i++) {
            String username = excelData[i][0].toString();
            String password = excelData[i][1].toString();
            ExtentReportUtil.getTest().info(username + " "+ password);
            loginPage.login( username, password);
            Thread.sleep(5000);
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
