package com.project_name.step_definitions;

import com.project_name.pages.LoginPage;
import com.project_name.utilities.ConfigurationReader;
import com.project_name.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class US16_Expense_Manager_MR {
    LoginPage loginPage = new LoginPage();

    @When("the user enters valid credentials for the Expenses Manager")
    public void the_user_enters_valid_credentials_for_the_expenses_manager() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAs("Expenses Manager");
    }

    @Then("the user should see their username in the top right corner")
    public void the_user_should_see_their_username_in_the_top_right_corner() {
        String actualUsername = Driver.getDriver().findElement(By.xpath("//span[@class='oe_topbar_name']")).getText();
        Assert.assertEquals("ExpensesManager10", actualUsername);
        System.out.println("Username  verified" + actualUsername);


    }

    @Then("the user should see the following modules:")
    public void the_expense_manager_should_see_modules(DataTable dataTable) {
        List<String> moduleNames = dataTable.asList();

        for (String module : moduleNames) {
            try {
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

                try {
                    WebDriverWait shortWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
                    WebElement modalClose = shortWait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[contains(@class,'modal-dialog')]//button[contains(@class,'close')]")));
                    modalClose.click();
                    shortWait.until(ExpectedConditions.invisibilityOf(modalClose));
                    System.out.println("Closed a modal before clicking: " + module);
                } catch (Exception ignored) {

                }

                WebElement moduleElement = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[@class='oe_menu_text' and normalize-space(text())='" + module + "']")));

                ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", moduleElement);

                moduleElement.click();

                Thread.sleep(1000);

                Driver.getDriver().navigate().back();

                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='oe_menu_text' and normalize-space(text())='" + moduleNames.get(0) + "']")));

            } catch (Exception e) {
                System.out.println("Could not click module: " + module);
                System.out.println("Exception while clicking module: " + e.getMessage());

            }
        }
    }
}