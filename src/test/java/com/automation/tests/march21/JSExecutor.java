package com.automation.tests.march21;

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
        // .toString() --> to avoid additional casting from Object to String

       String actual = (String) js.executeScript("return document.title").toString();

        Assert.assertEquals(actual,expected);
    }



    @Test
    public void clickTest(){

        // driver.findElement(By.linkText("Multiple Buttons"));

        // if we want to break it down:

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

      //                                                 0      1    ........
        js.executeScript("arguments[0].click()", button6);// [0] because it's a first element after comma
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

        // .setAttribute('value', 'text') - enter some text

        js.executeScript("arguments[0].setAttribute('value','tomsmith')", username);// arguments[0] == username
        js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')", password); // == password
        js.executeScript("arguments[0].click()", loginButton);// arguments[0] == loginButton
        // all arguments in array []
        BrowserUtils.wait(4);


        String expected = "Welcome to the Secure Area. When you are done click logout below.";

        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

        Assert.assertEquals(subheader, expected);


    }



    @Test
    public void scrollToElement(){
        BrowserUtils.wait(4);

        // href = link, URL
        WebElement link = driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",link); // scroll until element is visible

    }





        @Test
        public void scrollTest() {

        // navigate().to() --> calls get() method
            driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 0; i < 15; i++) {
                js.executeScript(("window.scrollBy(0, 1000)"));
                BrowserUtils.wait(1);
            }




       // https://developer.mozilla.org/en-US/docs/Web/API/Element/scrollIntoView

    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
