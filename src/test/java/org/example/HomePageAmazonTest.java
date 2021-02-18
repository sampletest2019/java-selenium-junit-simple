package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ScreenshotUtils;

import java.util.concurrent.TimeUnit;

@Tag("SmokeTest")
public class HomePageAmazonTest {
    private WebDriver driver;
    String baseUrl = "https://www.amazon.com";
    String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Open Amazon Home page and check the title")
    public void openHomePageAndCheckTheTitle() {
        driver.get(baseUrl);
        Assertions.assertEquals(expectedTitle, driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        ScreenshotUtils.screenshot(driver);
        driver.quit();
    }
}
