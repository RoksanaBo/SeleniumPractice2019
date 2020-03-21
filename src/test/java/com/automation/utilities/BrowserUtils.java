package com.automation.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static void wait(int seconds) {

        // to slow down our program

        try {
            Thread.sleep(1000 * seconds);

        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }

    /**
     *
     * @param elements represents collection of WebElements
     * @return collection of Strings
     */

    public static List<String> getTextFromWebElements(List<WebElement> elements){

        List<String> textValues = new ArrayList<>();
        for(WebElement element:elements){
            textValues.add(element.getText());
        }
        return textValues;
    }

}
