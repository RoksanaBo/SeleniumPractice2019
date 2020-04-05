package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

// this class provides setup and clan up part for all our test

public abstract class AbstractTestBase {  // abstract --> not concrete.
                                  // this class has to be extended! этот класс должен быть расширен!

    protected WebDriverWait wait; // protected will be visible within package or within subclass
    protected Actions actions;


    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;


    @BeforeTest // to create a report
    public void setupTest(){
       report = new ExtentReports();
       String reportPath = "";

       // location of report file
       if(System.getProperty("os.name").toLowerCase().contains("win")){
          reportPath = System.getProperty("user.dir")+"\\test-output\\report.html";
       }else {
           reportPath = System.getProperty("user.dir")+"/test-output/report.html";
       }
       // is a HTML report itself
       htmlReporter = new ExtentHtmlReporter(reportPath);
       // add it to the reporter
       report.attachReporter(htmlReporter);
       htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }



    @AfterTest
    public void afterTest(){
        report.flush(); // to release a report
    }



    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(),15);
        actions = new Actions(Driver.getDriver());

    }


    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {

        // ITestResult class describes the result of a test.
        // if test failed, take a screenshot
        if(iTestResult.getStatus() == ITestResult.FAILURE){
            //screenshot will have a name of the test
            String screenshotPath = BrowserUtils.getScreenShot(iTestResult.getName());
            BrowserUtils.getScreenShot(iTestResult.getName());
            test.addScreenCaptureFromPath(screenshotPath);// attach screenshot
            test.fail(iTestResult.getName()); // attach test name that failed
            test.fail(iTestResult.getThrowable()); // attach console output
        }
        Driver.closeDriver();
    }

}
