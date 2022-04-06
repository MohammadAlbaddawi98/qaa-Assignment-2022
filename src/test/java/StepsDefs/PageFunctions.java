package StepsDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static StepsDefs.earlyFunctions.getHome_Page;

public class PageFunctions {
    private static final String HomePage = getHome_Page();

    public static void PageChanger(WebDriver driver, String pageName) {
        if (pageName.equals("Home") || pageName.equals(HomePage))
            driver.get(pageName);
        else
            driver.get(HomePage + "/" + pageName);
    }

    public static void Search_bar(WebDriver driver, String key) {
        WebElement searchField = driver.findElement(By.className("form-control"));
        searchField.sendKeys(key);
        searchField.submit();
    }

    public static void checkPageStat(String url) {
        System.out.println(url);
        try {
            HttpURLConnection c = null;
            c = (HttpURLConnection) new URL(url).openConnection();
            c.setRequestMethod("HEAD");
            c.connect();
            int responseCode = c.getResponseCode();
            if (responseCode == 404) {
                System.out.println("Page can not load , Error Page 404");
            }
            Assert.assertEquals(200, responseCode);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static String getURL(WebDriver driver) {
        String url = driver.getCurrentUrl();
        return url;
    }

    public static void pressed_by_linkText(WebDriver driver, String bottonName) {
        driver.findElement(By.linkText(bottonName)).click();
    }

    public static void pressed_by_xpath(WebDriver driver, String bottonpath) {
        driver.findElement(By.xpath(bottonpath)).click();

    }

    public static void BookList_bottons(WebDriver driver, String ButtonName, String book_title) {

        int rows_num = (driver.findElements(By.xpath("//table/tbody/tr"))).size();

        for (int i = 1; i <= rows_num; i++) {
            String title_path = String.format("//table/tbody/tr[%s]/td[1]", i + "");
            String EditBotton_path = String.format("//table/tbody/tr[%s]/td[3]/a", i + "");
            String DeleteBotton_path = String.format("//table/tbody/tr[%s]/td[4]/a", i + "");
            try {
                if (book_title.equals(driver.findElement(By.xpath(title_path)).getText())) {
                    if (ButtonName.equals("delete")) {
                        driver.findElement(By.xpath(DeleteBotton_path)).click();
                        Assert.assertEquals(ButtonName, "delete");
                    } else {
                        driver.findElement(By.xpath(EditBotton_path)).click();
                        Assert.assertEquals(ButtonName, "edit");
                    }
                }
            } catch (NoSuchElementException e) {
                i++;
                continue;
            }
        }


    }

    public static void Title_Year_filler(WebDriver driver, String Title, String Year, String Botton_bath) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement book = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
        if (book != null) {
            System.out.println("***> website accept to publish the same book more than one time, " + Title + " is exist !!!!");
            Assert.assertFalse(true);
        }

        try {
            double d = Double.parseDouble(Year);
        } catch (NumberFormatException nfe) {
            System.out.println("***> website accept a year contain characters -->" + Year);
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("year")).clear();

        driver.findElement(By.id("title")).sendKeys(Title);
        driver.findElement(By.id("year")).sendKeys(Year);

        pressed_by_xpath(driver, Botton_bath);

    }

    public static void check_book_If_Exist(WebDriver driver, String book_title) {

        int rows_num = (driver.findElements(By.xpath("//table/tbody/tr"))).size();

        for (int i = 1; i <= rows_num; i++) {
            String title_path = String.format("//table/tbody/tr[%s]/td[1]", i + "");
            if (book_title.equals(driver.findElement(By.xpath(title_path)).getText())) {
                Assert.assertEquals(1, 0);
            }
        }
        Assert.assertEquals(1, 1);
    }


}
