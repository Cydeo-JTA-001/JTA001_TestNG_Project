package com.cydeo.tests.day01_TestNG_DropDown;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeTestNG {
    //TC #4: Cydeo Title Verification
//1.Open Chrome browser
//2.Go to https://www.cydeo.com/
//3.Verify title:
//Expected: Cydeo

    //TC1
    //step1 xxx
    //step2 xxy
    //step3 zz

    //TC2
    //step1 xxx
    //step2 xxy
    //step3 cc
    //step4 dd

    //@BeforeMethod--
    //step1 xxx
    //step2 xxy

    //TC1
    //step3
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        //1.Open Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


//2.Go to https://www.cydeo.com/
        driver.get("https://www.cydeo.com/");


    }
    @Test
    public void test1(){
        //3.Verify title:
//Expected: Cydeo
        String expectedTitle="Cydeo";
        //we use Assert Class to verify actual vs expected data.
        //Assert.assertTrue();  if you are going to use this
        // you need to ask this: check if page title equals to expectedTitle
        Assert.assertTrue(driver.getTitle().equals(expectedTitle),"actual title does not meet the expected");

        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
