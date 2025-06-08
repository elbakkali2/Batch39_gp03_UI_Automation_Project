package com.project_name.step_definitions;
import com.project_name.pages.LoginPage;
import com.project_name.pages.US14_Inv_Mng_Page;
import com.project_name.utilities.BrowserUtils;
import com.project_name.utilities.ConfigurationReader;
import com.project_name.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.List;

public class US14_Inv_Mng_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    US14_Inv_Mng_Page invMngPage = new US14_Inv_Mng_Page();
    private DataTable dataTable;

    @Given("the user is logged in as an \"Inventory Manager\"")

    public void the_user_is_logged_in_as_an(String InventoryManager) {
        US14_Inv_Mng_Page.loginAsInvManager();
        LoginPage.submitButton.click();

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAs("Inventory Manager");
        // Wait for the page to load completely
        BrowserUtils.waitForPageToLoad(10);

        // Assuming there's a method to log in as Inventory Manager
        // loginAsInventoryManager();
    }

    @When("the user navigates to the main modules area")
    public void the_user_navigates_to_the_main_modules_area() {
        WebElement modulesContainer = Driver.getDriver().findElement(By.xpath("//*[contains(@class, 'navbar-collapse collapse')]"));

        // 2. (OPTIONAL BUT RECOMMENDED) Scroll to the container to ensure it's visible
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", modulesContainer);


    }

    @Then("all the following modules should be accessible")
    public void all_the_following_modules_should_be_accessible(io.cucumber.datatable.DataTable dataTable) {
        this.dataTable = dataTable;
        US14_Inv_Mng_Page.getInventoryModules().forEach(module -> System.out.println("Module: " + module));

    }


    @When("the user clicks on each module from the top menu")
    public void theUserClicksOnEachModuleFromTheTopMenu() {
        // Assuming the modules are listed in a specific container
        WebElement modulesContainer = Driver.getDriver().findElement(By.xpath("//*[contains(@class, 'navbar-collapse collapse')]"));

        // Find all module elements within the container
        List<WebElement> moduleElements = modulesContainer.findElements(By.xpath(".//span[@class='oe_menu_text']"));

        // Click on each module and verify accessibility
        for (WebElement module : moduleElements) {
            String moduleName = module.getText();
            System.out.println("Clicking on module: " + moduleName);
            module.click();

            // Optionally, you can add assertions to verify that the page loaded correctly
            BrowserUtils.waitForPageToLoad(10);
            Assert.assertTrue("Module " + moduleName + " is not accessible", Driver.getDriver().getTitle().contains(moduleName));
        }

    }
    @Then("the corresponding page for each module should be displayed")
    public void the_corresponding_page_for_each_module_should_be_displayed() {
        // Assuming the modules are listed in a specific container
        WebElement modulesContainer = Driver.getDriver().findElement(By.xpath("//*[contains(@class, 'navbar-collapse collapse')]"));

        // Find all module elements within the container
        List<WebElement> moduleElements = modulesContainer.findElements(By.xpath(".//span[@class='oe_menu_text']"));

        // Verify that each module is accessible and the corresponding page is displayed
        for (WebElement module : moduleElements) {
            String moduleName = module.getText();
            System.out.println("Verifying module: " + moduleName);
            Assert.assertTrue("Module " + moduleName + " is not accessible", Driver.getDriver().getTitle().contains(moduleName));
        }
    }
}
