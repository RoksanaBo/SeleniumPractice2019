package com.automation.tests.d2_March1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow_ImportantMethodInside {

    public static void main(String[] args)throws Exception {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);


        // every window has some id, this id calls window handle
        // based on window handle, we can switch in between windows:
        String windowHandle = driver.getWindowHandle();
        System.out.println("window handle / window id : " + windowHandle);


        // this method returns id of all currently opened windows
        // Set only allows unique values
        Set<String> windowHandles =driver.getWindowHandles();
        System.out.println(windowHandles);


        // since we have all windows
        // and we know id of original window
        // we can say switch to something that
        // is not equals to old window id
        System.out.println("before switch : " + driver.getCurrentUrl());

        for(String windowID: windowHandles){
            // if it's not old window (same window),then switch
            if( ! windowID.equals(windowHandle)){
                // to jump to the new window:
                driver.switchTo().window(windowID);
            }
        }
        System.out.println("after switch : " + driver.getCurrentUrl());
        driver.close();


    }




    /**
     * This method helps to switch in between
     * windows based on page title
     *
     * @param pageTitle
     * @param driver
     */
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();

        for(String window:windows){
            driver.switchTo().window(window);

            if(driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }




}
