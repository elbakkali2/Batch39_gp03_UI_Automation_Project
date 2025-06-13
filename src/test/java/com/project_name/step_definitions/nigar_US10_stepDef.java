package com.project_name.step_definitions;

import com.project_name.pages.LoginPage;
import com.project_name.pages.nigar_US10_Page;
import com.project_name.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class nigar_US10_stepDef {
    WebDriver driver = Driver.getDriver();
    nigar_US10_Page userPage = new nigar_US10_Page();

    @Given("the user is logged on with {string} and {string}")
    public void the_user_is_logged_on_with_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        // ADD DEBUG PRINT HERE
        System.out.println("Waiting for user menu toggle to be visible...");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(userPage.userMenuToggle));

        System.out.println("User menu toggle is visible: " + userPage.userMenuToggle.isDisplayed());

    }

    @When("the user clicks the Documentation link")
    public void the_user_clicks_the_documentation_link() {
        // nigar_US10_Page userPage = new nigar_US10_Page();

        userPage.clickDocumentation();
    }

    @Then("a new window opens with the header {string}")
    public void aNewWindowOpensWithTheHeader(String expectedHeader) {
        WebDriver driver = Driver.getDriver();
        String originalWindow = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }




        }

        String actualHeader = userPage.documentationHeader.getText();
        Assert.assertEquals(expectedHeader, actualHeader);
    }

    @Then("the page shows the following topics:")
    public void the_page_shows_the_following_topics(DataTable dataTable) {
        List<String> expectedTopics = dataTable.asList();
        WebDriver driver = Driver.getDriver();

        for (String topic : expectedTopics) {
            Assert.assertTrue("Missing topic: " + topic, driver.getPageSource().contains(topic));
        }
    }


}

