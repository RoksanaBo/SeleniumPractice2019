package com.automation.tests.d13_March22;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FluentWait_Test {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
    }


    @Test
    public void fluentWaitTest(){  // fluent wait - беглое ожидание

        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        Wait<WebDriver> wait = new FluentWait<>(driver).
                 withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(3)).
                ignoring(NoSuchElementException.class).
                ignoring(ElementClickInterceptedException.class);

        // 10, TimeUnit.SECONDS = Duration.ofSeconds(10)

        WebDriverWait webDriverWait =new WebDriverWait(driver,15);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));


        // new Function<WebDriver --> anonymous class анонимный класс - class without name

        WebElement submitBtn = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//button[text()='Submit']"));
            }
        });

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        submitBtn.click();
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
