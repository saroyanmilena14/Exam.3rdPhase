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
    String myCategorytext = "Sales/service management";
    String languageName="ՀԱՅ";


    @BeforeSuite
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

    }
    @BeforeClass
    public void  OpeningStaffAmAndChoosingAJobCategory () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        HomePage homePage=new HomePage(driver);
        homePage.open();
        homePage.waitForPageLoad();

        homePage.selectingCategory(myCategorytext);
    }
    @Test
    public void testProject() {

        JobArticlesPage jobArticlesPage=new JobArticlesPage(driver);
        jobArticlesPage.waitForPageLoad();


        Assert.assertNotNull(jobArticlesPage.checkTheCheckBox(myCategorytext), "Your chosen category didn't appear in checkbox.");


        if(jobArticlesPage.getCountFromFilterbar()>=100) {
            Assert.assertEquals(jobArticlesPage.findCountOfAllJobArticlesOnPage(),100);
        }
        else if(jobArticlesPage.getCountFromFilterbar()<100){
            Assert.assertEquals(jobArticlesPage.getCountFromFilterbar(),jobArticlesPage.findCountOfAllJobArticlesOnPage());
        }


        String selectedJobTitleBeforeChanges="";
        Assert.assertEquals(jobArticlesPage.getRandomJobTitle(),selectedJobTitleBeforeChanges=jobArticlesPage.getSelectedJobTitle());

        jobArticlesPage.ChangePageLanguageAndCheckTitle(languageName);

        Assert.assertEquals(jobArticlesPage.getSelectedJobTitle(),selectedJobTitleBeforeChanges);

    }



    @AfterClass
            public void quitingTest() {
        driver.quit();
    }}

