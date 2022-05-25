package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationPopUp extends BasePage {
    @FindBy(css = "div.add-club-content-footer.add-club-add-location-button>button")
    private WebElement addInLocationButton;
    @FindBy(id = "phone")
    private WebElement phonenumber;
    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div/div[2]/button")
    private WebElement  closeLocation;

    public LocationPopUp(WebDriver driver) {
        super(driver);
    }

    @Step("Checking of button enabling")
    public boolean isDisabledAddLocationsButton() {
        return addInLocationButton.isEnabled();
    }

    public AddCenterPopUp closeLocationPopUp(){
        closeLocation.click();
        return new AddCenterPopUp(driver);
    }
}
