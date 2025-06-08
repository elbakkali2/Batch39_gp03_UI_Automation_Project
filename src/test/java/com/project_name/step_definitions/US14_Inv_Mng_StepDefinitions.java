package com.project_name.step_definitions;
import com.project_name.pages.LoginPage;
import com.project_name.pages.US14_Inv_Mng_Page;
import com.project_name.utilities.BrowserUtils;
import com.project_name.utilities.ConfigurationReader;
import com.project_name.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

public class US14_Inv_Mng_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    US14_Inv_Mng_Page invMngPage = new US14_Inv_Mng_Page();

   @Given ("the user is logged in as an \"Inventory Manager\"")

    public void the_user_is_logged_in_as_an_Inventory_Manager() {
       invMngPage.loginAsInvManager();
       invMngPage.submitButton.click();

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAs("Inventory Manager");
        // Wait for the page to load completely
        BrowserUtils.waitForPageToLoad(10);

        // Assuming there's a method to log in as Inventory Manager
        // loginAsInventoryManager();
    }
    @When("the user navigates to the main modules area")
    public void theUserNavigatesToTheMainModulesArea() {
        WebElement modulesContainer = Driver.getDriver().findElement(By.xpath("//*[contains(@class, 'navbar-collapse collapse')]"));

        // 2. (OPTIONAL BUT RECOMMENDED) Scroll to the container to ensure it's visible
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", modulesContainer);


    }

    @Then("all the following modules should be accessible")
    public void allTheFollowingModulesShouldBeAccessible(int arg0) {
        US14_Inv_Mng_Page.getInventoryModules().forEach(module -> {
            System.out.println("Module: " + module);

        });

    }




}
