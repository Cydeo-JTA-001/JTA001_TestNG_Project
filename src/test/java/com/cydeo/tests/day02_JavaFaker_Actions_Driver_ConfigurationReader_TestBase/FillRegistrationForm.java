package com.cydeo.tests.day02_JavaFaker_Actions_Driver_ConfigurationReader_TestBase;


import com.cydeo.utilities.Driver;
import com.cydeo.utilities.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Locale;

public class FillRegistrationForm  extends TestBase {

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

        //fill email
        String email=fake.internet().emailAddress();
        WebElement emailAddress=Driver.get().findElement(By.xpath("//input[@name='email']"));
emailAddress.sendKeys(email);
        //fill phone number
String phone=fake.numerify("###-###-####");
WebElement phoneNumber=Driver.get().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(phone);
        Thread.sleep(5000);
    }

}
