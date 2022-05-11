package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClubsPage extends BasePage {
    private HeaderMenuComponent headerMenuComponent;
    private ExtendedSearchComponent extendedSearchComponent;

    @FindBy(css = "#basic_age input")
    private WebElement ageInputClubs;
    @FindBy(xpath = "//span[contains(.,'Центр')]")
    private WebElement checkedToCenterButton;


    public ClubsPage(WebDriver driver) {
        super(driver);
        headerMenuComponent = new HeaderMenuComponent(driver);
        extendedSearchComponent = new ExtendedSearchComponent(driver);
    }

    public WebElement getAgeInput() {
        return ageInputClubs;
    }

    public ClubsPage fillInAgeInput(int age) {
        getAgeInput().sendKeys(Integer.toString(age));
        return new ClubsPage(driver);
    }

    public ExtendedSearchComponent clickcheckedToCenterButtonon() {
        checkedToCenterButton.click();
        return new ExtendedSearchComponent(driver);
    }

    public String readAgeInput() {
        return getAgeInput().getAttribute("value");
    }

    public ExtendedSearchComponent getExtendedSearchComponent() {
        return extendedSearchComponent;
    }

    public HeaderMenuComponent getHeaderMenuComponent() {
        return headerMenuComponent;
    }


}

