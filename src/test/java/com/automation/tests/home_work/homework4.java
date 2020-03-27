package com.automation.tests.home_work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class homework4 {

    protected static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// to avoid throws error:
        // NoSuchElementException

    }

    @AfterMethod
    public void done() {
        driver.quit();

    }

    @Test
    public void days() {

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        List<WebElement> l1 = driver.findElements(By.cssSelector(".gwt-CheckBox>label"));

        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".gwt-CheckBox>input"));

        Random r = new Random();

        int count = 0;
        while (count < 3) {
            // this method will return any value between 0 and 7
            int index = r.nextInt(l1.size());
            if (checkboxes.get(index).isEnabled()) {
                l1.get(index).click();
                if (l1.get(index).getText().equals("Friday")) {
                    count++;
                }
                System.out.println(l1.get(index).getText());
                l1.get(index).click();
            }

        }

    }


    //1. go to http://practice.cybertekschool.com/dropdown
    //2. verify that dropdowns under Select your date of birth display current year, month, day
    @Test
    public void todays_date(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        Select y=new Select(year);
        Select m = new Select(month);
        Select d = new Select(day);

        String year_value = y.getFirstSelectedOption().getText();
        String month_value = m.getFirstSelectedOption().getText();
        String day_value = d.getFirstSelectedOption().getText();

        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMMMdd");


        //   SimpleDateFormat - method that helps to format our date
        Assert.assertEquals(year_value+month_value+day_value, sf.format(new Date()));

    }



    //1. go to http://practice.cybertekschool.com/dropdown
    //2. select a random year under Select your date of birth
    //3. select month January
    //4. verify that days dropdown has current number of days
    //5. repeat steps 3, 4 for all the months

    //NOTE: if you randomly select a leap year, verify February has 29 days
    @Test
    public void years_months_days() {


        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        Select y = new Select(year);
        Select m = new Select(month);
        Select d = new Select(day);


        Random r = new Random();
        int index = r.nextInt(y.getOptions().size()); // returns List<WebElement> ....
        y.selectByIndex(index);

        List<String> months31 = new ArrayList<>(Arrays.asList(new String[]{"January", "March", "May", "July", "August", "October", "December"}));

        int febDays;
        int yearValue = Integer.parseInt(y.getFirstSelectedOption().getText());
        if(yearValue %400==0 || (yearValue%4 ==0 && yearValue %100!=0)){
            febDays=29;
        }else{
            febDays=28;
        }
        for(int i =0; i<12; i++){
            m.selectByIndex(i);
            if(months31.contains(m.getFirstSelectedOption().getText())){
                Assert.assertEquals(d.getOptions().size(), 31);
            }else if(m.getFirstSelectedOption().getText().equals("February")){
                Assert.assertEquals(d.getOptions().size(), febDays);
            }else{
                Assert.assertEquals(d.getOptions().size(), 30);
            }
        }
  }



    //1. go to https://www.amazon.com
    //2. verify that default value of the All departments dropdown is All
    //3. verify that options in the All departments dropdown are not sorted alphabetically

  @Test
  public void department_sort(){

      driver.get("https://www.amazon.com");
      Assert.assertEquals(driver.findElement(By.className("nav-search-label")).getText(), "All");
      List<WebElement> l1 =new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();
      boolean notAlphOrder = false;
      for( int i =0; i<l1.size()-1; i++){
          if(l1.get(i).getText().compareTo(l1.get(i+1).getText())>0){
              notAlphOrder=true;
              break;
          }
      }
      Assert.assertTrue(notAlphOrder);





  }

    //1. go to https://www.amazon.com/gp/site-directory
    //2. verify that every main department name (indicated by blue rectangles in the picture) is
    // present in the All departments dropdown (indicated by green rectangle in the picture)

    @Test
    public void main_departments(){
        driver.get("https://www.amazon.com/gp/site-directory");
        List<WebElement> mainDep = driver.findElements(By.tagName("h2"));
        List<WebElement> allDep = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();
        Set<String> mainDepS = new HashSet<>();
        Set<String> allDepS = new HashSet<>();
        for( WebElement each : mainDep){
            mainDepS.add(each.getText());
        }
        for( WebElement each : allDep){
            allDepS.add(each.getText());
        }
        for(String each : mainDepS){
            if(!allDepS.contains(each)){
                System.out.println(each);
                System.out.println("This main dep is not in All depattments list");
            }
        }
        Assert.assertTrue(allDep.containsAll(mainDepS));
    }



    //1. go to https://www.w3schools.com/
    //2. find all the elements in the page with the tag a
    //3. for each of those elements, if it is displayed on the page, print the text and the href of that
    //   element.
    @Test
    public void links(){
        driver.get("https://www.w3schools.com/");
        List<WebElement> l1 = driver.findElements(By.tagName("a"));
        for(WebElement each : l1){
            if(each.isDisplayed()){
                System.out.println(each.getText());
                System.out.println(each.getAttribute("href"));
            }
        }
    }



    //1. go to https://www.selenium.dev/documentation/en/
    //2. find all the elements in the page with the tag a
    //3. verify that all the links are valid
    @Test
    public void valid_links() {

        driver.get("https://www.selenium.dev/documentation/en/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {
            String href = links.get(i).getAttribute("href");
            try {
                URL url = new URL(href);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.connect();
                Assert.assertEquals(httpURLConnection.getResponseCode(), 200);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }



    //1. go to https://amazon.com
    //2. search for "wooden spoon"
    //3. click search
    //4. remember the name and the price of a random result
    //5. click on that random result
    //6. verify default quantity of items is 1
    //7. verify that the name and the price is the same as the one from step 5
    //8. verify button "Add to Cart" is visible
    @Test
    public void cart(){

        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/following-sibling::input")).click();
        List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price']/span[@class='a-offscreen']"));
        int x = new Random().nextInt(price.size());
        x = x==0?1:x;
        String originName = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])["+x+"]")).getText();
        String originPrice = "$" +
                driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[2])["+x+"]")).getText() +"."+
                driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[3])["+x+"]")).getText();
        driver.findElement(By.xpath("(//span[@class='a-price-fraction'])["+x+"]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Qty:']/following-sibling::span")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.id("productTitle")).getText(), originName);
        Assert.assertEquals(driver.findElement(By.id("price_inside_buybox")).getText(), originPrice);
        Assert.assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());


    }


}
