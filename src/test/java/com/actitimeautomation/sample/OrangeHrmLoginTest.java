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

public class OrangeHrmLoginTest extends BaseClass {
    WebDriver driver;

    CommonUtil commonUtil;
    @BeforeClass
    public void setup(ITestContext context){
        launchBrowser("chrome");
        driver = super.driver;
        commonUtil = new CommonUtil(driver);
        context.setAttribute("webDriver", driver);
    }

    @Test
    public void verifyLogin() throws Exception {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        commonUtil.waitForElementToPresent(By.name("username"));

        commonUtil.fluentWait(By.name("username"));

        String title= driver.getTitle();

        ExtentReportUtil.getTest().info("Tile of the page : " + title);

        driver.findElement(By.name("username")).sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        boolean enableLoginButton= loginButton.isEnabled();

        ExtentReportUtil.getTest().info("The login button is enable: "+ enableLoginButton);
        if(enableLoginButton){

            loginButton.submit();
        }else {
            throw new Exception("Login Button is not enables !");
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
