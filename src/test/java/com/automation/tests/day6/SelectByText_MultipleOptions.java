package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

public class SelectByText_MultipleOptions {
    public static void main(String[] args) {

        //    WebDriverManager.chromedriver().setup();
        //    WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);




        BrowserUtils.wait(2);
        driver.quit();












    }
}
