package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExcelHandling;
import com.actitimeautomation.common.ExtentReportUtil;
import com.actitimeautomation.common.PropertyHandling;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class DataProviderExampleTest extends BaseClass {
    WebDriver driver;
    PropertyHandling propertyHandling;

    @BeforeClass(groups = "sanity")
    public void setup(ITestContext context) throws IOException {
        propertyHandling = new PropertyHandling();
        String browser = propertyHandling.getProperty("browser");
        String url = propertyHandling.getProperty("actitimeUrl");
        launchBrowser(browser);
        driver = super.driver;
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        context.setAttribute("webDriver", driver);
    }

    @DataProvider
    public Object[][] getTestData() {

        Object[][] obj = new Object[][]{
                {"username1", "password1"},
                {"username2", "password2"}
        };
        return obj;
    }

    @DataProvider
    public Object[][] getTestDataFromExcel() throws IOException {
        ExcelHandling excelHandling= new ExcelHandling();

        String filePath = propertyHandling.getProperty("excelPath");
        Object[][] excelData = excelHandling.getExcelData(filePath, "Sheet1");
        return excelData;
    }


    @Test(dataProvider = "getTestDataFromExcel", groups = "sanity")
    public void verifyLogin(Object username, Object password) throws Exception {
        ExtentReportUtil.getTest().info("running login test for username : "+ username);
        ExtentReportUtil.getTest().info("running login test for password : "+ password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username.toString(), password.toString());
    }




    @Test(dataProvider= "getSampleData", dataProviderClass = TestDataProvider.class, groups = "sanity")
    public void test(Object param1, Object param2, String param3){

        System.out.println(param1 + " "+ param2 + " "+ param3);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
