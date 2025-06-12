package com.project_name.step_definitions;

import com.project_name.pages.LoginPage;
import com.project_name.pages.US11_Sales_Quot_MP_Page;
import com.project_name.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US11_Sales_Quotations_MP_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    US11_Sales_Quot_MP_Page sales_Quot_MP_Page = new US11_Sales_Quot_MP_Page();

    @Given("{string} user is logged in to the system")
    public void user_is_logged_in_to_the_system(String role) {


        switch (role) {
            case "POS":
                loginPage.loginAs("POS Manager");
                break;
            case "Sales Manager":
                loginPage.loginAs("Sales Manager");
        }

    }
    @Given("user navigates to the Sales page")
    public void user_navigates_to_the_sales_page() {

        BrowserUtils.waitForClickablility(sales_Quot_MP_Page.salesButton, 10);
        sales_Quot_MP_Page.salesButton.click();
        BrowserUtils.sleep(2);

    }
    @When("user clicks the Quotation Number checkbox")
    public void user_clicks_the_quotation_number_checkbox() {

        BrowserUtils.waitForVisibility(sales_Quot_MP_Page.quotationNumberCheckbox, 10);
        sales_Quot_MP_Page.quotationNumberCheckbox.click();
        BrowserUtils.sleep(2);



    }
    @Then("all quotations in the list should be selected")
    public void all_quotations_in_the_list_should_be_selected() {

        for (WebElement checkbox : sales_Quot_MP_Page.rowCheckboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }



    }


    @Then("the Print dropdown should be visible")
    public void thePrintDropdownShouldBeVisible() {


        BrowserUtils.waitForVisibility(sales_Quot_MP_Page.printButton, 10);
        Assert.assertTrue(sales_Quot_MP_Page.printButton.isDisplayed());
        sales_Quot_MP_Page.printButton.click();
        BrowserUtils.sleep(2);

    }

    @And("the option Quotation \\/ Order  should appear under the Print dropdown")
    public void theOptionQuotationOrderShouldAppearUnderThePrintDropdown() {

        BrowserUtils.waitForVisibility(sales_Quot_MP_Page.quotationOrderOption, 10);
        Assert.assertTrue(sales_Quot_MP_Page.quotationOrderOption.isDisplayed());
        BrowserUtils.sleep(2);

    }
}
