package com.automation.tests.vytrack;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// this class provides setup and clan up part for all our test

public abstract class AbstractTestBase {  // abstract --> not concrete.
                                  // this class has to be extended! этот класс должен быть расширен!

    protected WebDriverWait wait; // protected will be visible within package or within subclass
    protected Actions actions;

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(),15);
        actions = new Actions(Driver.getDriver());

    }


    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }

}
