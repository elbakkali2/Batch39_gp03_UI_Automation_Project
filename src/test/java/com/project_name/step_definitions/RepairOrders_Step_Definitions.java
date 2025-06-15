package com.project_name.step_definitions;

import com.project_name.pages.RepairOrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RepairOrders_Step_Definitions {


    RepairOrderPage repairOrderPage=new RepairOrderPage();

    @When("user logged on as POS & Sales Manager")
    public void user_logged_on_as_pos_sales_manager() {
     repairOrderPage.emailBox.sendKeys("posmanager6@info.com");

    }
    @Then("user can successfully log in the page and sees the user role on the top right")
    public void user_can_successfully_log_in_the_page_and_sees_the_user_role_on_the_top_right() {

        repairOrderPage.passwordBox.sendKeys("posmanager");

        repairOrderPage.loginButton.click();

    }



    @When("the user clicks the top checkbox to select all repair orders")
    public void the_user_clicks_the_top_checkbox_to_select_all_repair__orders() {

      repairOrderPage.repairBox.click();

    }
    @Then("all repair orders should be selected")
    public void all_repair_orders_should_be_selected() {

        repairOrderPage.repairReferenceBox.click();


    }

    @Then("the {string} dropdown should be visible")
    public void the_dropdown_should_be_visible(String string) {

    }
    @When("the user clicks the {string} dropdown")
    public void the_user_clicks_the_dropdown(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the Action dropdown should contain the following options:")
    public void the_action_dropdown_should_contain_the_following_options(io.cucumber.datatable.DataTable dataTable) {

    }

}
