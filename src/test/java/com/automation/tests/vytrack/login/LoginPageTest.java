package com.automation.tests.vytrack.login;

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

//STATIC IMPORT OF ALL ASSERTIONS:
import static org.testng.Assert.*;


public class LoginPageTest {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    // Credentials for store manager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");

    //  >  go to direct  child

    @Test(description = "verify that warning message displays when user enters invalid username")
    public void invalidUsername(){
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("USerUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual, expected);

    }

    @Test(description = "Login as store manager and verify that title is equals to Dashboard")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        String expected = "Dashboard";
        String actual = driver.getTitle();  //   getTitle()  --> returns the title of the page.

        // first actual, then expected, them message

        assertEquals(actual,expected,"Page title is not correct");

    }

    // https is a secured version of http protocol
    // http - it's hypertext transfer protocol that every single website is using now days
    // https - data encrypted, no chance for hackers to retrieve info
    // http - data is a plain text, very easy to hack it


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void teardown(){
       // if webDriver object alive
        if(driver != null) {
            // close browser, close session
            driver.quit();
            // destroy driver object for sure
            driver = null;
        }

    }
}
