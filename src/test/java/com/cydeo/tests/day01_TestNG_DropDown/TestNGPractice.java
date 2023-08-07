package com.cydeo.tests.day01_TestNG_DropDown;

import org.testng.annotations.*;

public class TestNGPractice {

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("This method runs once before all test cases in this class");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("This method runs once after all test cases in this class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This method runs before each test");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("This method runs after each test");
    }

    @Test
    public void test1(){
        System.out.println("This is Test1");
    }
    @Test
    public void test2() {
        System.out.println("This is Test2");
    }
    @Test
    public void test3() {
        System.out.println("This is Test3");
    }

}
