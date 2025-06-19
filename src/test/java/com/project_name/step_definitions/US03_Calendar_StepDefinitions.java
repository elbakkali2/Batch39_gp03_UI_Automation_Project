package com.project_name.step_definitions;

import com.project_name.pages.CalendarPage;
import com.project_name.pages.DashboardPage;
import com.project_name.pages.LoginPage;
import com.project_name.utilities.BrowserUtils;
import com.project_name.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class US03_Calendar_StepDefinitions {


    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    CalendarPage calendarPage = new CalendarPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().navigate().to("https://qa.uplifterp.com/");

        loginPage.emailInput.sendKeys("salesmanager6@info.com" + Keys.ENTER);
        loginPage.passwordInput.sendKeys("salesmanager" + Keys.ENTER);
    }


    @When("user navigates to the calendar page")
    public void user_navigates_to_the_calendar_page() {

        dashboardPage.calendarOption.click();
    }

    @Then("user selects the daily view option")
    public void user_selects_the_daily_view_option() {

        calendarPage.daylyOption.click();
    }

    @Then("user should see the calendar displayed in daily format")
    public void user_should_see_the_calendar_displayed_in_daily_format() {

        BrowserUtils.verifyTitle("Meetings - Odoo");
    }



    @Then("user selects the weekly view option")
    public void user_selects_the_weekly_view_option() {

        calendarPage.weeklyOption.click();
    }

    @Then("user should see the calendar displayed in weekly format")
    public void user_should_see_the_calendar_displayed_in_weekly_format() {

        BrowserUtils.verifyTitle("Meetings - Odoo");
    }



    @Then("user selects the monthly view option")
    public void user_selects_the_monthly_view_option() {

        calendarPage.monthlyOption.click();
    }

    @Then("user should see the calendar displayed in monthly format")
    public void user_should_see_the_calendar_displayed_in_monthly_format() {

        BrowserUtils.verifyTitle("Meetings - Odoo");
    }
}