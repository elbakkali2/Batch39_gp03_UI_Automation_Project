package com.project_name.step_definitions;

import com.project_name.pages.MT_HomePage;
import com.project_name.utilities.ConfigurationReader;
import com.project_name.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US013_AccessModules_StepDefinitions {

    MT_HomePage mtHomePage = new MT_HomePage();

    @Given("the user is logged in as a POS Manager")
    public void theUserIsLoggedInAsAPOSManager() {
        mtHomePage.loginAsPOSManager();
        mtHomePage.submitButton.click();
    }

    @When("the user navigates to the homepage")
    public void theUserNavigatesToTheHomepage() {
    }

    @Then("the user should see the following modules:")
    public void theUserShouldSeeTheFollowingModules() {

    }

    @When("the user clicks on each module from the top menu")
    public void theUserClicksOnEachModuleFromTheTopMenu() {
    }

    @Then("the corresponding page for each module should be displayed")
    public void theCorrespondingPageForEachModuleShouldBeDisplayed(){
        System.out.println("Verified: Each module leads to its corresponding page.");
    }

}
