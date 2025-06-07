package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class US09_POSOrdersPage_JD {


    public US09_POSOrdersPage_JD() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-menu-xmlid='point_of_sale.menu_point_root']")
    public WebElement pointOfSale;

    @FindBy(xpath = "//a[@data-menu-xmlid='point_of_sale.menu_point_ofsale']")
    public WebElement ordersMenu;

    @FindBy(xpath = "//table//thead//tr/th[1]//input[@type='checkbox']")
    public WebElement orderRefCheckbox;
    @FindBy(xpath = "//table//tbody//tr//td[1]//input[@type='checkbox']")
    public List <WebElement> orderCheckboxes;

    @FindBy(xpath = "//tr[contains(@class, 'o_data_row')]")
    public List<WebElement> orderRefElements;

    @FindBy(xpath = "//button[contains(text(), 'Action')]")
    public WebElement actionDropdownButton;

    @FindBy(xpath = "//div[contains(@class,'o_dropdown')]//ul[contains(@class,'dropdown-menu')]/li/a")
    public List<WebElement> actionDropdownOptions;

    @FindBy(xpath = "//a[contains(text(), 'Import')]")
    public WebElement importOption;

    @FindBy(xpath = "//a[contains(text(), 'Export')]")
    public WebElement exportOption;

    @FindBy(xpath = "//a[contains(text(), 'Delete')]")
    public WebElement deleteOption;

    public boolean isOrdersListDisplayed() {
        return !orderRefElements.isEmpty();
    }

    public List<String> getAllOrderReferences() {
        return orderRefElements.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    }




