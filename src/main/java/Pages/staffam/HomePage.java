package Pages.staffam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private By searchButtonLoc = By.xpath("//div[@class='col-lg-3 col-sm-3 search-btn']//button[@type='submit']");
    private By categtoriesButtonLoc = By.cssSelector("#jobsfilter-category");
     String myCategorytext = "Sales/service management";
    private By myCategoryLoc = By.xpath("//div[@class='form-group field-jobsfilter-category']//option[text()='"+myCategorytext+"']");

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }




    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonLoc));
    }

    public void selectingCategory() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement categtoriesButton = driver.findElement(categtoriesButtonLoc);
        categtoriesButton.click();
        WebElement myCategory = wait.until(ExpectedConditions.elementToBeClickable(myCategoryLoc));
        myCategory.click();
        WebElement searchButton= driver.findElement(searchButtonLoc);
        searchButton.click();
    }


}

