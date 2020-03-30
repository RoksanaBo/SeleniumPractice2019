package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Calls {

    //   Scenario 1 : Verify for Store Manager:

    //   Login as store manager
    //   Go to Activities --> Calls
    //   Verify that Log Call button is displayed

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");


    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";

    private  By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");

    private WebDriver driver;
    private Actions actions;
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");//because <a> is a title


    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();

        actions = new Actions(driver);  //  if we wanna use actions class we have to provide (driver)
                                        //  without driver ,we cannot use actions class
        BrowserUtils.wait(3);

        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);

        BrowserUtils.wait(3);

        actions.moveToElement(driver.findElement(activitiesBy)).perform();

        driver.findElement(By.linkText("Calls")).click();

        BrowserUtils.wait(5);
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }



    @Test
    public void verifyLogCallButton(){

        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);

        Assert.assertTrue(logCallBtnElement.isDisplayed());

    }


}
