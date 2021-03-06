package com.automation.tests.march14;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTest {

    private WebDriver driver;


    // we put test annotation to make methods
    // executable as tests.


    // create a test called loginTest
    // go to "Form Authentication" page
    // enter valid credentials:
    //     username: tomsmith
    //     password: SuperSecretPassword
    // verify that following sub-header message is displayed:
    // "Welcome to the Secure Area. When you are done click logout below."

    @Test
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);

        BrowserUtils.wait(3);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        // if assertion fails, it will throe exception and message will be printed
        // 3 parameters : (expected, actual, message in case of error)
        Assert.assertEquals(actual,expected,"Sub-header message is not matching");

    }




    /**
     * Given user is on the practice landing page
     * When user navigates to "Forgot password" page
     * Then user enters hie email
     * And clicks "Retrieve password" button
     * Then user verifies that message "Your e-mail's been sent!" is displayed
     */

    @Test
    public void forgotPassword(){
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(3);

        driver.findElement(By.name("email")).sendKeys("bars777_07@hotmail.com",Keys.ENTER);

        BrowserUtils.wait(3);

        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_message")).getText();

        Assert.assertEquals(actual,expected,"Confirmation was no sent");

    }



    @Test
    public void checkBoxTest1(){
        driver.findElement(By.linkText("Checkboxes")).click();

        // locator for specific checkbox, xpath: // input[1]     cssSelector: input:nth-of-type(1)
        // collect all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(3);

        checkboxes.get(0).click(); // to click on checkbox #1

        Assert.assertTrue(checkboxes.get(0).isSelected(),"Checkbox 1 is not selected");

        BrowserUtils.wait(2);

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();

        // HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //  ChromeOptions - use to customize browser for tests

        ChromeOptions chromeOptions = new ChromeOptions();

        // to ignore "Your connection is not private issue

        chromeOptions.setAcceptInsecureCerts(true);

        // provide chromeOptions object into chromeDriver constructor

        driver =new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
