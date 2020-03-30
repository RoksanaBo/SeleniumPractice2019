package com.automation.tests.practice_page;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryUI_Menu {

    private WebDriver driver;
    private Actions actions;


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        actions = new Actions(driver);
    }


    @Test
    public void jqueryTest(){
        // Go to page : JQuery UI Menus
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");

        // hover on "enabled"
        // hover on "downloads"
        // click on "PDF"

        BrowserUtils.wait(3);

        WebElement enab = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        actions.moveToElement(enab).
                pause(1000).
                moveToElement(downloads).
                pause(1000).
                click(pdf).
                build().perform();

    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}