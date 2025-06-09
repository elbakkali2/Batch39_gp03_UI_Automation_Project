package com.project_name.pages;

import com.project_name.utilities.ConfigurationReader;
import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "login")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")

    public static WebElement submitButton;
    

    public WebElement submitButton;



    public void login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
    }


    public void loginAs(String role) {
        String formattedRole = role.toLowerCase().replace(" ", "_");
        String email = ConfigurationReader.getProperty(formattedRole + "_email");
        String password = ConfigurationReader.getProperty(formattedRole + "_password");

        if (email == null || password == null) {
            throw new IllegalArgumentException("Missing credentials for role: " + role);
        }


        login(email, password);
    }

}













