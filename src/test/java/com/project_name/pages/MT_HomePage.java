package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MT_HomePage extends LoginPage {

    public MT_HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@style='display: block;']")
    public List<WebElement> topMenuModules;


    public void loginAsPOSManager() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("POS Manager");
    }
}
