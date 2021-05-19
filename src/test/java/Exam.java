import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exam {
    @Test
    public void testProject() {
        System.setProperty("webdriver.chrome.driver", "src\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
