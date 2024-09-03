package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class SanityTestGroupTest extends BaseClass {


    @BeforeGroups(groups = {"regression", "sanity"})
    public void beforeGroup() {

        ExtentReportUtil.getTest().info("This is before group method");
    }

    @AfterGroups(groups = "sanity")
    public void afterGroup() {

        ExtentReportUtil.getTest().info("This is after regression group method");
    }

    @Test(groups = "sanity")
    public void sanityTest1() {
        ExtentReportUtil.getTest().info("Running sanity test1");

    }

    @Test(groups = "sanity")
    public void sanityTest2() {
        ExtentReportUtil.getTest().info("sanityTest2");

    }

    @Test(groups = "sanity")
    public void sanityTest3() {
        ExtentReportUtil.getTest().info("sanityTest3");

    }

    @Test(groups = "sanity")
    public void sanityTest4() {
        ExtentReportUtil.getTest().info("sanityTest4");

    }

    @Test(groups = {"regression", "sanity"})
    public void sanityTest5() {
        ExtentReportUtil.getTest().info("sanityTest5");

    }
}
