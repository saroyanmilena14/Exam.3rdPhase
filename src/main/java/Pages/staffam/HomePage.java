package Pages.staffam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {


    private  WebDriverWait wait;
    private WebDriver driver;
    private By searchButtonLoc = By.xpath("//div[@class='col-lg-3 col-sm-3 search-btn']//button[@type='submit']");
    private By categtoriesButtonLoc = By.cssSelector("#jobsfilter-category");
    String myCategorytext = "Sales/service management";
    private By myCategoryLoc = By.xpath("//div[@class='form-group field-jobsfilter-category']//option[text()='"+myCategorytext+"']");
    public HomePage( WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, 20);
    }


    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public By getSearchButtonLoc() {
        return searchButtonLoc;
    }

    public void setSearchButtonLoc(By searchButtonLoc) {
        this.searchButtonLoc = searchButtonLoc;
    }

    public By getCategtoriesButtonLoc() {
        return categtoriesButtonLoc;
    }

    public void setCategtoriesButtonLoc(By categtoriesButtonLoc) {
        this.categtoriesButtonLoc = categtoriesButtonLoc;
    }

    public By getMyCategoryLoc() {
        return myCategoryLoc;
    }

    public void setMyCategoryLoc(By myCategoryLoc) {
        this.myCategoryLoc = myCategoryLoc;
    }





    public void waitForPageLoad() {

        wait.until(ExpectedConditions.elementToBeClickable(searchButtonLoc));
    }

    public void selectingCategory(String myCategorytextt) {

        WebElement categtoriesButton = driver.findElement(categtoriesButtonLoc);
        categtoriesButton.click();
        WebElement myCategory = wait.until(ExpectedConditions.elementToBeClickable(myCategoryLoc));
        myCategory.click();
        WebElement searchButton= driver.findElement(searchButtonLoc);
        searchButton.click();
    }


}

