package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFor_iFrame {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(4);


        //before looking for that element, we need to jump to that frame
        // You can specify : name,id, index or web element of the frame
        // it's like we are jumping to another layer.
        driver.switchTo().frame("mce_0_ifr");
        //now, this content will be visible

        WebElement textInput = driver.findElement(By.id("tinymce"));
        System.out.println(textInput.getText());

        //exit from the frame:
        driver.switchTo().defaultContent();

        driver.quit();
    }
}
