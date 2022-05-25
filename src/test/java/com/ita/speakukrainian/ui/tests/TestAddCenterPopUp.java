package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.popup.AddCenterPopUp;
import com.ita.speakukrainian.ui.popup.LocationPopUp;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAddCenterPopUp extends TestRuneWithAdmin {

    @BeforeMethod
    public void toTestAddCenter() {
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
//        locationPopUp.closeLocationPopUp();
//        AddCenterPopUp closeAddCentre = new AddCenterPopUp(driver);
//        closeAddCentre.closeAddCentrePopUp();
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
//        AddCenterPopUp closeAddCentre = new AddCenterPopUp(driver);
//        closeAddCentre.closeAddCentrePopUp();
    }


}
