package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegressionTestGroupTest extends BaseClass {

    @Parameters({"browser", "username","password"})
    @Test
    public void regressionTest1(String browser, String username, String password){
        ExtentReportUtil.getTest().info(browser);
        ExtentReportUtil.getTest().info(username);
        ExtentReportUtil.getTest().info(password);
    }

    @Test(groups = {"regression"})
    public void regressionTest2(){
        ExtentReportUtil.getTest().info("regressionTest2");

    }
    @Test(groups = {"regression"})
    public void regressionTest3(){
        ExtentReportUtil.getTest().info("regressionTest3");

    }
    @Test(groups = {"regression"})
    public void regressionTest4(){
        ExtentReportUtil.getTest().info("regressionTest4");
    }


}
