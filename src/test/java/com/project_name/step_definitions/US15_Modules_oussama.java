package com.project_name.step_definitions;

import com.project_name.pages.DashboardPage;
import com.project_name.pages.LoginPage;
import com.project_name.utilities.ConfigurationReader;
import com.project_name.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US15_Modules_oussama {

    LoginPage loginPage = new LoginPage();

    @Given("the user is logged in as an Event Manager")
    public void the_user_is_logged_in_as_an_event_manager() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        loginPage.login(ConfigurationReader.getProperty("userName"),
                      ConfigurationReader.getProperty("password"));

    }


    @When("the Event Manager navigates to the main dashboard")
    public void the_event_manager_navigates_to_the_main_dashboard() {
        String actual = Driver.getDriver().getTitle();
        String expected = "Odoo";
        Assert.assertTrue(actual.contains(expected));
    }


    @Then("the system should display access to the following 15 modules:")
    public void verifyEventManagerModulesAccess(List<String> expectedModules) {

        DashboardPage dashboardPage = new DashboardPage();


        List<String> actualModules = dashboardPage.getDisplayedModules();

        System.out.println("Expected modules: " + expectedModules);
        System.out.println("Actual modules: " + actualModules);

        assertEquals("Module count mismatch", expectedModules.size(), actualModules.size());

        // in this line i find problem with the size of the screen
        // i can't see | Dashboards      | but if i move the browser to big screen it's pass

        for (String module : expectedModules) {
            assertTrue("Missing module: " + module, actualModules.contains(module));
        }
    }



}
