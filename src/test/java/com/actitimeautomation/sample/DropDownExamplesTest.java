package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.ExtentReportUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExamplesTest extends BaseClass {
    WebDriver driver;
    @BeforeClass
    public void  setup(ITestContext context){
        launchBrowser("chrome");
        driver= super.driver;
        context.setAttribute("webDriver", driver);
    }
    @Test
    public void verifyDropDown() throws Exception {
        driver.navigate().to("https://www.amazon.in/");
        //create an instance of Select class
        Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
        ExtentReportUtil.getTest().info(String.valueOf(select.isMultiple()));

        //select by text
//        select.selectByVisibleText("Books");

        //select by value
//        select.selectByValue("search-alias=stripbooks");

        //select by index
//        select.selectByIndex(12);

   /*     select.deselectByVisibleText("");
        select.deselectByValue("");
        select.deselectByIndex(0);

        select.deselectAll();

        */


        //get all options of dropdown
        List<WebElement> valueList=  select.getOptions();

        ExtentReportUtil.getTest().info("Total Values in dropdown : "+ valueList.size());
        for(WebElement element : valueList){

                //get the text of value
               String value= element.getText();

               if(value.equals("Music")){
                   select.selectByVisibleText(value);

                   ExtentReportUtil.getTest().info(value);

                   List<WebElement> selectedValues= select.getAllSelectedOptions();

                   WebElement selectedVal = selectedValues.get(0);

                   String val = selectedVal.getText();
                   if(val.equals("Music")){
                       ExtentReportUtil.getTest().info("Successfully selected Music value from dropdown");
                   }else{
                       throw  new Exception("Music value did not selected in dropdown");
                   }
                   break;
               }

        }
        //enter text in search area
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");

        //click on search icon
        driver.findElement(By.id("nav-search-submit-button")).click();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
