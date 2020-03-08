package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {

        //    WebDriverManager.chromedriver().setup();
        //    WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        // create webElement object or dropdown:
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));


        // provide webElement object into constructor:
        Select selectSimpleDropdown = new Select(simpleDropdown);


        // select by visible text:
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);


        // and select option 1 :
        selectSimpleDropdown.selectByVisibleText("Option 1");


        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("1985");
        selectMonth.selectByVisibleText("December");
        selectDay.selectByVisibleText("3");


        // select all months one by one,
        // .getOptions() --> returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for(WebElement eachMonth :months){

            // get the month name and select based on that:
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(2);
        }


















        BrowserUtils.wait(2);
        driver.quit();










    }
}
