package com.automation.tests.march10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class X_Path {

    // it's static, so I can use this inside the same package anywhere

    static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    static String passwordLocator = "//label[text()='Password']/following-sibling::input";
    static String loginBtnLocator = "//button[contains(text(), 'Login')]";



    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();





        BrowserUtils.wait(3);
        driver.quit();


    }
}
