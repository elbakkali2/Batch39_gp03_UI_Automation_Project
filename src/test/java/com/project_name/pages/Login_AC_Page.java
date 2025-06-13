package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_AC_Page {



    public Login_AC_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//input[@type='text']" )
    public WebElement userName;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

   // @FindBy(xpath = "//span[@class='oe_topbar_name']")
    @FindBy(xpath = "//span[text()[normalize-space()='Discuss']]")
    public WebElement successfulLogin;

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement wrong_login_password;








}
