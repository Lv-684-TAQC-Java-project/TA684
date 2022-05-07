package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.popup.LocationPopUp;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDataLocationIsEmpty160 extends SpeakUkrainianRunner {
    @BeforeMethod
    public void toTest160 (){
        setUp();
         new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton();

    }

    @Test
    public void CheckButtonIsUnavailable() {
        LocationPopUp locationPopUp = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickAddCenterButton()
                .clickAddLocation();


                Assert.assertFalse(locationPopUp.isDesabledAddLocationsButton(), "Button is not disabled");
                //Assert.assertFalse(addInLocationButton.isEnable());
    }
}
