package com.cydeo.tests.day02_JavaFaker_Actions_Driver_ConfigurationReader_TestBase;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ActionsPractice extends TestBase {
    @Test
    public void hoverTest(){
        //click home
        Driver.get().findElement(By.xpath("//a[@class='nav-link']")).click();
        //goto hover link
        //locator of the hover   //a[@href='/hovers']
        Driver.get().findElement(By.xpath("//a[@href='/hovers']")).click();




    }


}
