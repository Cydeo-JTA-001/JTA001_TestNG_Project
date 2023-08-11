package com.cydeo.tests.day02_JavaFaker_Actions_Driver_ConfigurationReader_TestBase;


import com.cydeo.utilities.Driver;
import com.cydeo.utilities.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class FillRegistrationForm  extends TestBase {

    WebDriver driver=Driver.get();

    @Test
    public void registerFormTest() throws InterruptedException {
        //open chrome
        //goto https://practice.cydeo.com/registration_form
        Faker fake=new Faker(new Locale("pt"));

        // fill first name
        String firstname=fake.name().firstName();

        WebElement firstName=Driver.get().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(firstname);


        //fill last name

        String lastname=fake.name().lastName();

        WebElement lastName=Driver.get().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(lastname);

        //to create a random fake username
        String username=fake.bothify(firstname+"###???");  //## for numbers  ? is for letters
        WebElement userName = Driver.get().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(username);

        //fill email
        String email=fake.internet().emailAddress();
        WebElement emailAddress=Driver.get().findElement(By.xpath("//input[@name='email']"));
emailAddress.sendKeys(email);
        //fill phone number
String phone=fake.numerify("###-###-####");
WebElement phoneNumber=Driver.get().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(phone);
        // fill password using fake.internet().password()
        String password=fake.internet().password();
        System.out.println("password = " + password);
        WebElement passWord=driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys(password);
        //select gender according to random gender input you get from
        //fake.dog().gender()
        //so locate gender radio button
        // create a dynamic locator by using gender variable inside the locator
        // so for male, locator will point male
        //for female, locator will point female
        //such as String gender=male; ......By.xpath("//a[@id='" +   gender  +  "']");
        String gender=fake.dog().gender();
        WebElement genderButton=Driver.get().findElement(By.xpath("//input[@value='"+   gender     +"']"));
        genderButton.click();
        // create a fake birthday filling this format
        //MM/DD/YYYY
        //use this code
        //SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        //String dob = sdf.format(fake.date().birthday());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dob = sdf.format(fake.date().birthday());
        WebElement birthday=driver.findElement(By.xpath("//input[@name='birthday']"));
        birthday.sendKeys(dob);

        //Select Treasurer's Office using selectByValue() from Department/Office dropdown
        Select departmentDropdown=new Select(Driver.get().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByValue("TRO");
        //Select SDET using selectByIndex() from Job title dropdown
        Select jobTitleDropdown=new Select(Driver.get().findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(4);
        //Select C++, Java and Javascript all 3 checkboxes
        WebElement cplusplus=    Driver.get().findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        cplusplus.click();

        WebElement java=Driver.get().findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        java.click();

        WebElement javascript=Driver.get().findElement(By.xpath("//input[@id='inlineCheckbox3']"));
        javascript.click();

        //click signup
        Driver.get().findElement(By.xpath("//button[@id='wooden_spoon']")).click();

        //verify "Well done!" is shown to show succesful signup after clicking signup button.
        String expectedText="Well done!";
        WebElement WellDone=Driver.get().findElement(By.xpath("//h4[text()='Well done!']"));

        Assert.assertEquals(expectedText,WellDone.getText(),"Expected text is shown");
    }
}
