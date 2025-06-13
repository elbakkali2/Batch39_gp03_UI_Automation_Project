package com.project_name.step_definitions;

import com.project_name.pages.Login_AC_Page;
import com.project_name.utilities.BrowserUtils;
import com.project_name.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class US01_Login_AC {

    Login_AC_Page loginPage = new Login_AC_Page();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    //using the login button
    @When("User enters valid POS credentials {string} and {string}")
    public void user_enters_valid_pos_username_and_password(String username, String password) {
        loginPage.userName.sendKeys(username);
        loginPage.password.sendKeys(password);
    }  //using the login button

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.loginButton.click();
    }


    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {

    String ExpectedSuccessfulLogin ="Discuss";
    wait.until(ExpectedConditions.visibilityOf(loginPage.successfulLogin));
    String ActualSuccessfulLogin = loginPage.successfulLogin.getText();
    Assert.assertEquals(ExpectedSuccessfulLogin, ActualSuccessfulLogin);



    }

    @When("User enters valid Event-CRM username and password")
    public void userEntersValidEventCRMUsernameAndPassword(String username, String password) {
        loginPage.userName.sendKeys("eventscrmmanager100@info.com");
        loginPage.password.sendKeys("eventscrmmanager");
    }

    @And("User presses the Enter key")
    public void userPressesTheEnterKey() {
        loginPage.loginButton.sendKeys(Keys.ENTER);
    }

    @When("User enters invalid username or password")
    public void userEntersInvalidUsernameOrPassword() {
        loginPage.userName.sendKeys("Invalidemail@info.com");
        loginPage.password.sendKeys("posmanager");
        loginPage.loginButton.click();
    }

    @Then("Wrong login or password error message should be displayed")
    public void wrongLoginOrPasswordErrorMessageShouldBeDisplayed() {
       String ExpectedErrorMessage = "Wrong login/password";
        String ActualErrorMessage = loginPage.wrong_login_password.getText();
        Assert.assertEquals(ExpectedErrorMessage, ActualErrorMessage);


    }


    @When("User leaves at least one field blank")
    public void userLeavesAtLeastOneFieldBlank() {
        loginPage.userName.sendKeys("eventscrmmanager22@info.com");
        loginPage.password.sendKeys("");

    }

    @Then("Please fill out this field validation message is displayed")
    public void pleaseFillOutThisFieldValidationMessageIsDisplayed() {
        String expectedBlankMessage = "Please fill out this field.";
wait.until(ExpectedConditions.visibilityOf(loginPage.password));

       String actualBlankMessage = loginPage.password.getAttribute("validationMessage");
        Assert.assertEquals(expectedBlankMessage, actualBlankMessage );
    }





}
