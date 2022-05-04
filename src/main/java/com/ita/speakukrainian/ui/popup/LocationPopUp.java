package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationPopUp extends BasePage {
    @FindBy(css="div.add-club-content-footer.add-club-add-location-button>button")
    private WebElement addInLocationButton;
    @FindBy(id="phone")
    private WebElement phonenumber;

    public LocationPopUp(WebDriver driver) {
        super(driver);
    }

    public String clickAddInLocationButton() {
        scrollToElement(addInLocationButton);
        sleep(5000);
        if (addInLocationButton.isEnabled()) {
            addInLocationButton.click();
            return "Button is Enabled";
        } else
            return "Button is Disabled";
    }
}