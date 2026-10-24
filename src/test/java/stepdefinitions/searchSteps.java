package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import pages.SearchFunctions;
import utils.Product;

import java.util.List;
import java.util.Map;

public class searchSteps {

    @When("I search for product {string}")
    public void iSearchForProduct(String searchText) {
        new SearchFunctions().searchForItem(searchText);
    }

    @Then("I verify that product {string} is displayed")
    public void iVerifyThatProductIsDisplayed(String productName) {
        new SearchFunctions().verifyCardTitleDisplayed(productName);
    }

    @Then("I verify that the following products are displayed:")
    public void iVerifyThatTheFollowingProductsAreDisplayed(DataTable dataTable) {
        // dataTable will map elements as String
        List<Map<String, String>> tableRows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> tableRow: tableRows) {
            String productName = "";
            double productPrice = 0.0;
            for (Map.Entry<String, String> product : tableRow.entrySet()) {
                if (product.getKey().equals("Product")) {
                    productName = product.getValue();
                } else if (product.getKey().equals("Price")) {
                    productPrice = Double.parseDouble(product.getValue());
                }
            }
            System.out.println("Product '" + productName + "' is $" + productPrice);
            new SearchFunctions().verifyCardTitleDisplayed(productName);
        }
    }

    // POJO (plain old java object) method...
    // Create a Product object
    // Then create a DataTableType in the step specification which gets the data from the Map
    @DataTableType
    public Product productEntry(Map<String, String> entry) {
        // entry.get will get the specified column header - so the column header text has to match!
        return new Product(
                entry.get("Product"),
                Double.parseDouble(entry.get("Price"))
        );
    }
    // Then create a step which gets a List of Product instead of the DataTable
    @Then("I verify that the following products are displayed POJO:")
    public void iVerifyThatTheFollowingProductsAreDisplayedPOJO(List<Product> products) {
        for (Product product : products) {
            System.out.println("Product '" + product.getName() + "' is $" + product.getPrice());
            new SearchFunctions().verifyCardTitleDisplayed(product.getName());
        }
    }
}
