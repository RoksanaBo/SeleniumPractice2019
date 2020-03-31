package com.automation.tests.d13_March22;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {

private WebDriver driver;

@BeforeMethod
    public void setup(){
    driver= DriverFactory.createDriver("chrome");
    driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
@Test
    public void waitTest(){
    driver.findElement(By.tagName("button")).click();
    WebElement finishElement = driver.findElement(By.id("finish"));
    // this is how we apply implicit wait
    System.out.println(finishElement.getText());

}

@AfterMethod
    public void teardown(){
    driver.quit();
}

}
