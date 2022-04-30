package com.ita.speakukrainian.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExtendedSearchComponent {
    protected WebDriver driver;

    @FindBy(css = "#basic_age input")
    private WebElement ageInput;

    ExtendedSearchComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getAgeInput() {
        return ageInput;
    }

    public ClubsPage fillInAgeInput(int age) {
        getAgeInput().sendKeys(Integer.toString(age));
        return new ClubsPage(driver);
    }

    public String readAgeInput() {
        return getAgeInput().getAttribute("value");
    }
}

