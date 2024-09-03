package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

public class CalendarExampleTest extends BaseClass {
    WebDriver driver;
    @BeforeClass
    public void setup(ITestContext context) {
        launchBrowser("chrome");
        driver = super.driver;
        context.setAttribute("webDriver", driver);
    }

    @Test
    public void verifyCalendar() throws Exception {
        //get next day
        int dayOfMonth = LocalDateTime.now().plusDays(1).getDayOfMonth();
        //get current day/
//        LocalDateTime.now().getDayOfMonth();
        String currentMonth = LocalDateTime.now().getMonth().toString();
        //convert month in July format
        String month = currentMonth.charAt(0) + currentMonth.substring(1, (currentMonth.length())).toLowerCase();
        ExtentReportUtil.getTest().info("Current Month : " + currentMonth);
        ExtentReportUtil.getTest().info(month);
        ExtentReportUtil.getTest().info("Today's day :" + dayOfMonth);
        new CalendarExampleTest();
        driver.navigate().to("https://online.actitime.com/cybersuccess1");
        //login to application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("cst70_api@yopmail.com", "12345678");
        //wait for 5 sec
        Thread.sleep(5000);
        //click on Task module
        driver.findElement(By.id("container_tasks")).click();
        //wait for 5sec to load all tasks on the page
        Thread.sleep(5000);
        //click on first row calendar
        driver.findElement(By.xpath("(//div[text()='Set up deadline'])[1]")).click();
        List<WebElement> monthDays = driver.findElements(By.xpath("//tbody[@class='rc-calendar-tbody']//td[starts-with(@title,'" + month + "')]/div"));
        //iterate the list
        for (WebElement dayElement : monthDays) {
            //get the day
            String monthDay = dayElement.getText();
            //convert dayOfMonth into String
            String currentDay = String.valueOf(dayOfMonth);
            //check if the monthDay value is current day or not
            if (monthDay.equals(currentDay)) {
                dayElement.click();
                break;
            }
        }
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
