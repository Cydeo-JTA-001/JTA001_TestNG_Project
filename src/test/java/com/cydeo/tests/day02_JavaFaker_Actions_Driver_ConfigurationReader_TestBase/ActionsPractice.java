package com.cydeo.tests.day02_JavaFaker_Actions_Driver_ConfigurationReader_TestBase;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsPractice extends TestBase {

    WebDriver driver=Driver.get();
    @Test
    public void hoverTest(){
       //goto hovers URL
        //https://practice.cydeo.com/hovers
        driver.get("https://practice.cydeo.com/hovers");
// locate the first image and hover over the image
        WebElement image1=driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        actions.moveToElement(image1).perform();
        //locate name: user1 element and verify it is displayed using  isDisplayed() method
        WebElement user1=Driver.get().findElement(By.xpath("//h5[text()='name: user1']"));
        //verify user1 name is dsiplayed
        Assert.assertTrue(user1.isDisplayed(),"There is problem in the web page source code");

    }

    @Test
    public void circleTest(){
        //goto https://practice.cydeo.com/drag_and_drop_circles

        driver.get("https://practice.cydeo.com/drag_and_drop_circles");

        //locate draggable circle
        WebElement smallCircle=driver.findElement(By.xpath("//div[@id='draggable']"));
        actions.clickAndHold(smallCircle).moveToElement(smallCircle,100,0).pause(Duration.ofSeconds(3)).perform();
        //  locate the big circle text saying Drop here.
        WebElement dropHere= driver.findElement(By.xpath("//div[text()='Drop here.']"));
        //verify that when clickandhold and move the small circle it says Drop here in big circle.
        Assert.assertTrue(dropHere.isDisplayed(),"There is a problem");

    }
    @Test
    public void circleTestTryAgain(){
        //goto https://practice.cydeo.com/drag_and_drop_circles

        driver.get("https://practice.cydeo.com/drag_and_drop_circles");

        //locate draggable circle
        WebElement smallCircle=driver.findElement(By.xpath("//div[@id='draggable']"));
        //move the small circle and release
        actions.clickAndHold(smallCircle).moveToElement(smallCircle,100,0).release().perform();
        //  locate the big circle text saying Drop here.
        WebElement bigCircle= driver.findElement(By.xpath("//div[@id='droptarget']"));
        //verify that when clickandhold and move the small circle it says Drop here in big circle.
        String expected="Try again!";
        Assert.assertTrue(bigCircle.getText().equals(expected),"There is a problem");

    }



}
