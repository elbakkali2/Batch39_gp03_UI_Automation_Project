package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id = "menu_more_container")
    public WebElement moreButton;


    @FindBy(xpath = "//span[normalize-space()='Calendar']")
    public WebElement calendarOption;


    public List<String> getDisplayedModules() {
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));  // // wait helper for dynamic content

        List<String> moduleNames = new ArrayList<>();

        // // Step 1: Find all visible modules on the main menu by their span with class 'oe_menu_text'
        List<WebElement> visibleModules = driver.findElements(
                By.xpath("//li[@style='display: block;']//span[contains(@class,'oe_menu_text')]")
        );

        for (WebElement span : visibleModules) {
            String text = span.getText().trim();  // // get trimmed text from span
            if (!text.isEmpty()) {                 // // avoid empty strings
                moduleNames.add(text);             // // add visible module name to list
            }
        }

        try {
            // // Step 2: Check if the More button is visible (meaning there are hidden modules)
            if (moreButton.isDisplayed()) {
                moreButton.click();                 // // click the More button to reveal hidden modules

                // // Step 3: Wait until the container with the More modules is visible
                WebElement moreContainer = driver.findElement(By.id("menu_more_container"));
                wait.until(ExpectedConditions.visibilityOf(moreContainer));

                // // Step 4: Get all module names inside the More dropdown container
                List<WebElement> moreModules = moreContainer.findElements(
                        By.xpath(".//li//span[contains(@class,'oe_menu_text')]")
                );

                for (WebElement span : moreModules) {
                    String text = span.getText().trim();  // // get trimmed text
                    // // add only new module names (not duplicates)
                    if (!text.isEmpty() && !moduleNames.contains(text)) {
                        moduleNames.add(text);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Could not expand More menu or get modules: " + e.getMessage());
        }

        return moduleNames;  // // return combined list of visible + hidden module names
    }



//    public List<String> getDisplayedModules() {
//        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//li[@style='display: block;']"));
//
//        List<String> moduleNames = new ArrayList<>();
//        for (WebElement element : moduleElements) {
//            String text = element.getText();
//            moduleNames.add(text);
//        }
//        return moduleNames;
//
//    }


}
