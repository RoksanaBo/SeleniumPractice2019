package com.automation.pages;

// This class will be extended by page classes.
// Any common web elements/locators can be stored here.
// Since navigation menu doesn't belong to particular page,
// we cannot really create a dedicated page class to store
// elements from that menu

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageBase {
   protected WebDriver driver = Driver.getDriver();


    // this is constructor
    public AbstractPageBase(){
        PageFactory.initElements(driver,this);
    }

    // Method for VyTrack navigation. Provide tab name and module navigation.

    // This method will navigate to the place based on tag name and module name(Fleet Management sheet).
    // It will move to the tag name, module will be visible, and then it will click on it.

    // tab name: Dashboard, Fleet, Customers, Sales, Activities, Marketing, Reports and Segments, System
    // module name: like Vehicles, Vehicle Odometer, Vehicle Costs...........

    public void navigateTo(String tabName, String moduleName){
        String tabNameXpath ="//span[@class='title title-level-1' and contains(text(),'"+ tabName + "')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);

        BrowserUtils.wait(4);

        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();

        // increase this wait time if still failing
        // увеличить это время ожидания, если все еще не удается
        BrowserUtils.wait(4);

    }
}
