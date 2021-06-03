package Pages.staffam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private  WebDriverWait wait;
    private By searchButtonLoc = By.xpath("//div[@class='col-lg-3 col-sm-3 search-btn']//button[@type='submit']");
    private By categtoriesButtonLoc = By.cssSelector("#jobsfilter-category");
    private String myCategoryLocTemplate = "//div[@class='form-group field-jobsfilter-category']//option[text()='%s']";


    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,20);
    }
    public HomePage open() {

        driver.get(BASE_URL);
        return this;
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

    public String getMyCategoryLocTemplate() {
        return myCategoryLocTemplate;
    }

    public void waitForPageLoad() {

        wait.until(ExpectedConditions.elementToBeClickable(searchButtonLoc));
    }


    public void selectingCategory(String myCategorytextt) {

        WebElement categtoriesButton = driver.findElement(categtoriesButtonLoc);
        categtoriesButton.click();
        String myActualCategoryText=String.format(myCategoryLocTemplate,myCategorytextt);
        WebElement myCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(myActualCategoryText)));
        myCategory.click();
        WebElement searchButton= driver.findElement(searchButtonLoc);
        searchButton.click();
    }

}

