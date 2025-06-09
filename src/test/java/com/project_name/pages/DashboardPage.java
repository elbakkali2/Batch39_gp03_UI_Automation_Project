package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    public List<String> getDisplayedModules() {
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//li[@style='display: block;']"));

        List<String> moduleNames = new ArrayList<>();
        for (WebElement element : moduleElements) {
            String text = element.getText();
            moduleNames.add(text);
        }
        return moduleNames;

    }
}
