package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@Tag("RegressionTest")
public class SearchAmazonTest {
    private WebDriver driver;
    String baseUrl = "https://www.amazon.com";
    String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    String searchExpectedTitle = "Amazon.com : nike airmax";

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Open Amazon Home page, search for an item and check the title")
    public void openHomePageAndCheckTheTitle() {
        driver.get(baseUrl);
        Assertions.assertEquals(expectedTitle, driver.getTitle());
        WebElement searchInputField = driver.findElement(By.id("twotabsearchtextbox"));
        searchInputField.sendKeys("nike airmax");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        Assertions.assertEquals(searchExpectedTitle, driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
