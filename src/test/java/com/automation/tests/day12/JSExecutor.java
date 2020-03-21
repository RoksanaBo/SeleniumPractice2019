package com.automation.tests.day12;

import com.automation.tests.day11.JavaScriptExecutor;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private WebDriver driver;



    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }


    @Test
    public void verifyTitle(){
        String expected = "Practice";

        // we create  JavascriptExecutor object by casting webDriver object
       JavascriptExecutor js = (JavascriptExecutor) driver;

        // executeScript - this method executes javascript code
        // we provide js code as a string
        // return document.title --> javascript code
        // document --> represents HTML page
        // toString() --> to avoid additional casting from Object to String

       String actual = (String) js.executeScript("return document.title").toString();

        Assert.assertEquals(actual,expected);
    }



    @Test
    public void clickTest(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));

        // disable this click action, to perform it with js executor
        // link.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // after "" you can list web element that will be used
        // as part of your javascript code
        // it's varargs, so you can list 0+
        // arguments - listed after comma ,
        // use index to get specific web element
        // WebElement arguments = {element, link, link2 , etc.}; from left to right
        js.executeScript("arguments[0].click()", link);

        WebElement button6 = driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()", button6);
        BrowserUtils.wait(4);

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"Now it's gone!");

    }



    @Test
    public void textInputTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);


        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // to get text from input box - read attribute "value"
        // to enter text - set attribute "value"

        js.executeScript("arguments[0].setAttribute('value','tomsmith')", username);// arguments[0] == username
        js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')", password); // == password
        js.executeScript("arguments[0].click()", loginButton);// arguments[0] == loginButton



    }



    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
