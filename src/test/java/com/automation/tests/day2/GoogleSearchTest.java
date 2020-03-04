package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();  // set up web driver .
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        Thread.sleep(2000);

        // By.name("q") --> name = "q":
        WebElement search = driver.findElement(By.name("q")); // name --> one of the locators

        // once we found en element ,how to enter text?
        // --> use sendKeys() method
        // how to press Enter after entering the text?
        // use Key.ENTER

        // Keys.ENTER --> perform keyboard click.
        search.sendKeys("Java", Keys.ENTER);

        Thread.sleep(2000);



        driver.quit();







    }
}
