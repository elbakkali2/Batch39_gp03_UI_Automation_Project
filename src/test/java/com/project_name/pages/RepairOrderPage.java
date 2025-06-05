package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class RepairOrderPage {

    public RepairOrderPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="login")
     public WebElement  emailBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement  passwordBox;

    @FindBy(id="//button[.='Log in']")
    public WebElement  loginButton;


    @FindBy(xpath = "(//li[@class='active'])[2]")
    public WebElement repairBox;



    @FindBy (xpath = "(//div[@class='o_checkbox'])[1]")
    public WebElement repairReferenceBox;




}
