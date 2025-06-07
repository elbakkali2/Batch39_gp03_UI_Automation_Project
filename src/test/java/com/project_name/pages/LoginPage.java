package com.project_name.pages;

import com.project_name.utilities.ConfigurationReader;
import com.project_name.utilities.Driver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(partialLinkText = "Wrong login/password")
    public WebElement WrongLoginPassword;

    @FindBy (xpath = "//li[@class='o_user_menu']")
    public WebElement userMenu;

    @FindBy (xpath = "(//a[@href='#'])[7]")
    public WebElement logout;


    public void login(String email, String password){
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
        this.submitButton.click();
    }

    public void loginAs(String role) {
        String formattedRole = role.toLowerCase().replace(" ", "_");
        String username = ConfigurationReader.getProperty(formattedRole + "_username");
        String password = ConfigurationReader.getProperty(formattedRole + "_password");

        if (username == null || password == null) {
            throw new IllegalArgumentException("Missing credentials for role: " + role);
        }

        login(username, password);
    }

}

}
