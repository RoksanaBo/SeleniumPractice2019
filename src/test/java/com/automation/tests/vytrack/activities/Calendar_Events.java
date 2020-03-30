package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Calendar_Events {

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");


    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";

    private  By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");

    private By createCalendarEventsBtnBy = By.cssSelector("a[title='Create Calendar event']");//because <a> is a title

    private By currentUserBy = By.cssSelector("#user-menu > a");
                                          // [id=user-menu] > a   так тоже можно

    private By ownerBy = By.id("#s2id_oro_calendar_event_form_calendar");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]'");

    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");
                                          // for some reason, end-part of id is always different.
                                          // That's why we use contains(*) to partially match id.
                                          // We selected static part of id and provided into locator.
    private WebDriver driver;
    private Actions actions;



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

        driver.findElement(By.linkText("Calendar Events")).click();

        BrowserUtils.wait(5);
    }




    //   Scenario 2 : Verify for store manager
    //   Login as store manager
    //   Go to Activities --> Calendar Events
    //   Verify that Create Calendar Event button is displayed
    @Test

    public void verifyCreateButton(){

        WebElement createCalendarEventBtn = driver.findElement(createCalendarEventsBtnBy);

        // verify that Create Calendar Event button is displayed:
        Assert.assertTrue(createCalendarEventBtn.isDisplayed());

    }

    // Scenario 3 :Default Options
    // in the @BeforeMethod: we already have this :
    // Login as sales manager
    // Go to Activities --> Calendar Events
    // Click on Create Calendar Event
    // ---------------------------------------------------
    // Default owner name should be current user
    // Default title should be blank
    // Default start date should be current date
    // Default start time should be current time


    @Test(description = "Default options")
    public void verifyDefaultValues(){

        // Click on "Create Calendar Event" button
        driver.findElement(createCalendarEventsBtnBy).click();
        BrowserUtils.wait(4);
        // #user-menu > a:
        // hash tag # means id, space, greater sign > means direct child.
        String currentUserName = driver.findElement(currentUserBy).getText();

        String defaultOwnerName = driver.findElement(ownerBy).getText();
        // Default owner name should be current user
        Assert.assertEquals(currentUserName, defaultOwnerName);

        // Default title should be blank:
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());

        // input elements don't contain a text. Instead, text is
        // inside attribute "value". Use getAttribute() method to retrieve that value

        // Text that you enter into input box will be stored inside "value" attribute.
        // So getText() method will not give you anything. Instead, use getAttribute("value)


       // Default start date should be current date:
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");

        Assert.assertEquals(actualDate,expectedDate);


        // String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:m a"));
        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");

        Assert.assertEquals(actualTime,expectedTime);




        // date time syntax:
        // https://www.journaldev.com/17899/java-simpledateformat-java-date-format



        // css Selector : #-means Id
        // css selector : >-means direct child
        // #user-menu>a

    }







    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}


