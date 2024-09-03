package com.actitimeautomation;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import com.actitimeautomation.pages.CustomerPage;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class TaskTest extends BaseClass {

    CustomerPage customerPage;

    @Test
    public void verifyCreateTask(){
        //1 create custometer
        ExtentReportUtil.getTest().info("successfully logged in to application");
        customerPage.createCustomer("Cyber Success");
        customerPage.verifyCustomer("Cyber Success");
        ExtentReportUtil.getTest().info("newly created customer verified successfully");

        //2. create project
        //3. create task
    }
}
