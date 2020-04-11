package office_hours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class march25_iFrames_Practice {

    // iFrame - web document inside of other web document (html inside of html document)

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
       driver = DriverFactory.createDriver("chrome");
       driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
       driver.quit();

    }


    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        Thread.sleep(2000);
        // we landed to red web document - default content
        driver.switchTo().frame("frame-top");
        // we are landed to blue web document
        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));

        // we have stored all frames web elements inside the List.
        // First, we will loop through List
        // switch to each frame:
        //  - get text from body
        //  - switch to parent

//        for(WebElement each : frameList ){
////            driver.navigate().refresh();
////            Thread.sleep(1000);
////            driver.switchTo().frame(each);
////            String bodyText = driver.findElement(By.tagName("body")).getText();
////            System.out.println("Body text: " + bodyText);
////            driver.switchTo().parentFrame();
////        }


        for (int i = 0; i <frameList.size() ; i++) {
          //  driver.navigate().refresh();
            driver.switchTo().frame(i);
            String bodyText = driver.findElement(By.xpath("//body")).getText();
            System.out.println("Body text: " + bodyText);
            driver.switchTo().parentFrame();
        }


        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Body text: " + bodyText);

    }




}
