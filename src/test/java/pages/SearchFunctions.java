package pages;

import utils.TestDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchFunctions {

    WebDriver driver;

    // FindBy id will not work when the id contains a dash, must use CSS or xpath
//    @FindBy(id = "search-query")
//    @FindBy(xpath = "//input[@id='search-query']")
//    private WebElement searchQuery;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement searchButton;

    public SearchFunctions() {
        this.driver = TestDriver.getDriver();
        // This line is mandatory to activate @FindBy
        PageFactory.initElements(driver, this);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void searchForItem(String searchText) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        try {
            WebElement searchQuery = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='search-query']")));
            if (searchQuery.isDisplayed()) {
                searchQuery.clear();
                searchQuery.sendKeys(searchText);
                clickSearchButton();
                System.out.println("Searched for: " + searchText);
            } else {
                System.out.println("Failed to display search query");
            }
        } catch (Exception e) {
            System.out.println("Failed to locate search query");
        }
    }

    public void verifyCardTitleDisplayed(String cardTitle) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        try {
            String xpath = "//h5[@class='card-title' and contains(text(),'" + cardTitle + "')]";
            WebElement cardTitleElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Assert.assertTrue(cardTitleElement.isDisplayed(), "Failed to display expected card title");
            System.out.println("Product '" + cardTitle + "' was displayed");
        } catch (Exception e) {
            Assert.fail("Failed to locate expected card title");
        }
    }
}
