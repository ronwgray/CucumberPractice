package PracticeSoftware.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PracticeSoftware.pages.utils.TestDriver;

public class HomePage {

    WebDriver driver;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = "//a[@class='footer-links__link' and contains(text(),'Careers')]")
    private WebElement careersLink;

    public HomePage() {
        this.driver = TestDriver.getDriver();
        // This line is mandatory to activate @FindBy
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        this.driver.get("https://practicesoftwaretesting.com/");
    }
}
