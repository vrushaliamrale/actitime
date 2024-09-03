package com.actitimeautomation.pages;

import com.actitimeautomation.common.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TaskPage {

    WebDriver driver;
    CommonUtil commonUtil;
    public TaskPage(WebDriver driver)
    {
        this.driver=driver;
        commonUtil = new CommonUtil(this.driver);
    }

    /*@Test
    public void createTask()
    {

    }*/
}
