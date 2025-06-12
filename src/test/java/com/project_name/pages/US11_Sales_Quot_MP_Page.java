package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US11_Sales_Quot_MP_Page {

    public US11_Sales_Quot_MP_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@class='oe_menu_toggler']/span[normalize-space(text())='Sales']")
    public WebElement salesButton;

    @FindBy(xpath = "//th[@class='o_list_record_selector']//input[@type='checkbox']")
    public WebElement quotationNumberCheckbox;

    @FindBy(xpath = "//tbody//input[@type='checkbox']")
    public List<WebElement> rowCheckboxes;

    @FindBy(xpath = "//button[normalize-space()='Print']")
    public WebElement printButton;

    @FindBy(xpath = "//button[normalize-space()='Print']/following-sibling::ul[@class='dropdown-menu']")
    public WebElement quotationOrderOption;




}
