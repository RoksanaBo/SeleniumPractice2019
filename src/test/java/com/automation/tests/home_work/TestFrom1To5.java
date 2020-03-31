package com.automation.tests.home_work;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestFrom1To5 {


    private WebDriver driver;
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    //gender
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");

    //languages                   siblings.
    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");


    //sign up button
    private By signUpBy = By.id("wooden_spoon");


    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);
    }


    //Test case #1
    // Step 1. Go to "https://practice-cybertekschool.herokuapp.com/"
    // Step 2. Click on "Registration Form"
    // Step 3. Enter "wrong_dob" into date of birth input box.
    // Step 4. Verify that warning message is displayed: "The date of birth is not valid"
    @Test
    public void testCase1(){

        driver.findElement(By.linkText("Registration Form")).click();


        BrowserUtils.wait(2);
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");

        BrowserUtils.wait(2);

        String expected = "The date of birth is not valid";
        String actual = driver.findElement(By.xpath("//*[@id='registrationForm']/div[8]/div/small[2]")).getText();

        System.out.println(actual);
        Assert.assertEquals(actual,expected,"incorrect");


    }



    // Test case #2
    // Step 1. Go to "https://practice-cybertekschool.herokuapp.com/"
    // Step 2. Click on "Registration Form"
    // Step 3. Verify that following options for programming languages
    // are displayed: c++, java, JavaScript

    @Test
    public void testCase2(){

        driver.findElement(By.linkText("Registration Form")).click();

        List<WebElement> languages = driver.findElements(By.className("form-check-label"));

         Assert.assertTrue(languages.get(0).isDisplayed());
         Assert.assertTrue(languages.get(1).isDisplayed());
         Assert.assertTrue(languages.get(2).isDisplayed());


    }


    // Test case #3
    // Step 1. Go to "https://practice-cybertekschool.herokuapp.com/"
    // Step 2. Click on "Registration Form"
    // Step 3. Enter only one alphabetic character into first name input box.
    // Step 4. Verify that warning message is displayed:
    // “first name must be more than 2 and less than 64 characters long"

    @Test
    public void testCase3(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(firstNameBy).sendKeys("b",Keys.ENTER);

        BrowserUtils.wait(4);

        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));

        //  error message  сообщение должно быть видно:
        Assert.assertTrue(warningMessage.isDisplayed());
    }


    //Test case #4
    // Step 1. Go to "https://practice-cybertekschool.herokuapp.com/"
    // Step 2. Click on "Registration Form"
    // Step 3. Enter only one alphabetic character into last name input box.
    // Step 4. Verify that warning message is displayed:
    // “The last name must be more than 2 and less than 64 characters long”

    @Test
    public void testCase4(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(lastNameBy).sendKeys("b",Keys.ENTER);

        WebElement lastNameWarningMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));

        BrowserUtils.wait(3);
        Assert.assertTrue(lastNameWarningMessage.isDisplayed());
    }


    // Test case #5
    // Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    // Step 2. Click on “Registration Form”
    // Step 3. Enter any valid first name
    // Step 4. Enter any valid last name.
    // Step 5. Enter any valid user name
    // Step 6. Enter any valid password
    // Step 7. Enter any valid phone number
    // Step 8. Select gender
    // Step 9. Enter any valid date of birth
    // Step 10. Select any department.
    // Step 11. Enter any job title.
    // Step 12. Select java as a programming language.
    // Step 13. Click Sign up.
    // Step 14. Verify that following success message is displayed:
    // "You've successfully completed registration!”

    // Note: for using dropdown, please refer to the
    // documentation: https://selenium.dev/selenium/
    // docs/api/java/org/openqa/selenium/support/ui/
    // Select.html or, please watch short video about dropdowns that is posted on canvas.


    @Test
    public void testCase5(){

        driver.findElement(firstNameBy).sendKeys("Patrick");
        driver.findElement(lastNameBy).sendKeys("White");
        driver.findElement(usernameBy).sendKeys("testuser");
        driver.findElement(emailBy).sendKeys("test@email.com");
        driver.findElement(passwordBy).sendKeys("123455678");
        driver.findElement(phoneBy).sendKeys("234-123-1231");

        driver.findElement(femaleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("01/02/1940");

        // Department / Office :  dropdown
        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        // Job title:       dropdown
        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();
BrowserUtils.wait(5);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual, expected);
    }


    @AfterMethod
    public void teardown(){

        driver.quit();
    }

}
