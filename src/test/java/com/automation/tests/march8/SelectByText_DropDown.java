package com.automation.tests.march8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText_DropDown {

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


        // select by visible text: we can see it inside  dropdown
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);


        // and select option 1 :
        selectSimpleDropdown.selectByVisibleText("Option 1");

        // select your DOB:
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("1985");
        selectMonth.selectByVisibleText("December");
        selectDay.selectByVisibleText("3");

        BrowserUtils.wait(3);



        // select all months one by one,
        // .getOptions() --> returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for(WebElement eachMonth :months){

            // get the month name and select based on that:
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(2);
        }




        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District Of Columbia");


        // option that is currently selected
        // getFirstSelectedOption()--> returns a web element.
        // that's why we need to call getText.
        // getText() retrieves visible text from the web element
        String selected = stateSelect.getFirstSelectedOption().getText();
        if(selected.equals("District Of Columbia")){
            System.out.println("Test passed");
        }else{
            System.out.println("test failed");
        }


        BrowserUtils.wait(3);


        List<WebElement> states = stateSelect.getOptions();
        for( WebElement stateOption : states){
            System.out.println(stateOption.getText());
        }













        BrowserUtils.wait(2);
        driver.quit();










    }
}
