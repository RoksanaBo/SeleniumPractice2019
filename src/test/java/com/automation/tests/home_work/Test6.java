package com.automation.tests.home_work;

import org.openqa.selenium.WebDriver;

public class Test6 {

    // Test case #6
    // Step 1. Go to "https://www.tempmailaddress.com/"
    // Step 2. Copy and save email as a string.
    // Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
    // Step 4. And click on “Sign Up For Mailing List"
    // Step 5. Enter any valid name.
    // Step 6. Enter email from the Step 2
    // Step 7. Click Sign Up
    // Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to
    //                                                                                     return to the home page.”
    // Step 9. Navigate back to the “https://www.tempmailaddress.com/”
    // Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
    // Step 11. Click on that email to open it.
    // Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
    // Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”


    private WebDriver driver;
    private String URL = "https://www.tempmailaddress.com/";

}
