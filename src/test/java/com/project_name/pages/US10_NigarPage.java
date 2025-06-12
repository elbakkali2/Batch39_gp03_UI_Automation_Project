package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US10_NigarPage {
    public US10_NigarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Documentation")
    public WebElement documentationLink;

    @FindBy(xpath = "//h3") // Example locator
    public List<WebElement> documentationTopics;
}
