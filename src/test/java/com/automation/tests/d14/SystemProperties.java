package com.automation.tests.d14;

import org.testng.annotations.Test;

public class SystemProperties {


    @Test
    public void test(){

        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperty("os.name"));

        // System.getProperty("user.home") + "/Downloads"
        System.out.println(System.getProperty("user.home"));

        String pathtoDownloads = System.getProperty("user.home") + "/Downloads";
        System.out.println(pathtoDownloads);

        System.out.println(System.getProperty("os.arch"));

        // https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
    }




}
