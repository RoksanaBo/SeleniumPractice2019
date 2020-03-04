package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{

       // to start Selenium script we need to :
       // setup webDriver (browser driver) and create webDriver object

        WebDriverManager.chromedriver().setup();  // for google Chrome
        ChromeDriver driver = new ChromeDriver();

        // in Selenium everything starts from WebDriver Interface

        // ChromeDriver extends RemoteWebDriver --> implements WebDriver

        driver.get("http://google.com"); // to open the web site

        Thread.sleep(2000); // for demo - wait 2 seconds

        driver.close(); // to close browser








    }
}
