package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.popup.LocationPopUp;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDataLocationIsEmpty160 extends SpeakUkrainianRunner {
    @Test
    public void CheckButtonIsUnavailable() {
       String buttonIsDisabled = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickAddCenterButton()
                .clickAddLocation()
                .clickAddInLocationButton();

                Assert.assertEquals(buttonIsDisabled, "Button is Disabled");
                //Assert.assertFalse(addInLocationButton.isEnable());
    }
}
