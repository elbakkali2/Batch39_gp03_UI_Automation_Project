package com.project_name.step_definitions;

import com.project_name.pages.MT_HomePage;
import com.project_name.utilities.BrowserUtils;
import com.project_name.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US013_AccessModulesMT_StepDefinitions {

    MT_HomePage mtHomePage = new MT_HomePage();

    @Given("the manager is logged in as a POS Manager")
    public void theManagerIsLoggedInAsAPOSManager() {
        mtHomePage.loginAsPOSManager();

    }

    @When("the manager navigates to the homepage")
    public void theManagerNavigatesToTheHomepage() {
    }

    @Then("the manager should see the following modules:")
    public void theManagerShouldSeeTheFollowingModules(List<String> expectedModules) {
        List<String> actualModules = new ArrayList<>();

        for (WebElement module : mtHomePage.topMenuModules) {
            actualModules.add(module.getText().trim());
        }

        Assert.assertEquals("Modules do not match!", expectedModules, actualModules);

    }

    @When("the manager clicks on each module from the top menu")
    public void theManagerClicksOnEachModuleFromTheTopMenu() {

        for (WebElement module : mtHomePage.topMenuModules) {
            if (module.isDisplayed()) {
                String moduleName = module.getText().trim();
                System.out.println("Clicking on module: " + moduleName);
                module.click();

                BrowserUtils.waitFor(2);

                Driver.getDriver().navigate().back();
                BrowserUtils.waitFor(2);
            }
        }
    }
}


