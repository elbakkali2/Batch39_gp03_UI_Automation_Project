package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {


    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//button[.='Day']")
    public WebElement daylyOption;

    @FindBy(xpath = "//button[.='Week']")
    public WebElement weeklyOption;

    @FindBy(xpath = "//button[.='Month']")
    public WebElement monthlyOption;



}
