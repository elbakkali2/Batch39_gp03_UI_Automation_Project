package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US05_MKO_Page {

    public US05_MKO_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//span[text()[normalize-space()='Sales']]")
    public WebElement salesButton;

    @FindBy(xpath = "(//span[text()[normalize-space()='Customers']])[2]")
    public WebElement customersButton;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy(xpath = "(//input[contains(@id, 'o_field_input_')])[2]")
    public WebElement nameInputBox;

    @FindBy(xpath = "(//button[text()[normalize-space()='Save']])[1]")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record']")
    public WebElement customerNamePage;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_edit']")
    public WebElement editButton;

}
