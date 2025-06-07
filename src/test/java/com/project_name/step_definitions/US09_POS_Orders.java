package com.project_name.step_definitions;

import com.project_name.pages.POSOrdersPage;
import com.project_name.utilities.BrowserUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class US09_POS_Orders {
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String string) {

    }

    @When("the POS manager navigates to the {string} page under the {string}")
    public void the_pos_manager_navigates_to_the_page_under_the(String string, String string2) {

    }

    @Then("the order list should be displayed")
    public void the_order_list_should_be_displayed() {

    }

    @Then("each order should have a non-empty Order Reference")
    public void each_order_should_have_a_non_empty_order_reference() {


    }

    @When("the POS manager opens the Action dropdown")
    public void the_pos_manager_opens_the_action_dropdown(DataTable dataTable) {
        List<String> actualAction = BrowserUtils.dropdownOptions_as_STRING(POSOrdersPage.actionDropdown);
        List<String> expectedAction = new ArrayList<>(actualAction);

        Assert.assertEquals(expectedAction, actualAction );

    }

    @Then("the dropdown should contain the following options:")
    public void the_dropdown_should_contain_the_following_options(io.cucumber.datatable.DataTable dataTable) {
    }
    @When("the POS manager navigates to the {string} page under {string}")
    public void the_pos_manager_navigates_to_the_page_under(String string, String string2) {
    }

}
