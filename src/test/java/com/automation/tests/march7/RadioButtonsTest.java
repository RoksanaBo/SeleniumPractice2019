package com.automation.tests.march7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);


        //   <input type="radio" id="black" name="color">
        WebElement blackButton = driver.findElement(By.id("black"));


        // if visible and eligible  to click
        if(blackButton.isDisplayed() && blackButton.isEnabled()){  // isEnabled - включен
            System.out.println("clicked on black button");
            blackButton.click();
        }else{
            System.out.println("failed to click on black button");
        }


        BrowserUtils.wait(2);

        // how do we verify that button clicked?
        // returns true if button clicked
        if(blackButton.isSelected()){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }


        BrowserUtils.wait(3);
        driver.quit();




    }
}
