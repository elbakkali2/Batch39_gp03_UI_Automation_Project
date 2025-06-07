package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;
import java.util.List;

public class POSOrdersPage {
    WebDriver driver = Driver.getDriver();

    @FindBy(xpath="//button[contains(@class,'o_dropdown_toggler_btn') and contains(text(),'Action')]")
    public static WebElement actionDropdown;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//li")
    public List<WebElement> actionDropdownMenu;
}

