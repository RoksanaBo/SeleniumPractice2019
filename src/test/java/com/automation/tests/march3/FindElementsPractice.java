package com.automation.tests.march3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsPractice {

    public static void main(String[] args) throws Exception{

    //    WebDriverManager.chromedriver().setup();
    //    WebDriver driver = new ChromeDriver();

        // test package -this is where we gonna store all our tests.
        // utilities - package for storing reusable methods that will support our tests.
        // for example - we can create a class with the method that will give us a WebDriver whenever we need it.



        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");

        Thread.sleep(3000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");

        Thread.sleep(3000);

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));

        //when you see type="submit", you can use submit() instead of click()
        //it make sense to use when click() method doesn't work

        signUp.submit(); // or signUp.click();
        Thread.sleep(2000);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";

        WebElement message = driver.findElement(By.className("subheader"));

        String actual = message.getText(); // To get the text <h3>Text</h3>

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.quit();//to close everything





    }
}
