package com.automation.tests.march24;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverTest {

    @Test
    public void googleTest(){
        // Drivers.getDriver() --> returns driver
        Driver.getDriver().get("http://google.com");
        BrowserUtils.wait(3);
        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
        Driver.closeDriver();
    }
}
