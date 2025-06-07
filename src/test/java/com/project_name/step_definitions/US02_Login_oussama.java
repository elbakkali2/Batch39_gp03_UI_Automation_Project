package com.project_name.step_definitions;


import com.project_name.pages.LoginPage;

import com.project_name.utilities.ConfigurationReader;
import com.project_name.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;




public class US02_Login_oussama {

    // Scenario 1:
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    LoginPage loginPage = new LoginPage();
    @When("the user enters valid {string} and {string}")
    public void the_user_enters_valid_and(String userName, String password) {
       loginPage.login(userName,password);
    }
    @When("submits the form by clicking Login or pressing Enter")
    public void submits_the_form_by_clicking_or_pressing() {
        loginPage.submitButton.click();
//        loginPage.submitButton.sendKeys(Keys.ENTER);

    }

    @Then("the user's account name should be displayed")
    public void the_user_s_account_name_should_be_displayed() {
        loginPage.userMenu.isDisplayed();
    }

    // Scenario 2:

    @When("the user logs out and returns to the login page")
    public void the_user_logs_out_and_returns_to_the_login_page() {
        loginPage.userMenu.click();
        loginPage.logout.click();
    }
    @When("the user enters invalid {string} or {string}")
    public void the_user_enters_invalid_or(String userName, String password) {
        loginPage.login(userName,password);
        loginPage.submitButton.click();
    }


    @Then("the error message {string} should be displayed")
    public void the_error_message_should_be_displayed(String expected) {
        String actual = loginPage.WrongLoginPassword.getText();
        Assert.assertTrue(actual.equals(expected));



    }

    // Scenario 3:


    @When("the user leaves either the {string} or {string} field blank")
    public void the_user_leaves_either_the_or_field_blank(String userName, String password) {
        loginPage.login(userName,password);
        loginPage.submitButton.click();
    }

    @Then("the browser should display the message {string}")
    public void the_browser_should_display_the_message(String expected) {


    }

}
