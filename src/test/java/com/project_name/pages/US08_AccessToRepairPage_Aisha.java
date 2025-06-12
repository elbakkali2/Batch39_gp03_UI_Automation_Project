package com.project_name.pages;

import com.project_name.utilities.BrowserUtils;
import com.project_name.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class US08_AccessToRepairPage_Aisha {



   public US08_AccessToRepairPage_Aisha(){
       PageFactory.initElements(Driver.getDriver(),this);
   }
    @FindBy(xpath = "//a[@class='oe_menu_leaf']//span[normalize-space()='Repairs']")
    public WebElement repairsBox;



    // Locate all column headers using @FindBy
   @FindBy(css ="th.o_column_sortable")
    public List<WebElement>columnHeaders;




    // Method to get header text list
    public List<String> getHeaderTexts() {
        return columnHeaders.stream()
                .map(element -> element.getText().trim())
                .collect(Collectors.toList());
    }

    //Locate the Search box
    @FindBy(xpath = "//input[@placeholder='Search...']")
    public WebElement searchBox;

    @FindBy(xpath = "//span[@title='Advanced Search...']")
    public WebElement searchButton;


    @FindBy(css = "td.o_data_cell")
    public List<WebElement>resultCells;



}








