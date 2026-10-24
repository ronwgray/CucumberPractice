package hooks;

import io.cucumber.java.*;
import utils.TestDriver;

public class CommonHooks {

    @BeforeAll
    public static void BeforeSuite() {
        System.out.println("BeforeSuite");
    }

    @Before
    public void BeforeTestCase(Scenario scenario) {
        System.out.println("BeforeTestCase: " + scenario.getName());
    }

    // both After(Search) and After will be run for some tests

    @After("@Search")
    public void AfterTestCaseSearch(Scenario scenario) {
        System.out.println("AfterTestCaseSearch: " + scenario.getName() + " " + scenario.getSourceTagNames());
        TestDriver.quitDriver();
    }

    @After()
    public void AfterTestCase(Scenario scenario) {
        System.out.println("AfterTestCase: " + scenario.getName() + " " + scenario.getSourceTagNames());
    }

    @AfterAll
    public static void AfterSuite() {
        System.out.println("AfterSuite");
    }

}
