package com.actitimeautomation.pages;

import com.actitimeautomation.common.ExtentReportUtil;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    ExtentTest extentTest=  ExtentReportUtil.objectMap.get("extentTest");
    @FindBy(id = "username")
    WebElement username;

    //FindBys works with AND operator
    @FindBys({
            @FindBy(id="username"),
            @FindBy(className="username")
    })
    WebElement username1;
    //FindAll works with OR operator
    @FindAll({
            @FindBy(id="username"),
            @FindBy(className="username")
    })
    WebElement username2;

    @FindBy(name = "pwd")
    WebElement password;
    @FindBy(xpath = "//div[starts-with(text(),'Login')]")
    WebElement loginButton;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
//        PageFactory.initElements(driver, LoginPage.class);
    }

    public void login(String username, String password) throws Exception {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        boolean enableLoginButton = loginButton.isEnabled();
        if (enableLoginButton) {
            loginButton.click();
            extentTest.info("logged into application successfully with :"+ username + " "+ password );
        } else {
            throw new Exception("The Login button is not enabled....!");
        }
    }


}
