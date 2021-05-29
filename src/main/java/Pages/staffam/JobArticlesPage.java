package Pages.staffam;

import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JobArticlesPage {
    private WebDriver driver;
    WebDriverWait wait ;
    private By featuredJobsButtonLoc = By.xpath("//div[@class='row featured-jobs-row']//label[@class='featured-jobs-lbl']//span");
    private By allArticlesOnPageLoc = By.xpath("//div[@data-key]");
    private By checkBoxLoc = By.xpath("//input[@checked='checked']");
    private By countOfJobArticlesLoc=By.xpath("//input[@checked='checked']/following-sibling::span[@data-count]");

    public JobArticlesPage(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(featuredJobsButtonLoc));
    }

    public int findCountOfAllJobArticlesOnPage() {
        List<WebElement> allArticlesOnPage = driver.findElements(allArticlesOnPageLoc);
        return allArticlesOnPage.size();
    }

    public String checkTheCheckBox() {

        WebElement checked=driver.findElement(checkBoxLoc);
       try {
         return  checked.getAttribute("checked");
       }
       catch(NoSuchElementException e){
           return null;
       }
    }

    public int getCountFromFilterbar() {
        String countFromFilterBarText=driver.findElement(countOfJobArticlesLoc).getText().replace("(", "").replace(")", "");

        int countFromFilterBar=Integer.parseInt(countFromFilterBarText);

        return countFromFilterBar;
    }
    public void QuitingChrome() {
        driver.quit();
    }
}