package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.popup.LocationPopUp;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAddCenterPopUp extends TestRuneWithAdmin {

    @BeforeMethod
    public void toTestAddCenter() {
        new HomePage(driver)
                .header()
                .clickUserProFileButton();
    }

    @Test
    @Description("Checking is button 'Додати' at page 'Додати локацію' unavailable")
    @Issue("TUA-160")
    public void CheckButtonIsUnavailable() {
        LocationPopUp locationPopUp = new HeaderMenuComponent(driver)
                .clickAddCenterButton()
                .clickAddLocation();
        Assert.assertFalse(locationPopUp.isDisabledAddLocationsButton(), "Button is disabled");
    }

    @Test
    @Description("Is visible error message, if the field 'Назва центру' is empty when we pushing on button 'Наступний крок'")
    @Issue("TUA-252")
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
