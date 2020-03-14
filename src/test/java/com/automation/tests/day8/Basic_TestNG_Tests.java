package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basic_TestNG_Tests {



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
