package com.automation.tests.d2_March1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{

        // to start Selenium script we need to :
        // setup webDriver (browser driver) and create webDriver object

        WebDriverManager.chromedriver().setup();  // for google Chrome
        ChromeDriver driver = new ChromeDriver();

        // in Selenium everything starts from WebDriver Interface

        // ChromeDriver extends RemoteWebDriver --> implements WebDriver

        driver.get("http://google.com"); // to open the web site

        driver.manage().window().maximize(); // to maximize screen

        // driver.manage().window().fullscreen(); // full screen

        Thread.sleep(2000); // for demo - wait 2 seconds


        String title = driver.getTitle(); // returns <title>Some title</title> text

        String expectedTitle = "Google"; // we provide it

        System.out.println("Title is : " + title);
        //this method returns page title
        // you can also see it as tab name, in the browser

        if(expectedTitle.equals(title)){
            System.out.println("test passed");
        }else
            System.out.println("test failed");



        // go to another website within the same window
        driver.navigate().to("http://amazon.com");

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }




        driver.navigate().back();


        Thread.sleep(2000);
        // checking if page title equals to Google
        verifyEquals(driver.getTitle(),"Google");


        //move forward in the browser history:
        driver.navigate().forward();

        Thread.sleep(2000);
        System.out.println("title " + driver.getTitle());


        System.out.println("URL : " + driver.getCurrentUrl()); // to get URL


        driver.navigate().refresh(); // to reload page
        Thread.sleep(2000);



        driver.close(); // to close browser, browser cannot close itself.


    }

    /**
     * Check if two strings are same. If print TEST PASSED
     * Otherwise, print TEST FAILED message
     * @param arg1
     * @param arg2
     */

    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

    }


}
