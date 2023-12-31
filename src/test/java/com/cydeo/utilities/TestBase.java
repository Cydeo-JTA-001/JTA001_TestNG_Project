package com.cydeo.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected Actions actions;




    @BeforeMethod
    public void setUp(){
        driver = Driver.get();//Driver.get() gets browser info from ConfigurationReader.get("browser");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);

        driver.get(ConfigurationReader.get("url4"));//>>After todays class since we r gonna open the same project page, we put this line into TestBase
    }

    @AfterMethod
    public void tearDown()  {

     //  Driver.closeDriver();
    }


}