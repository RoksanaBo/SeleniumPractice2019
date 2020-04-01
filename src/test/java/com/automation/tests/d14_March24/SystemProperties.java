package com.automation.tests.d14_March24;

import org.testng.annotations.Test;

public class SystemProperties {


    @Test
    public void test(){

        // C:\Users\Bars\IdeaProjects\SeleniumPractice2019
        // System.out.println(System.getProperty("user.dir"))+ "/pom.xml"
        System.out.println(System.getProperty("user.dir"));// user directory

        System.out.println(System.getProperty("os.name"));
         // flexible path to download folder
        // System.getProperty("user.home") + "/Downloads"
        System.out.println(System.getProperty("user.home"));// this will find downloads for every computer

        // path - путь
        // for Windows use \\ instead of /
        String pathToDownloads = System.getProperty("user.home") + "/Downloads";// for Windows
        System.out.println(pathToDownloads);

        // architecture
        System.out.println(System.getProperty("os.arch"));


        // System Properties :
        // https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
    }




}
