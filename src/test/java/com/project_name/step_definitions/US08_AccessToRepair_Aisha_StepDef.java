package com.project_name.step_definitions;

import com.project_name.pages.LoginPage;
import com.project_name.pages.US08_AccessToRepairPage_Aisha;
import com.project_name.utilities.BrowserUtils;
import com.project_name.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class US08_AccessToRepair_Aisha_StepDef {
    private String enteredSearchTerm;

    WebDriver driver = Driver.getDriver();
    US08_AccessToRepairPage_Aisha us08AccessToRepairPageAisha=new US08_AccessToRepairPage_Aisha();
    String searchValue; // 🟢 Store reference for assertion step

    @Given("user logged on as POS & Sales Manager with {string} and {string}")
    public void user_logged_on_as_pos_sales_manager_with_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }


    @Given("I am on the Repairs page")
    public void i_am_on_the_repairs_page() {
      //  us08AccessToRepairPageAisha.repairsBox.click();

        // Wait for login completion by checking page title or some element unique to post-login page
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Login | Best solution for startups")));


        // Navigate to Repairs page - maybe click Repairs menu/button
        wait.until(ExpectedConditions.elementToBeClickable(us08AccessToRepairPageAisha.repairsBox)).click();

        // Wait until Repairs page title is loaded
        wait.until(ExpectedConditions.titleIs("Repair Orders - Odoo"));

     String title= Driver.getDriver().getTitle();
        System.out.println("Page Title: " + title);
        assertEquals("Repair Orders - Odoo",title);


    }

    @Then("I should see {int} columns in the repair orders table:")
    public void i_should_see_columns_in_the_repair_orders_table(int expectedCount, DataTable dataTable)  {

            new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElements(us08AccessToRepairPageAisha.columnHeaders));

            // Count check directly
            assertEquals(
                    "Unexpected number of columns!",
                    expectedCount,
                    us08AccessToRepairPageAisha.columnHeaders.size()
            );

            // Name check directly (convert once, no separate list variable)
            assertEquals(
                    dataTable.asList().stream().map(String::trim).map(String::toLowerCase).toList(),
                    us08AccessToRepairPageAisha.columnHeaders.stream()
                            .map(e -> e.getText().trim().toLowerCase())
                            .toList()
            );

        System.out.println("=== Actual Column Headers ===");
        us08AccessToRepairPageAisha.columnHeaders.forEach(each ->
                System.out.println("-> " + each.getText().trim()));

    }

   // @When("I enter a Repair Reference into the search field")
   // public void iEnterARepairReferenceIntoTheSearchField() {

  //  }

    @When("I enter a {string} into the search field")
    public void iEnterAIntoTheSearchField(String search) {
        us08AccessToRepairPageAisha.searchBox.clear(); // optional, helps when search box retains text
        enteredSearchTerm = search;  // store it for later use
        us08AccessToRepairPageAisha.searchBox.sendKeys(search);

    }




    @When("I click the search button")
    public void i_click_the_search_button() {
  us08AccessToRepairPageAisha.searchButton.click();

    }
    @Then("the matching repair order should appear in the results")
    public void the_matching_repair_order_should_appear_in_the_results() {

        BrowserUtils.waitFor(2);

        System.out.println("Searched for: " + enteredSearchTerm);

        //get the values from the search input box
      //  String searchValue=us08AccessToRepairPageAisha.searchBox.getDomAttribute("value");
      //  System.out.println("Searched for :" + searchValue);


      //  if (searchValue == null || searchValue.trim().isEmpty()) {
         //   Assert.fail("Search value is null or empty. Make sure it's properly set in the test step.");
       // }



        //Get all visible results from the repair table
       // List<String>results=us08AccessToRepairPageAisha.resultCells.stream()
              //  .map(WebElement::getText)
               // .toList();
        if (enteredSearchTerm == null || enteredSearchTerm.trim().isEmpty()) {
            Assert.fail("Search value is null or empty. Make sure it's properly set in the test step.");
        }

        List<String> results = us08AccessToRepairPageAisha.resultCells.stream()
                .map(WebElement::getText)
                .toList();

        results.forEach(result -> System.out.println(" - " + result));


        //Print result
        System.out.println("Repair orders found :");
        results.forEach(result -> System.out.println(" - " + result));

      //Assert one of them matches the search
       // boolean found=results.stream().anyMatch(result->result.contains(searchValue));

        boolean found = results.stream()
                .filter(Objects::nonNull)
                .anyMatch(result -> result.contains(enteredSearchTerm));

     Assert.assertTrue("Repair order not found in results",found);
        System.out.println("Repair order found successfully");
    }


}




