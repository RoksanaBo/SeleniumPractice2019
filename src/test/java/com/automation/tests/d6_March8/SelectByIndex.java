package com.automation.tests.d6_March8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);


        Select stateSelect = new Select(driver.findElement(By.id("state")));


        // index starts from 0
        stateSelect.selectByIndex(9);// District of Columbia perhaps


        // select last option:
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);


        BrowserUtils.wait(2);
        driver.quit();
    }
}