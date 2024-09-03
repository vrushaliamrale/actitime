package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGAnnotations extends BaseClass {

    @BeforeSuite
    public void beforeSuite() {
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReportUtil.getTest().info("This is after suite");
    }

    @BeforeTest
    public void beforeTest() {
    }

    @AfterTest
    public void afterTest() {
    }

    @BeforeClass
    public void beforeClass() {
    }

    @AfterClass
    public void afterClass() {
    }

    @BeforeMethod
    public void beforeMethod1() {
        ExtentReportUtil.getTest().info("This is before Method");
    }

    @AfterMethod
    public void afterMethod() {
        ExtentReportUtil.getTest().info("This is after Method");
    }

    @Test(enabled = false)
    public void verifyLogin() {

        ExtentReportUtil.getTest().info("This is verify login method");
    }

    @Test(priority = 1)
    public void login() throws Exception {
        ExtentReportUtil.getTest().info("This is login method from TestNGAnnotations class");

        ExtentReportUtil.getTest().info("login method of TestAnnotations class execution started..");
        boolean actual = false;

        Assert.assertTrue(actual);


    }

    @Test(priority = 1, dependsOnMethods = {"login"})
    public void verifyTask() throws Exception {
        ExtentReportUtil.getTest().info("This is verify task method from TestNGAnnotations class");
        throw new Exception("This is sample exception");
    }

    @Test(priority = 3, dependsOnMethods = "login", enabled = false)
    public void logout() {

        ExtentReportUtil.getTest().info("This is logout method from TestNGAnnotations class");
    }


}
