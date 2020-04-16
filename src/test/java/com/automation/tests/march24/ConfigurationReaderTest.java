package com.automation.tests.march24;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){
        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("qa1");
        String color = ConfigurationReader.getProperty("color");


        String storeManager = ConfigurationReader.getProperty("store_manager");
        String password = ConfigurationReader.getProperty("password");
        String driver = ConfigurationReader.getProperty("driver");

        System.out.println(browser);
        System.out.println(url);
        System.out.println(color);
        System.out.println(storeManager);
        System.out.println(password);
        System.out.println(driver);


    }
}
