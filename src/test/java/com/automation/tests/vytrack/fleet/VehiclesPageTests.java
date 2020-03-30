package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclesPageTests {

    // create BeforeMethod with setup and @AfterMethod
    // with teardown part. Use LoginPageTests class as a reference

    // Create a test called verifyPageSubTitle .
    // In this test you will need to navigate to Fleet --> Vehicles and
    // verify that page subtitle is equals to "All Cars"
    // user assertions for validation.



    //*[class='title title-level-1' and contains(text(),'Customers')]



    private String URL = "https://qa2.vytrack.com/user/login";

    // CREDENTIALS FOR store manager

    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");

    private By subtitleBy = By.className("oro-subtitle");
    private By pageNumberBy = By.cssSelector("input[type='number']");
    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();



    }


    @Test
    public void verifyPageSubTitle(){

        // login
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(5);

        // click on fleet
        // driver.findElement(fleetBy).click();

         // actions class object
         Actions actions = new Actions(driver);

         // move to element instead of click
         actions.moveToElement(driver.findElement(fleetBy)).perform();

         // moveToElement --> hover mouse on web element
         // findElement() --> web element target
         // perform() --> to execute command
         // Every action should end with perform()
//-----------------------------------------------------------------------------------------------------------
         BrowserUtils.wait(2);

         // click on Vehicles
         driver.findElement(By.linkText("Vehicles")).click();

         BrowserUtils.wait(5);

         // find subtitle element
         WebElement subTitleElement = driver.findElement(subtitleBy);
         System.out.println(subTitleElement.getText());

         String expected = "All Cars";
         String actual = subTitleElement.getText();

         Assert.assertEquals(actual,expected);





    }




    // Task:
    // Given user is on the vytrack landing page
    // When user logs on as a store manager
    // Then user navigates to Fleet --> Vehicles
    // And user verifies that page number is equals to "1"

    @Test
    public void verifyPageNumber(){

    String expected = "1";
    String actual = driver.findElement(pageNumberBy).getAttribute("value");

    Assert.assertEquals(actual,expected);


    }




    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
