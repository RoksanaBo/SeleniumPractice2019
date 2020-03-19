package com.automation.tests.day9.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclesTests {

    // create BeforeMethod with setup and @AfterMethod
    // with teardown part. Use LoginPageTests class a reference

    // Create a test called verifyPageSubTitle .
    // In this test you will need to navigate to Fleet --> Vehicles and
    // verify that page subtitle is equals to "All Cars"
    // user assertions for validation.

    private String URL = "https://qa2.vytrack.com/user/login";

    // CREDENTIALS FOR store manager

    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");

    private By subtitleBy = By.className("oro-subtitle");
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
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(3);

        driver.findElement(fleetBy).click();

        BrowserUtils.wait(3);

        // click on Vehicles

        driver.findElement(By.linkText("Vehicles")).click();

        BrowserUtils.wait(3);

        WebElement subtitleElement = driver.findElement(subtitleBy);
        System.out.println(subtitleElement.getText());

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
