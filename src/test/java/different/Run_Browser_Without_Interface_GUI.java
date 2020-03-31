package different;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Run_Browser_Without_Interface_GUI {
private WebDriver driver;

    public void setup() {

        //  how to run browser without GUI , Makes browser invisible. (Interface)
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true); // to run browser without GUI. Makes browser invisible.
        driver = new ChromeDriver(chromeOptions);

        // headless mode makes execution twice faster
        // it does everything except file uploading
        // set it to true to make it work

        // GUI - Graphical User Interface

    }
}
