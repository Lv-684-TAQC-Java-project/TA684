package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationPopUp extends BasePage {
    @FindBy(css = "div.add-club-content-footer.add-club-add-location-button>button")
    private WebElement addInLocationButton;
    @FindBy(id = "phone")
    private WebElement phonenumber;
    @FindBy(css = "div.modal-add-club>button.ant-modal-close")
    private WebElement  closeLocation;

    public LocationPopUp(WebDriver driver) {
        super(driver);
    }

    public boolean isDesabledAddLocationsButton() {
        return addInLocationButton.isEnabled();
    }

    public AddCenterPopUp closeLocationPopUp(){
        closeLocation.click();
        return new AddCenterPopUp(driver);
    }
}
