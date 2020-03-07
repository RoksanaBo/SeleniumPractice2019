package com.automation.utilities;

public class BrowserUtils {

    public static void wait(int seconds) {

        // to slow down our program

        try {
            Thread.sleep(1000 * seconds);

        }catch (InterruptedException e){
            e.printStackTrace();
        }




    }
}
