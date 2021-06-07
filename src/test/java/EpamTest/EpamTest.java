package EpamTest;

import EpamPages.HistoryOfEpamPage;
import EpamPages.HomePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class EpamTest {

    WebDriver driver;
    String categoryText = "Software Test Engineering";
    String categoryText1 = "Training & Coaching";
    String contenText = "About";
    String subMenuText = "History";

    @BeforeSuite
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

    }

    @BeforeClass
    public void OpeningStaffAmAndChoosingAJobCategory() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.waitForPageLoad();
        homePage.SelectingJobCategory(categoryText1);
        try {
            Assert.assertNotNull(homePage.CheckIfJobsAreDisplayed());
        } catch (AssertionError e) {
            System.out.println("Sorry, your search returned no results. Please try another combination.");

        }
        homePage.GoToAboutThenHistoryPage(contenText, subMenuText);
    }

    @Test
    public void testHistoryPAge() {
        HistoryOfEpamPage historyOfEpamPage = new HistoryOfEpamPage(driver);
        historyOfEpamPage.waitForPageLoad();
        Assert.assertNotNull(historyOfEpamPage.CheckIfAllElemsAreDisplayed(), "The element you are looking for is not displayed.");
    }
}