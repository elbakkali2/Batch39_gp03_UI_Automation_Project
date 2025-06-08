package com.project_name.pages;

import com.project_name.utilities.Driver;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US14_Inv_Mng_Page extends LoginPage {



    public US14_Inv_Mng_Page() {PageFactory.initElements(Driver.getDriver(), this);}
    // Define the WebElements for the Inventory Management page

    public static void loginAsInvManager() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("Inventory Manager");
    }

    public static List<String> getInventoryModules() {

        Arrays dataTable = null;
        List<String> expectedModules = Arrays.asList();
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//*[@class='navbar-collapse collapse']//span[@class='oe_menu_text']"));

        List<String> moduleNames = new ArrayList<>();
        for (WebElement element : moduleElements) {
            String text = element.getText();
            moduleNames.add(text);
            Assert.assertTrue(
                    "Inventory Management modules are not accessible",
                    moduleNames.containsAll(expectedModules));
        }
        return moduleNames;


    }

}
