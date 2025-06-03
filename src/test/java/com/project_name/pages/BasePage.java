package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {


    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




}
