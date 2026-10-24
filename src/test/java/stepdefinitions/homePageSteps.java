package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.HomePage;

public class homePageSteps {
    @Given("user is on the home page")
    public void userIsOnTheHomePage() {
        new HomePage().openHomePage();
    }

}
