package com.automation.tests.practice_page;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Sortable_DataTables {


    // td - table data
    // tr - table row
    // th - table header
    // tbody - table body
    // tfooter - table footer нижний колонтитул


    private WebDriver driver;



    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        //  how to run brouser without GUI , Makes browser invisible. (Interface)
        //
        //  WebDriverManager.chromedriver().version("79").setup();
        //  ChromeOptions chromeOptions = new ChromeOptions();
        //  chromeOptions.setHeadless(true);
        //  driver= new ChromeDriver(chromeOptions);

        // headless mode makes execution twice faster
        // it does everything except file uploading
        // set it to true to make it work



    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }



    @Test
    public void getColumnNames() {
        //th - represents table header cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));// table 1 all table headers

        //just to print
        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());// to get all header names
        }

        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
        // BrowserUtils.getTextFromWebElements --> we call this method from utilities-->BrowserUtils

        //table[@id='table1'] --> to find the whole table


    }




    @Test
    public void verifyRowCount(){

        // tbody // tr - to get all rows from table body, excluding table header
        //               получить все строки из тела таблицы, кроме заголовка таблицы

        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));

        // if we will get a size of this collection, it automatically equals to number of elements(rows)
        // expected - 4 rows in the table
        Assert.assertEquals(rows.size(),4);

    }



    /**
     * To get specific column, skip row index, and just provide td index
     */
    @Test
    public void getSpecificColumn(){

        //td[5] - column with links     td --> column
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }






    /** Task:
     * Go to tables example page
     * Delete record with jsmith@gmail.com email
     * verify that number of rows is equals to 3
     * verify that jsmith@gmail.com doesn't exists any more in the table
     */

    @Test
    public void deleteRowTest() {
        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();

        BrowserUtils.wait(3);

        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();

        Assert.assertEquals(rowCount, 3);

        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));

        Assert.assertTrue(emails.isEmpty());
    }



    /**
     * Let's write a function that will return column index based on column name
     */

    @Test
    public void getColumnIndexByName(){

        String columnName = "Email";

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        int index = 0; // column index
        for (int i = 0; i < columnNames.size(); i++) {

            String actualColumnName = columnNames.get(i).getText();
            System.out.println(String.format("Column name: %s, position %s", actualColumnName, i ));


            if(actualColumnName.equals(columnName)){
                index = i+1; // in xpath index starts with 1   , in java with 0
                break;
            }

        }

        // position of email is 3
        Assert.assertEquals(index,3);

    }





    @Test
    public void getSpecificCell(){

        String expected = "http://www.jdoe.com";
        int row = 3;
        int column = 5;
        String xpath = "//table[1]//tbody//tr[" + row + "]//td[" + column+ "]";

        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(),expected);



    }

}
