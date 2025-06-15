package com.project_name.step_definitions;

import com.project_name.pages.LoginPage;
import com.project_name.pages.US10_NigarPage;
import com.project_name.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class US10_AccessTheDoc_Nigar_StepDefinition {

    LoginPage loginPage = new LoginPage();
    US10_NigarPage nigarPage = new US10_NigarPage();

    @Given("user logged on as CRM_Manager with {string} and {string}")
    public void user_logged_on_as_crm_manager(String username, String password) {
        loginPage.login(username, password);
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String link) {
        nigarPage.documentationLink.click();

        // Switch to new tab
        for (String win : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(win);
        }
    }

    @Then("a new window should open with the title {string}")
    public void a_new_window_should_open_with_the_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

    @Then("I should see {int} main documentation topics:")
    public void i_should_see_main_documentation_topics(int expectedCount, DataTable dataTable) {
        List<String> expected = dataTable.asList();
        List<String> actual = nigarPage.documentationTopics.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Assert.assertEquals(expectedCount, actual.size());
        Assert.assertTrue(actual.containsAll(expected));
    }
}








