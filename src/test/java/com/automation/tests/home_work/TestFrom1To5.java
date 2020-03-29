package com.automation.tests.home_work;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFrom1To5 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);
    }


    //Test case #1
    // Step 1. Go to "https://practice-cybertekschool.herokuapp.com/"
    // Step 2. Click on "Registration Form"
    // Step 3. Enter "wrong_dob" into date of birth input box.
    // Step 4. Verify that warning message is displayed: "The date of birth is not valid"
    @Test
    public void testCase1(){

        driver.findElement(By.linkText("Registration Form")).click();


        BrowserUtils.wait(2);
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");

        BrowserUtils.wait(2);

        String expected = "The date of birth is not valid";
        String actual = driver.findElement(By.xpath("//*[@id='registrationForm']/div[8]/div/small[2]")).getText();

        System.out.println(actual);
        Assert.assertEquals(actual,expected,"incorrect");


    }



    // Test case #2
    // Step 1. Go to "https://practice-cybertekschool.herokuapp.com/"
    // Step 2. Click on "Registration Form"
    // Step 3. Verify that following options for programming languages
    // are displayed: c++, java, JavaScript

    @Test
    public void testCase2(){

    }


    // Test case #3
    // Step 1. Go to "https://practice-cybertekschool.herokuapp.com/"
    // Step 2. Click on "Registration Form"
    // Step 3. Enter only one alphabetic character into first name input box.
    // Step 4. Verify that warning message is displayed:
    // “first name must be more than 2 and less than 64 characters long"



    // Test case #4
    // Step 1. Go to "https://practice-cybertekschool.herokuapp.com/"
    // Step 2. Click on "Registration Form"
    // Step 3. Enter only one alphabetic character into last name input box.
    // Step 4. Verify that warning message is displayed:
    // “The last name must be more than 2 and less than 64 characters long”



    // Test case #5
    // Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    // Step 2. Click on “Registration Form”
    // Step 3. Enter any valid first name
    // Step 4. Enter any valid last name.
    // Step 5. Enter any valid user name
    // Step 6. Enter any valid password
    // Step 7. Enter any valid phone number
    // Step 8. Select gender
    // Step 9. Enter any valid date of birth
    // Step 10. Select any department.
    // Step 11. Enter any job title.
    // Step 12. Select java as a programming language.
    // Step 13. Click Sign up.
    // Step 14. Verify that following success message is displayed:
    // "You've successfully completed registration!”

    // Note: for using dropdown, please refer to the
    // documentation: https://selenium.dev/selenium/
    // docs/api/java/org/openqa/selenium/support/ui/
    // Select.html or, please watch short video about dropdowns that is posted on canvas.



    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
