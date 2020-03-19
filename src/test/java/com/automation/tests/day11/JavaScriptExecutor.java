package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutor {

    private RemoteWebDriver driver;


    @BeforeMethod
    public void setup(){
   //     driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }


    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();

        BrowserUtils.wait(3);

        // you need to cast if reference type is a WebDriver
        // вам нужно привести, если ссылочный тип является WebDriver

        // JavaScriptExecutor is = (JavaScriptExecutor) driver;

        // scroll down 250 pixels:
        //  x, y coordinates  (0,250)


        //driver.executeScript("window.scrollBy(0, 250)");

        for (int i = 0; i < 10 ; i++) {
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(1);

        }

        BrowserUtils.wait(3);
    }



    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

        BrowserUtils.wait(2);

        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        driver.executeScript("arguments[0].scrollIntoView(true)",link);

        // scrollIntoView(true) --> scroll until it becomes visible, JavaScript method
        // arguments[0]  -->  means 1st webElement after comma .
    }
}
