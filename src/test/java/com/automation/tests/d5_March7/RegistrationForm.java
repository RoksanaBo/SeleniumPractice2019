package com.automation.tests.d5_March7;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(4);

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("jsmith");
        driver.findElement(By.name("email")).sendKeys("jsmith@email.com");
        driver.findElement(By.name("password")).sendKeys("supersecretpassword");
        driver.findElement(By.name("phone")).sendKeys("720-755-1717");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        // select gender
        genders.get(1).click(); // select male, for example

        driver.findElement(By.name("birthday")).sendKeys("12/03/1985");
        driver.findElement(By.id("inlineCheckbox2")).click();

        BrowserUtils.wait(3);
        driver.findElement(By.id("wooden_spoon")).click();

        BrowserUtils.wait(3);


        driver.quit();
    }
}
