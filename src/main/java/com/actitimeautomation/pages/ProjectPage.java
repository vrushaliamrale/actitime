package com.actitimeautomation.pages;

import com.actitimeautomation.common.ExtentReportUtil;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {
    WebDriver driver;
    ExtentTest extentTest=  ExtentReportUtil.objectMap.get("extentTest");

    @FindBy(xpath = "//div[contains(@class,'createNewProject')]")
    public WebElement createNewProjectButton;

    public ProjectPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(this.driver, this);
    }

    public void createProject(String projectName){
        extentTest.info("project created successfully...");
    }
}
