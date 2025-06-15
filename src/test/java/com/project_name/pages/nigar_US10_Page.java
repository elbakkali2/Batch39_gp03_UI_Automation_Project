package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class nigar_US10_Page {

    public nigar_US10_Page(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(xpath = "//span[contains(@class,'oe_topbar_name')]")
    public WebElement  userMenuToggle;


    @FindBy(xpath = "//a[text()='Documentation']")
    public WebElement documentationLink;

    public void clickDocumentation() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // Wait until login completes by checking for the dashboard URL or any post-login indicator
        wait.until(ExpectedConditions.urlContains("/web")); // <-- Adjust if your URL is different


        // 🔍 Add this debug line here
        System.out.println("User menu toggle displayed? " + userMenuToggle.isDisplayed());

        // Now click the menu
        userMenuToggle.click();


        // Wait for and click the Documentation link
        wait.until(ExpectedConditions.elementToBeClickable(documentationLink)).click();
    }
    @FindBy(css = "h1.text-white")
    public WebElement documentationHeader;

}