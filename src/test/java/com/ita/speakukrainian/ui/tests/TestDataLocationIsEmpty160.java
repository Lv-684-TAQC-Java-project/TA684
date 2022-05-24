package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.testruners.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.popup.LocationPopUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDataLocationIsEmpty160 extends SpeakUkrainianRunner {

    @Test
    public void CheckButtonIsUnavailable() {
        LocationPopUp locationPopUp = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickAddCenterButton()
                .clickAddLocation();
        Assert.assertFalse(locationPopUp.isDesabledAddLocationsButton(), "Button is not disabled");
    }
}
