package com.automation.tests.march8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText_MultipleOptions {
    public static void main(String[] args) {

        //    WebDriverManager.chromedriver().setup();
        //    WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);



        // Whether this select element support selecting multiple options at the same time?
        // This is done by checking the value of the "multiple " attribute

        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);// if its true, you can select more than one option.


        BrowserUtils.wait(3);

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");



        // let's get all selected options:
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();

        for(WebElement selectedLanguage : selectedLanguages){
            System.out.println(selectedLanguage.getText());
        }
        BrowserUtils.wait(3);



        languagesSelect.deselectByVisibleText("Java");// to unselect something
        BrowserUtils.wait(2);


        languagesSelect.deselectAll();



        BrowserUtils.wait(2);
        driver.quit();












    }
}
