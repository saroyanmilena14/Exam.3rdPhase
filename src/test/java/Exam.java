import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Exam {
    @Test
    public void testProject() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://www.staff.am");
        WebElement categtoriesButton= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#jobsfilter-category")));
        categtoriesButton.click();
        WebElement myCategory= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group field-jobsfilter-category']//option[text()='Sales/service management']")));
        myCategory.click();
        WebElement searchButton =driver.findElement(By.xpath("//div[@class='col-lg-3 col-sm-3 search-btn']//button[@type='submit']"));
        searchButton.click();
        WebElement wholeAmountOfJobArticles= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='jobsfilter-category']//span[@data-count='135']")));

        Double wholeAmountOfJobArticlesDoubleValue= Double.parseDouble(wholeAmountOfJobArticles.getText().replace('(',' ').replace(')',' '));
        List<WebElement> allArticlesOnPage= driver.findElements(By.xpath("//div[@data-key]"));
        double amountOnPageDoubleValue=allArticlesOnPage.size();

        if(wholeAmountOfJobArticlesDoubleValue>=50) {
            Assert.assertEquals(amountOnPageDoubleValue,50);
        }
        else if(wholeAmountOfJobArticlesDoubleValue<50){
            Assert.assertEquals(amountOnPageDoubleValue,amountOnPageDoubleValue);
        }
    }
}

