package com.automation.tests.d8;

import org.testng.Assert;
import org.testng.annotations.*;

public class Basic_TestNG_Tests {


    @BeforeTest      // runs only once before @BeforeClass and @BeforeMethod
    public void beforeTest(){
        System.out.println("Before Test");
    }


    @AfterTest
    public void afterTest(){    // runs only once after @AfterClass and @AfterMethod
        System.out.println("After Test");
    }



    // runs only once in the class before @BeforeMethod and before any test
    // regardless on number of tests, it runs only once
    // something that should be done only once
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }



    @AfterClass    //   something that should be done only once
    public void afterClass(){
        System.out.println("After Class");
    }


    @BeforeMethod     // runs before every test automatically, works as a pre-condition or setup.
    public void setup(){
        System.out.println("Before Method");

    }



    @AfterMethod    // runs automatically after every test
    public void teardown(){
        System.out.println("After Method");

    }





    @Test
    public void test1(){
        System.out.println("Test 1");

        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);

    }


    @Test
    public void test2(){
        System.out.println("Test 2");

        int num1 = 5;
        int num2 = 10;

        // it called hard assertion
        // if assertion fails - it stops the execution(due to exception)
        Assert.assertTrue(num1 < num2);

    }
}
