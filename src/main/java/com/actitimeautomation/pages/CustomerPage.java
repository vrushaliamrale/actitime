package com.actitimeautomation.pages;

import com.actitimeautomation.common.CommonUtil;
import com.actitimeautomation.common.ExtentReportUtil;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerPage {

    WebDriver driver;
    CommonUtil commonUtil;
    ExtentTest extentTest=  ExtentReportUtil.objectMap.get("extentTest");
    public CustomerPage(WebDriver driver){
        this.driver= driver;
        commonUtil = new CommonUtil(this.driver);
    }

    public By taskModule = By.id("container_tasks");
    public By addNewButton = By.xpath("//div[text()='Add New']");
    public By createNewCustomer= By.xpath("//div[contains(@class,'createNewCustomer')]");
    public By customerNameTextArea= By.xpath("//div[@id='customerLightBox_content']/descendant::input[1]");
    public By createCustomerButton= By.xpath("//div[text()='Create Customer']");
    public By searchText = By.xpath("//div[@class='searchFieldContainer']/descendant::input");
    
    public void createCustomer(String customerName){
        driver.findElement(taskModule).click();
        commonUtil.fluentWait(addNewButton);
        driver.findElement(addNewButton).click();
        driver.findElement(createNewCustomer).click();
        driver.findElement(customerNameTextArea).sendKeys(customerName);
        driver.findElement(createCustomerButton).click();
        //extentTest.info("customer created successfully with name: "+ customerName);
    }

    public void verifyCustomer(String customerName){
        driver.findElement(searchText).sendKeys(customerName);
        //fetch the result and get the text
        //compare actual and expected customer and assert the same
        //extentTest.info("customer verified successfully with name: "+ customerName);

    }



}
