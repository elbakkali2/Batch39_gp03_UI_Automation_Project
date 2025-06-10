package com.project_name.step_definitions;

import com.project_name.pages.LoginPage;
import com.project_name.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class US02_Login_oussama {

    LoginPage loginPage = new LoginPage();

//    @Given("the user is on the login page")
//    public void the_user_is_on_the_login_page() {
////        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//    }

    @When("the user enters valid {string} and {string}")
    public void the_user_enters_valid_and(String username, String password) {
        loginPage.login(username, password);
//        loginPage.submitButton.click();  // new method to wait and click submit

    }


    @Then("the user's account name should be displayed")
    public void the_user_s_account_name_should_be_displayed() {
        Assert.assertTrue("Account name is not displayed", loginPage.userMenu.isDisplayed());
    }

    @When("the user enters invalid {string} or {string}")
    public void the_user_enters_invalid_or(String username, String password) {
        loginPage.login(username, password);
//        loginPage.submitButton.click();  // new method to wait and click submit

    }

    @Then("the error message {string} should be displayed")
    public void the_error_message_should_be_displayed(String expectedMessage) {
        Assert.assertTrue(loginPage.wrongLoginPassword.isDisplayed());
        String actualMessage = loginPage.wrongLoginPassword.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("the user leaves either the {string} or {string} field blank")
    public void the_user_leaves_either_the_or_field_blank(String username, String password) {
        if (!username.isEmpty()) {
            loginPage.emailInput.sendKeys(username);
        }
        if (!password.isEmpty()) {
            loginPage.passwordInput.sendKeys(password);
        }

        // Try clicking submit and catching browser validation
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", loginPage.submitButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("the browser should display the message {string}")
    public void the_browser_should_display_the_message(String expectedMessage) {
        WebElement elementToCheck = loginPage.emailInput.getAttribute("value").isEmpty() ?
                loginPage.emailInput : loginPage.passwordInput;

        String actualMessage = elementToCheck.getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
