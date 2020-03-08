package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByText {

    public static void main(String[] args) {

        //    WebDriverManager.chromedriver().setup();
        //    WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        // create webElement object or dropdown:
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));


        // provide webElement object into constructor:
        Select selectSimpleDropdown = new Select(simpleDropdown);


        // select by visible text:
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);


        // and select option 1 :
        selectSimpleDropdown.selectByVisibleText("Option 1");












        BrowserUtils.wait(2);
        driver.quit();










    }
}
