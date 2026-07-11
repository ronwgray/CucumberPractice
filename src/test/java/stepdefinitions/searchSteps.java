package stepdefinitions;

import pages.HomePage;
import pages.SearchFunctions;
import utils.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Comparator;

public class myStepDefs {
    ArrayList<Employee> employees = new ArrayList<>();

    @Given("user is on the home page")
    public void userIsOnTheHomePage() {
        new HomePage().openHomePage();
    }

    @When("I search for product {string}")
    public void iSearchForProduct(String searchText) {
        new SearchFunctions().searchForItem(searchText);
    }

    @Then("I verify that {string} card is displayed")
    public void iVerifyThatCardIsDisplayed(String cardTitle) {
        new SearchFunctions().verifyCardTitleDisplayed(cardTitle);
    }

    @When("I read employee data from CSV file {string}")
    public void iReadCSVFile(String fileName) {
        employees = Employee.getEmployeesFromCSVFile(fileName);
        Assert.assertTrue(employees.size() > 0, "Expected > 0 employee records; " + employees.size() + " found.");
    }

    @When("I read employee data from fixed-length file {string}")
    public void iReadFixedFile(String fileName) {
        employees = Employee.getEmployeesFromFixedFile(fileName);
        Assert.assertTrue(employees.size() > 0, "Expected > 0 employee records; " + employees.size() + " found.");
    }

    @Then("I display Employee records alphabetically by first name")
    public void iDisplayEmployeeRecords() {
        // take the global employee list and write it out
        // sort the list by name before returning it
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("--------------------------------------------------");
        for (Employee emp : employees) {
            System.out.println(emp.getName() + ", " + emp.getEmail() + ", " + emp.getAge());
        }
        System.out.println("--------------------------------------------------");
    }
}
