package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RadioButtons {

    public static void main(String[] args)throws Exception {


        WebDriverManager.chromedriver().version("79").setup(); // if browser has an issue
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        driver.manage().window().maximize();

      BrowserUtils.wait(2);


      List<WebElement> radioButtons = driver.findElement(By.tagName("input"));


      for(WebElement radioButton : radioButtons){

          radioButton.click();
          BrowserUtils.wait(1);
      }




        driver.quit();




    }
}
