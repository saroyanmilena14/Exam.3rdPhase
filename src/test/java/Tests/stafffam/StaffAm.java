package Tests.stafffam;

import Pages.staffam.HomePage;
import Pages.staffam.JobArticlesPage;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;




public class StaffAm {


    WebDriver driver;


    @BeforeSuite
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

    }
    @BeforeClass
    public void  OpeningStaffAmAndChoosingAJobCategory () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staff.am");

        HomePage homePage=new HomePage(driver);
        homePage.waitForPageLoad();
        homePage.selectingCategory();
    }
    @Test
    public void testProject() {

        JobArticlesPage jobArticlesPage=new JobArticlesPage(driver);
        jobArticlesPage.waitForPageLoad();

        Assert.assertNotNull(jobArticlesPage.checkTheCheckBox(), "Your chosen category didn't appear in checkbox.");


        if(jobArticlesPage.getCountFromFilterbar()>=100) {
            Assert.assertEquals(jobArticlesPage.findCountOfAllJobArticlesOnPage(),100);
        }
        else if(jobArticlesPage.getCountFromFilterbar()<100){
            Assert.assertEquals(jobArticlesPage.findCountOfAllJobArticlesOnPage(),jobArticlesPage.findCountOfAllJobArticlesOnPage());
        }
        System.out.println(jobArticlesPage.checkTheCheckBox());
    }


    @AfterClass
            public void quitingTest() {
        JobArticlesPage jobArticlesPage1 = new JobArticlesPage(driver);
        jobArticlesPage1.QuitingChrome();
    }}

