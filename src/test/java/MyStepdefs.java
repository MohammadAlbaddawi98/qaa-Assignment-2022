import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static StepsDefs.PageFunctions.*;
import static StepsDefs.earlyFunctions.*;

public class MyStepdefs {
    private WebDriver driver;
    private String Home_Page;

    @Before
    public void setUpDriver() {
        this.driver = setup();
        Home_Page = getHome_Page();
    }

    @After
    public void quitDriver() {
        TearDown();
    }

    /*
     **
     ****
     First feature
     ****
     **
     */

    @Given("a web browser is on main website page.")
    public void WebBrowser_Is_On_MainWebsite() {
        PageChanger(driver, Home_Page);
        Assert.assertEquals("Home", driver.getTitle());
    }


    @When("the search phrase  {string} is entered.")
    public void theSearchPhraseIsEntered(String arg0) {
        Search_bar(driver, arg0);
    }

    @Then("results for {string} are shown")
    public void resultsForAreShown(String arg0) {
        checkPageStat(getURL(driver));
        Assert.assertNotEquals("Home", getPageTitle(driver));


    }

    /*
     **
     ****
     second feature
     ****
     **
     */

    @Given("a web browser is on Home page")
    public void aWebBrowserIsOnHomePage() {
        PageChanger(driver, Home_Page);
        Assert.assertEquals("Home", getPageTitle(driver));
    }

    @When("pressed on {string} botton.")
    public void pressed_Botton(String arg0) {

        pressed_by_linkText(driver, arg0);
    }


    @Then("{string} page are shown.")
    public void pageAreShown(String arg0) throws IOException {
        switch (arg0) {
            case "Home":
                checkPageStat(getURL(driver));
                Assert.assertEquals("Home", getPageTitle(driver));
                break;
            case "Books":
                checkPageStat(getURL(driver));
                Assert.assertEquals("Books", getPageTitle(driver));
                break;
            case "Authors":
                checkPageStat(getURL(driver));
                Assert.assertEquals("authors", getPageTitle(driver));
                break;
            default:
                Assert.assertEquals(1, 0);
        }


    }


    /*
     **
     ****
     third feature
     ****
     **
     */

    @Given("a web browser is on books page.")
    public void aWebBrowserIsOnBooksPage() {
        PageChanger(driver, "books");
        Assert.assertEquals("Books", getPageTitle(driver));
    }

    @When("pressed on {string} botton for {string} book.")
    public void pressedOnEditBottonFor(String order, String book_name) {

        BookList_bottons(driver, order, book_name);
    }

    @Then("change book title to {string} and year to {string}")
    public void changeBookTitleToAndYearTo(String arg0, String arg1) {
        Title_Year_filler(driver, arg0, arg1, "//*[@id=\"bookForm\"]/div[2]/button[1]");
    }


    @Then("check if {string} still exist in book list")
    public void checkIfStillExistInBookList(String book_title) {
        check_book_If_Exist(driver, book_title);

    }

    @When("pressed on Create book botton.")
    public void pressedOnCreateBookBotton() {
        pressed_by_xpath(driver, "/html/body/div/div/div[2]/div/a");
    }

    @Then("enter book title {string} and year {string}")
    public void enterBookTitleAndYear(String arg0, String arg1) {
        Title_Year_filler(driver, arg0, arg1, "/html/body/div/div/div[2]/form/div[2]/button[1]");
    }


}
