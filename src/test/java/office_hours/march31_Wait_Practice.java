package office_hours;

import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class march31_Wait_Practice extends AbstractTestBase {


/*
   Implicit Wait - we set it 1 time and it will work for every findElement method
       -  NoSuchElementException

   Thread.sleep --> not Selenium wait, but Java
   Thread - Java class, sleep() --> method of Thread class.
   It stops the execution of java program
   We never want to use this method in our tests.


   Explicit Wait - we have to declare every time before the iteraction with eleent,
     Expected Condition we are looking for


     Singleton - helps us to make sure we have only 1 instance of driver object at a time
*/
    @Test
    public void testWait(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://qa3.vytrack.com");

        // IMPLICIT WAIT:
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //EXPLICIT WAIT:
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.titleIs("Login"));

        WebElement user = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement submit = driver.findElement(By.id("_submit"));

        user.sendKeys("salesmanager110");
        password.sendKeys("UserUser123");
        submit.click();



        WebElement account = driver.findElement(By.xpath("//span[.='Accounts']/following-sibling::span/following-sibling::a"));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(account));

        account.click();

    }

}
