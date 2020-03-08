package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();// to click on the first button

        BrowserUtils.wait(2);


        // to get text from popup message:
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);

        driver.switchTo().alert().accept(); // to click OK
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();


        // it will fail because there is a typo  ## BUG ##
        if(expected.equals(actual)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
            System.out.println("expected :" + expected);
            System.out.println("actual :" +actual) ;
        }



        BrowserUtils.wait(2);
        driver.quit();



    }
}
