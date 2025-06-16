package com.project_name.step_definitions;

import com.project_name.pages.LoginPage;
import com.project_name.pages.US05_MKO_Page;
import com.project_name.utilities.BrowserUtils;
import com.project_name.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;


public class US05_MKO_StepDefinitions extends US05_MKO_Page {

    //private static final Logger log = LoggerFactory.getLogger(US05_MKO_StepDefinitions.class);
    LoginPage loginPage = new LoginPage();

   /* @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }*/ // we don't need this because there is already method inside the Hooks
   @Given("user enters correct {string} and {string}")
   public void userEntersCorrectAnd(String email, String password) {
       loginPage.login(email,password);
   }


    US05_MKO_Page us05MkoPage = new US05_MKO_Page();

    @And("The user can create a new customer by filling only the Name input box and after clicking the save button.")
    public void the_user_can_create_a_new_customer_by_filling_only_the_name_input_box_and_after_clicking_the_save_button() {
        BrowserUtils.sleep(5);
        us05MkoPage.salesButton.click();
        BrowserUtils.sleep(5);
        us05MkoPage.customersButton.click();
        BrowserUtils.sleep(4);
        us05MkoPage.createButton.click();
        BrowserUtils.sleep(4);
        us05MkoPage.nameInputBox.sendKeys(ConfigurationReader.getProperty("jamieDone"));
        BrowserUtils.sleep(2);
        us05MkoPage.saveButton.click();
        BrowserUtils.sleep(2);

    }
    @And("The information of the customer which the user entered should be displayed.")
    public void the_information_of_the_customer_which_the_user_entered_should_be_displayed() {
        us05MkoPage.customersButton.click();
        BrowserUtils.sleep(4);
        us05MkoPage.searchBox.sendKeys(ConfigurationReader.getProperty("jamieDone") + Keys.ENTER);
        BrowserUtils.sleep(4);
        us05MkoPage.customerNamePage.click();
        System.out.println("us05MkoPage.customerNamePage.isDisplayed() = " + us05MkoPage.customerNamePage.isDisplayed());

    }
    @Then("All the boxes entered information can be editable again after clicking any customer and then clicking the edit button.")
    public void all_the_boxes_entered_information_can_be_editable_again_after_clicking_any_customer_and_then_clicking_the_edit_button() {
        us05MkoPage.editButton.click();
        BrowserUtils.sleep(4);
       // WebElement input = Driver.getDriver().findElement(By.xpath("(//input[contains(@id, 'o_field_input_')])[2]"));
//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("arguments[0].value = '';", nameInputBox);
        us05MkoPage.nameInputBox.clear();
        BrowserUtils.sleep(4);
        us05MkoPage.nameInputBox.sendKeys(ConfigurationReader.getProperty("aryaStark"));
        BrowserUtils.sleep(4);
        us05MkoPage.saveButton.click();

    }


}
