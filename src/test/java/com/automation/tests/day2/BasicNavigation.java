package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) {

       // to start Selenium script we need to :
       // setup webDriver (browser driver) and create webDriver object

        WebDriverManager.chromedriver().setup();  // for google Chrome
        ChromeDriver driver = new ChromeDriver();

        // in Selenium everything starts from WebDriver Interface

        driver.get("http://google.com"); // to open the web site






    }
}
