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
    String myCategorytext = "Sales/service management";
    private By allArticlesOnPageLoc = By.xpath("//div[@data-key]");
    private By checkBoxLoc = By.xpath("//en[text()='"+myCategorytext+"']/preceding::input[@checked='checked']");
    private By countOfJobArticlesLoc=By.xpath("//input[@checked='checked']/following-sibling::span[@data-count]");

    public JobArticlesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver,20);
    }



    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    private WebDriverWait wait ;
    private By featuredJobsButtonLoc = By.xpath("//div[@class='row featured-jobs-row']//label[@class='featured-jobs-lbl']//span");

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public By getFeaturedJobsButtonLoc() {
        return featuredJobsButtonLoc;
    }

    public void setFeaturedJobsButtonLoc(By featuredJobsButtonLoc) {
        this.featuredJobsButtonLoc = featuredJobsButtonLoc;
    }

    public By getAllArticlesOnPageLoc() {
        return allArticlesOnPageLoc;
    }

    public void setAllArticlesOnPageLoc(By allArticlesOnPageLoc) {
        this.allArticlesOnPageLoc = allArticlesOnPageLoc;
    }

    public By getCheckBoxLoc() {
        return checkBoxLoc;
    }

    public void setCheckBoxLoc(By checkBoxLoc) {
        this.checkBoxLoc = checkBoxLoc;
    }

    public By getCountOfJobArticlesLoc() {
        return countOfJobArticlesLoc;
    }

    public void setCountOfJobArticlesLoc(By countOfJobArticlesLoc) {
        this.countOfJobArticlesLoc = countOfJobArticlesLoc;
    }


    public void waitForPageLoad() {

        wait.until(ExpectedConditions.elementToBeClickable(featuredJobsButtonLoc));
    }

    public int findCountOfAllJobArticlesOnPage() {
        List<WebElement> allArticlesOnPage = driver.findElements(allArticlesOnPageLoc);
        return allArticlesOnPage.size();
    }

    public String checkTheCheckBox(String myCategorytext) {

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

}