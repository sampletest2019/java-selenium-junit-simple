package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchAmazonTest {
    private WebDriver driver;
    String baseUrl = "https://www.amazon.com";
    String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    String searchExpectedTitle = "Amazon.com : nike airmax";

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openHomePageAndCheckTheTitle() {
        driver.get(baseUrl);
        Assert.assertEquals(expectedTitle, driver.getTitle());
        WebElement searchInputField = driver.findElement(By.id("twotabsearchtextbox"));
        searchInputField.sendKeys("nike airmax");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        Assert.assertEquals(searchExpectedTitle, driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
