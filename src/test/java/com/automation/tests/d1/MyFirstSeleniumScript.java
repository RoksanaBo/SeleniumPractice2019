package com.automation.tests.d1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) {

        // set up chromeDriver
        WebDriverManager.chromedriver().setup();
        // create chtomeDriver object
        ChromeDriver driver = new ChromeDriver();
        // open some website
        driver.get("http://google.com");
    }
}
