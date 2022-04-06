package StepsDefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class earlyFunctions {
    public static final String Home_Page = "http://localhost:8080/";
    public static WebDriver driver;


    public static String getHome_Page() {
        return Home_Page;
    }


    public static WebDriver setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        /*

        //for any version of chrome driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        */

        return driver;
    }

    public static void TearDown() {
        driver.quit();
    }
}
