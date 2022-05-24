package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.popup.LocationPopUp;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAddCenterPopUp extends TestRuneWithAdmin {


    @BeforeMethod
    public void toTest() {
        new HomePage(driver)
                .header()
                .clickUserProFileButton();
    }

    @Test
    public void CheckButtonIsUnavailable160() {
        LocationPopUp locationPopUp = new HeaderMenuComponent(driver)
                .clickAddCenterButton()
                .clickAddLocation();
        Assert.assertFalse(locationPopUp.isDesabledAddLocationsButton(), "Button is not disabled");
    }

    @Test
    public void CheckErrorMessage252() {
        String incorrectCenterName = new HeaderMenuComponent(driver)
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddCenterButton()
                .clickNextStepButton()
                .getError();
        Assert.assertEquals(incorrectCenterName, "Некоректна назва центру");
    }
}
