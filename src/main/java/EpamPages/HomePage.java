package EpamPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    private String categoryLocTemplate = "//span[normalize-space()='%s']";
    private String headerContentOptionTemplate = "//div[@class='header__content']//a[text()='%s']";
    private String subMenuTextTemplate = "//ul[@class='top-navigation__sub-list']//a[text()='%s']";

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage open() {

        driver.get(BASE_URL);
        return this;
    }


    @FindBy(xpath = "//div[@class='default-label']")
    private WebElement skillsButton;

    @FindBy(xpath = "//form[@id='jobSearchFilterForm']//button[@type='submit']")
    private WebElement searchButton;


    @FindAll(@FindBy(xpath = "//div[@class='search-result__item-info']//a[@class='search-result__item-name']"))
    List<WebElement> allJobs;

    public void SelectingJobCategory(String categoryName) {
        wait.until(ExpectedConditions.elementToBeClickable(skillsButton));
        skillsButton.click();
        String ActualCategoryText = String.format(categoryLocTemplate, categoryName);
        WebElement categoryElem = driver.findElement(By.xpath(ActualCategoryText));
        categoryElem.click();
        searchButton.click();

    }

    public String CheckIfJobsAreDisplayed() {

        for (WebElement elem : allJobs) {

            return elem.getText();
        }
        return null;
    }

    public void GoToAboutThenHistoryPage(String contentName, String subMenuName) {
        String actualHeaderContentText = String.format(headerContentOptionTemplate, contentName);
        WebElement headerContentElem = driver.findElement(By.xpath(actualHeaderContentText));
        Actions actions = new Actions(driver);
        actions.moveToElement(headerContentElem).build().perform();
        String actualSubMenuText = String.format(subMenuTextTemplate, subMenuName);
        WebElement subMenuElem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(actualSubMenuText)));
        subMenuElem.click();
    }

    public void waitForPageLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        wait.until(ExpectedConditions.elementToBeClickable(skillsButton));
    }
}
