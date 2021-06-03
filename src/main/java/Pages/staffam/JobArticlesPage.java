package Pages.staffam;

import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class JobArticlesPage extends BasePage{

    private By allArticlesOnPageLoc = By.xpath("//div[@data-key]");
    private String checkBoxLocTemplate = "//en[text()='%s']/preceding::input[@checked='checked']";
    private By countOfJobArticlesLoc = By.xpath("//input[@checked='checked']/following-sibling::span[@data-count]");
    private String LanguageLocTemplate = "//li[@id='lang-dropdown']//a[text()='%s']";
    private By selectedJobTitleLoc = By.xpath("//div[@id='job-post']//div[@class='row']//h2");


    public JobArticlesPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,20);
    }


    private WebDriverWait wait;
    private By featuredJobsButtonLoc = By.xpath("//div[@class='row featured-jobs-row']//label[@class='featured-jobs-lbl']//span");




    public void waitForPageLoad() {

        wait.until(ExpectedConditions.elementToBeClickable(featuredJobsButtonLoc));
    }

    public int findCountOfAllJobArticlesOnPage() {
        List<WebElement> allArticlesOnPage = driver.findElements(allArticlesOnPageLoc);
        return allArticlesOnPage.size();
    }

    public String checkTheCheckBox(String myCategorytext) {
        String actualCategoryText = String.format(checkBoxLocTemplate, myCategorytext);
        WebElement checked = driver.findElement(By.xpath(actualCategoryText));

        try {
            return checked.getAttribute("checked");

        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public int getCountFromFilterbar() {
        String countFromFilterBarText = driver.findElement(countOfJobArticlesLoc).getText().replace("(", "").replace(")", "");

        return Integer.parseInt(countFromFilterBarText);
    }

    public String getRandomJobTitle() {
        List<WebElement> allJobsOnPage = driver.findElements(By.xpath("//div[@data-key]"));
        WebElement randomJob = allJobsOnPage.get(new Random().nextInt(allJobsOnPage.size()));
        String randomJobText = randomJob.getText();
        String randomJobTitle = randomJobText.substring(0, randomJobText.indexOf("\n"));
        randomJob.click();
        return randomJobTitle;
    }

    public String getSelectedJobTitle() {
        return driver.findElement(selectedJobTitleLoc).getText();
    }


    public void ChangePageLanguageAndCheckTitle(String languageName) {
        WebElement chooseLanguageButton = driver.findElement(By.xpath("//li[@id='lang-dropdown']//a[@data-toggle='dropdown']"));
        chooseLanguageButton.click();
        String actualLanguageText = String.format(LanguageLocTemplate, languageName);
        WebElement chooseTheWantedLanguage = driver.findElement(By.xpath(actualLanguageText));
        chooseTheWantedLanguage.click();

    }


    public String getSelectedJobTitleAfterChangingLang() {
        return driver.findElement(selectedJobTitleLoc).getText();
    }

}

