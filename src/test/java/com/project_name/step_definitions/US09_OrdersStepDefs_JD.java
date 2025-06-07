package com.project_name.step_definitions;

import com.project_name.pages.LoginPage;
import com.project_name.pages.US09_POSOrdersPage_JD;
import com.project_name.utilities.BrowserUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class US09_OrdersStepDefs_JD {

    LoginPage loginPage = new LoginPage();
    US09_POSOrdersPage_JD POSOrdersPage = new US09_POSOrdersPage_JD();

    // Scenario 1
    @Given("the POS manager logs into the system with valid credentials")
    public void the_pos_manager_logs_into_the_system_with_valid_credentials() {
        loginPage.loginAs("POS manager");
    }

    @When("the POS manager navigates to the {string} page")
    public void the_pos_manager_navigates_to_the_page(String page) {
        BrowserUtils.waitForVisibility(POSOrdersPage.pointOfSale,5).click();

    }

    @When("the POS manager clicks the {string} menu under Dashboard")
    public void the_pos_manager_clicks_the_menu_under_dashboard(String menu) {
        BrowserUtils.waitForVisibility(POSOrdersPage.ordersMenu, 5).click();

    }

    @Then("all the orders list should be displayed")
    public void all_the_orders_list_should_be_displayed() {
        Assert.assertTrue("Order list is not displayed", POSOrdersPage.isOrdersListDisplayed());
        Assert.assertFalse("Order Reference list is empty", POSOrdersPage.getAllOrderReferences().isEmpty());
    }

    @Then("each order should have a non-empty Order Reference")
    public void each_order_should_have_a_non_empty_order_reference() {
        List<String> refs = POSOrdersPage.getAllOrderReferences();
        for (String ref : refs) {
            Assert.assertFalse("Empty order reference found", ref.trim().isEmpty());
        }
    }

    @When("the POS manager checks the {string} checkbox")
    public void the_pos_manager_checks_the_checkbox(String label) {
        BrowserUtils.waitForClickablility(POSOrdersPage.orderRefCheckbox, 10);
        if (!POSOrdersPage.orderRefCheckbox.isSelected()) {
            POSOrdersPage.orderRefCheckbox.click();
        }
    }

    @Then("all the orders list should be checked")
    public void all_the_orders_list_should_be_checked() {
        BrowserUtils.scrollToElement(POSOrdersPage.orderRefCheckbox);
        BrowserUtils.waitForVisibility(POSOrdersPage.orderRefCheckbox, 10);
        try {
            for (WebElement checkbox : POSOrdersPage.orderCheckboxes) {
                BrowserUtils.scrollToElement(checkbox);
                BrowserUtils.waitForVisibility(checkbox, 5);

                Assert.assertTrue("Order reference element is not displayed", checkbox.isDisplayed());
                Assert.assertTrue("Checkbox is not selected", checkbox.isSelected());
            }
        } catch (Exception e) {

            throw new AssertionError("Checkbox verification failed: " + e.getMessage());
        }
    }

    // Scenario 2
    @And("the POS manager clicks to the {string} menu under Dashboard")
    public void thePOSManagerClicksToTheMenuUnderDashboard(String menu) {
        BrowserUtils.waitForVisibility(POSOrdersPage.ordersMenu, 5);
        BrowserUtils.scrollToElement(POSOrdersPage.ordersMenu);
        BrowserUtils.waitForClickablility(POSOrdersPage.ordersMenu, 5).click();
    }

    @When("the POS manager clicks the {string} dropdown")
    public void the_pos_manager_clicks_the_dropdown(String dropdownName) {
        BrowserUtils.waitForVisibility(POSOrdersPage.actionDropdownButton, 10).click();
    }

    @Then("the dropdown should contain the following options:")
    public void the_dropdown_should_contain_the_following_options(DataTable dataTable) {
        BrowserUtils.waitForVisibility(POSOrdersPage.actionDropdownButton, 10).click();

        try {
            POSOrdersPage.actionDropdownButton.click();
            List<String> expectedOptions = dataTable.asList();
            List<String> actualOptions = BrowserUtils.getElementsText(POSOrdersPage.actionDropdownOptions);

            for (String option : expectedOptions) {
                Assert.assertTrue("Missing option: " + option, actualOptions.contains(option));
            }

        } catch (Exception e) {

            throw new AssertionError("Dropdown verification failed: " + e.getMessage());
        }
    }
}
