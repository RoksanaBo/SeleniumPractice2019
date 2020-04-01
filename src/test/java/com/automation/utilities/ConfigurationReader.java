package com.automation.utilities;

import java.io.FileInputStream;
import java.util.Properties;
// this static block will be executed only once when class will be loaded.

public class ConfigurationReader {

    private static Properties configFile;
    static {
        try {
            // to get the properties file,
            String path = System.getProperty("user.dir")+"/configuration.properties";

            // get something outside of program ,convert it ,
            // and we can use that data inside our java program.
            // it takes that file and load it into our program
            FileInputStream input = new FileInputStream(path);

            // we can load here our custom properties.
            // those properties from system we don't touch.
            // they are system's.
            // But this class Properties() allows us to load our own custom properties
            // that are coming from here  and use them during the program execution.
            configFile = new Properties();

            // load properties file into Properties object
            configFile.load(input);

            // close the input stream at the end
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }


    // Instance block:
    // it will be executed when Object will be created
    // at the beginning.
    // it returns value of the properties as a String

    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }

}
