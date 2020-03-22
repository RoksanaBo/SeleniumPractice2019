package com.automation.tests.day13;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WarmUp {

    // Go to http://practice.cybertekschool.com/tables
    // Click on "Last name" column name
    // Verify that table is sorted by last name in alphabetic order


    //

    @Test
    public void test(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");

        // click on column name
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(4);

        // collect all values from the first column
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));

        for (int i = 0; i <column.size()-1 ; i++) {

            // take a String
            String value = column.get(i).getText();

            //take a following String
            String nextValue = column.get(i+1).getText();
            System.out.println(value.compareTo(nextValue));


            Assert.assertTrue(value.compareTo(nextValue)<=0);

        }
         driver.quit();
    }

}
