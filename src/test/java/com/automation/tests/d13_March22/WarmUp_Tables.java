package com.automation.tests.d13_March22;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WarmUp_Tables {

    // Go to http://practice.cybertekschool.com/tables
    // Click on "Last name" column name
    // Verify that table is sorted by last name in alphabetic order


    //ASCII Table :
    // how compareTo works:
    // "a".compareTo("b") = -1
    // 61-62 = -1
    // a is before b

    // "a".compareTo("a")
    // 61-61 = 0
    // 0 means 2 Strings are equals

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

            // compareTo() --> helps to compare 2 strings.
            // takes first character of one string and first character of another String
            // and finds the difference.

            //"a".compareTo("b") = -1
            // 61 - 62 = -1
            // a is before b
            // "a".compareTo("a")
            // 61 - 61 = 0
            // 0 means 2 strings are equals

            //if difference is negative - order value is before nextValue in alphabetic order
            //if difference is positive - order value is after nextValue in alphabetic order
            //if difference is 0 - value and nextValue are equals

            Assert.assertTrue(value.compareTo(nextValue)<=0);

        }
         driver.quit();
    }

}
