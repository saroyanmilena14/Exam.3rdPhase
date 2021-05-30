package Tests.stafffam;

import Pages.staffam.HomePage;
import Pages.staffam.JobArticlesPage;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;




public class StaffAm {


    WebDriver driver;
    WebDriverWait wait;
    String myCategorytext = "Sales/service management";


    @BeforeSuite
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

    }
    @BeforeClass
    public void  OpeningStaffAmAndChoosingAJobCategory () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staff.am");

        HomePage homePage=new HomePage(driver, wait);
        homePage.waitForPageLoad();

        homePage.selectingCategory(myCategorytext);
    }
    @Test
    public void testProject() {

        JobArticlesPage jobArticlesPage=new JobArticlesPage(driver,wait);
        jobArticlesPage.waitForPageLoad();

        Assert.assertNotNull(jobArticlesPage.checkTheCheckBox(myCategorytext), "Your chosen category didn't appear in checkbox.");


        if(jobArticlesPage.getCountFromFilterbar()>=100) {
            Assert.assertEquals(jobArticlesPage.findCountOfAllJobArticlesOnPage(),100);
        }
        else if(jobArticlesPage.getCountFromFilterbar()<100){
            Assert.assertEquals(jobArticlesPage.getCountFromFilterbar(),jobArticlesPage.findCountOfAllJobArticlesOnPage());
        }

    }


    @AfterClass
            public void quitingTest() {
        driver.quit();
    }}

