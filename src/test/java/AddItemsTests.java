import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AddItemsTests {
    private final String BASE_URL = " https://www.ae.com/us/en";
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void openHomepageTest() {
        driver.get(BASE_URL);

        String currentUrl = driver.getCurrentUrl();

    }

    @Test
    void addItemTest() throws InterruptedException {
        // Maximize the browser window so that all elements are visible
        driver.manage().window().maximize();

        driver.get(BASE_URL);
        Thread.sleep(5000);

        List<WebElement> popupClose = driver.findElements(By.id("onetrust-accept-btn-handler"));
        if (!popupClose.isEmpty()) {
            popupClose.get(0).click();
        }

        WebElement womenCategory = driver.findElement(By.cssSelector("a[data-text='Women']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenCategory).perform();
        Thread.sleep(2000);

        WebElement shoesSubCategory = driver.findElement(By.xpath("//a[@data-text='Women']/..//a[@data-item-link and text()='Shoes']"));
        Thread.sleep(5000);
        shoesSubCategory.click();
        Thread.sleep(5000);
    }
    @Test
    void addManJeans() throws InterruptedException {
        // Maximize the browser window so that all elements are visible
        driver.manage().window().maximize();

        driver.get(BASE_URL);
        Thread.sleep(5000);

        // Close the popup if present
        List<WebElement> popupClose = driver.findElements(By.id("onetrust-accept-btn-handler"));
        if (!popupClose.isEmpty()) {
            popupClose.get(0).click();
        }

        // Locate the Men's category link
        WebElement mensCategory = driver.findElement(By.cssSelector("a[data-text='Men']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mensCategory).perform();
        Thread.sleep(2000);

        // Locate the Jeans subcategory under the Men's category
        WebElement jeansSubCategory = driver.findElement(By.xpath("//a[@data-text='Men']/..//a[@data-item-link and text()='Jeans']"));
        Thread.sleep(5000);
        jeansSubCategory.click();
        Thread.sleep(5000);
    }



}
