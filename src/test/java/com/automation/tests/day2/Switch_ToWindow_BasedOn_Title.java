package com.automation.tests.day2;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class Switch_ToWindow_BasedOn_Title {

    public static void main(String[] args) {


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
