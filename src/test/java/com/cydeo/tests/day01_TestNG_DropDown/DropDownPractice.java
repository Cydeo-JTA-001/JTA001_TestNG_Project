package com.cydeo.tests.day01_TestNG_DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDownPractice {

    //// Verifying “Simple dropdown” and “State selection” dropdown
    ////default values
    ////1. Open Chrome browser
    ////2. Go to https://practice.cydeo.com/dropdown
    ////3. Verify “Simple dropdown” default selected value is correct
    ////Expected: “Please select an option”
    ////4. Verify “State selection” default selected value is correct
    ////Expected: “Select a State”
    //
    //TC #6: Selecting date on dropdown and verifying
    //Open Chrome browser
    //Go to https://practice.cydeo.com/dropdown
    //Select “December 1st, 1933” and verify it is selected.
    //Select year using : visible text
    //Select month using : value attribute
    //Select day using : index number
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropDownTest() {
        ////3. Verify “Simple dropdown” default selected value is correct
        ////Expected: “Please select an option”
        String expectedDefaultValue = "Please select an option";
        Select simpleDropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        Assert.assertEquals(simpleDropDown.getFirstSelectedOption().getText(), expectedDefaultValue, "simple dropdown default value does not meet");
        ////4. Verify “State selection” default selected value is correct
        ////Expected: “Select a State”
        String expectedValueForStateDropDown ="Select a State";

        Select stateDropDown=new Select(driver.findElement(By.xpath("//select[@id='state']")));

        Assert.assertEquals(stateDropDown.getFirstSelectedOption().getText(),expectedValueForStateDropDown,"expected state does not meet");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
