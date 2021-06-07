package EpamPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HistoryOfEpamPage extends BasePage {

    @FindBy(xpath = "//div[@class='text']//span[text()='EPAM Today*']")
    private WebElement pageLoadedElem;

    @FindAll(@FindBy(xpath = "//span[text()='EPAM Today*']//following::div[@class='column-control']//div[@class='text']"))
    List<WebElement> allTextAfterEpamToday;


    public HistoryOfEpamPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoad() {
        wait.until(ExpectedConditions.visibilityOf(pageLoadedElem));
    }

    public String CheckIfAllElemsAreDisplayed() {
        String text="";
        for (int i = 0; i < 4; i++) {
              text = allTextAfterEpamToday.get(i).getText();
          }

          return text;
    }
}