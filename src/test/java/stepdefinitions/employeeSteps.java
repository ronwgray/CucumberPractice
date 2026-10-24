package stepdefinitions;

import utils.Employee;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class employeeSteps {
    ArrayList<Employee> employees = new ArrayList<>();

    @When("I read employee data from CSV file {string}")
    public void iReadCSVFile(String fileName) {
        employees = Employee.getEmployeesFromCSVFile(fileName);
        assertThat(employees.size()).isGreaterThan(0);
    }

    @When("I read employee data from fixed-length file {string}")
    public void iReadFixedFile(String fileName) {
        employees = Employee.getEmployeesFromFixedFile(fileName);
        assertThat(employees.size()).isGreaterThan(0);
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
