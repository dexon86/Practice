import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class SeleniumTests {
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
    void firstUITest() {

       // WebDriver driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/", url);
    }

    @Test
    void secondUITest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        WebElement webForm = driver.findElement(By.xpath("//a[@href = 'web-form.html']"));
        webForm.click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
    }

    @Test
    void multiplelocators() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        WebElement webForm = driver.findElement(By.className("btn-outline-primary"));
        webForm.click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
    }

    @Test
    void multiplelocators2() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        List<WebElement> webForm = Collections.singletonList(driver.findElement(By.className("btn-outline-primary")));
        webForm.get(0).click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
    }
    @Test
    void multiplelocators3() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        List<WebElement> webForm = driver.findElements(By.tagName("A"));
        webForm.get(4).click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/navigation1.html", url);
    }

    @Test
    void multiplelocators4() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        WebElement webForm = driver.findElement(By.linkText("Web form"));
        webForm.click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
    }

    @Test
    void multiplelocators5() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        List<WebElement> webForm = driver.findElements(By.partialLinkText("form"));
        webForm.get(0).click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
    }

    @Test
    void csselocators1() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        List<WebElement> webForm = driver.findElements(By.cssSelector("btn-outline-primary"));
        webForm.get(0).click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
    }

    @Test
    void csselocators2() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        List<WebElement> webForm = driver.findElements(By.cssSelector("[href = 'web-form.html']"));
        webForm.get(0).click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
    }

    @Test
    void csselocators3() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        List<WebElement> webForm = driver.findElements(By.cssSelector("a[href = 'test-form.html']"));
        if (webForm.size() > 0) {
            webForm.get(0).click();
            String url = driver.getCurrentUrl();
            Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
        } else {
            System.out.println("There are no elements for locator");
        }
    }

        @Test
        void csslocators4() {
            driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

            WebElement button = driver.findElement(By.cssSelector(".btn.btn-outline-primary.mb-2"));
            button.click();

            String url = driver.getCurrentUrl();
            Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
        }
    @Test
    void csslocatiors5() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        WebElement link = driver.findElement(By.cssSelector("[href^='web']"));
        link.click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
    }

    @Test
    void csslocators6() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        WebElement link = driver.findElement(By.cssSelector("[href$='html']"));
        link.click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
    }

    @Test
    void csslocators7() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        WebElement link = driver.findElement(By.cssSelector("[href*='-form']"));
        link.click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
    }

    @Test
    void csslocators8() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        WebElement link = driver.findElement(By.cssSelector("a[href='web-form.html']"));
        link.click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", url);
    }

    @Test
    void cssChildSelector() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        WebElement checkbox = driver.findElement(By.cssSelector("input#my-check-2"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);


        System.out.println("Checkbox selected before click: " + checkbox.isSelected());

        checkbox.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, true));

        System.out.println("Checkbox selected after click: " + checkbox.isSelected());
        Assertions.assertTrue(checkbox.isSelected(), "The checkbox should be selected.");
    }
    @Test
    void cssNthChildSelector() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");


        WebElement checkbox = driver.findElement(By.cssSelector("div.form-check label:nth-child(2) input"));


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);


        System.out.println("Checkbox selected before click: " + checkbox.isSelected());


        checkbox.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, true));


        System.out.println("Checkbox selected after click: " + checkbox.isSelected());
        Assertions.assertTrue(checkbox.isSelected(), "The checkbox should be selected.");
    }
    @Test
    void xpathTagSelector() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");


        WebElement checkbox = driver.findElement(By.xpath("//input[@id='my-check-2']"));


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);


        System.out.println("Checkbox selected before click: " + checkbox.isSelected());


        checkbox.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, true));


        System.out.println("Checkbox selected after click: " + checkbox.isSelected());
        Assertions.assertTrue(checkbox.isSelected(), "The checkbox should be selected.");
    }
    @Test
    void xpathExactTextSelector() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");


        WebElement heading = driver.findElement(By.xpath("//h1[text()='Hands-On Selenium WebDriver with Java']"));


        Assertions.assertTrue(heading.isDisplayed(), "The heading should be displayed.");


        System.out.println("Heading text: " + heading.getText());
    }
    @Test
    void xpathPartialTextSelector() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");


        WebElement heading = driver.findElement(By.xpath("//h1[contains(text(), 'Hands-On Selenium WebDriver')]"));


        Assertions.assertTrue(heading.isDisplayed(), "The heading should be displayed.");


        System.out.println("Heading text: " + heading.getText());
    }
    @Test
    void xpathByAttributeSelector() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");


        WebElement element = driver.findElement(By.xpath("//*[@myprop='myvalue']"));


        Assertions.assertTrue(element.isDisplayed(), "The element with attribute 'myprop=myvalue' should be displayed.");


        System.out.println("Tag Name: " + element.getTagName());
        System.out.println("Attribute Value: " + element.getAttribute("myprop"));
    }
    @Test
    void xpathByChildSelector() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");


        WebElement checkbox = driver.findElement(By.xpath("//label/input[@id='my-check-1']"));


        Assertions.assertTrue(checkbox.isDisplayed(), "The checkbox should be displayed.");


        System.out.println("Checkbox selected before click: " + checkbox.isSelected());


        if (!checkbox.isSelected()) {
            checkbox.click();


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeSelected(checkbox));
        }


        System.out.println("Checkbox selected after click: " + checkbox.isSelected());


        Assertions.assertTrue(checkbox.isSelected(), "The checkbox should be selected.");
    }
    @Test
    void xpathGoToParentSelector() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");


        WebElement parentElement = driver.findElement(By.xpath("//input[@id='my-text-id']/.."));


        Assertions.assertTrue(parentElement.isDisplayed(), "The parent element should be displayed.");


        System.out.println("Tag name of the parent element: " + parentElement.getTagName());


        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red';", parentElement);
    }







}


