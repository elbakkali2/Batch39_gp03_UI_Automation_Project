package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(submitButton));
    }

    @FindBy(id = "login")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[contains(text(), 'Wrong login/password')]")
    public WebElement wrongLoginPassword;

    @FindBy(xpath = "//li[contains(@class,'o_user_menu')]")
    public WebElement userMenu;

    @FindBy(xpath = "(//a[@href='#'])[7]")
    public WebElement logout;

    public void login(String email, String password){
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
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

