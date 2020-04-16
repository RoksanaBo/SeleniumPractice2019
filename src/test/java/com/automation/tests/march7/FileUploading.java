package com.automation.tests.march7;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(4);

        WebElement upload = driver.findElement(By.id("file-upload"));

        String filePath = System.getProperty("user.dir")+"/pom.xml";

        // System.getProperty --> returns the location of your property

        System.out.println(filePath); // print path


        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click(); // click to upload


        BrowserUtils.wait(5);
        driver.quit();


        // to upload file in selenium --> you need to use sendKeys() method
        // and provide path to the file


    }
}
