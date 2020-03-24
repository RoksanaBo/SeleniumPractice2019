package com.automation.tests.d11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    private WebDriver driver;
    private Actions actions;


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        actions = new Actions(driver);
    }

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        // actions.moveToElement(img1).perform();

        // build() is needed when we have couple of actions
        // always ends with perform()
        // pause(1000). - like Thread.sleep(1000)
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();

        BrowserUtils.wait(3);




        // Task:
        // hover on the first image
        // verify that "name: user1" is displayed
        // hover over image to make text visible

        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));

        // verify that WebElement that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());




        // move to the second image
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());


    }

    @Test
    public void jqueryMenuTest(){
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
                moveToElement(pdf).
                build().perform();

    }




    // Drag and Drop example:
    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();

        BrowserUtils.wait(3);

        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon,earth).perform();

        String expected ="You did great!";
        String actual = earth.getText();

        Assert.assertEquals(actual,expected);

        // Assert - утверждать

    }




    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
