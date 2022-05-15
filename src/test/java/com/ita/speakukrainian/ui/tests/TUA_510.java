package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.components.HeaderMenuComponent;

import com.ita.speakukrainian.ui.pages.ClubsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TUA_510 extends SpeakUkrainianRunner {
    @Test
    public void testVerifyChildAgeAndAvailableOnline() {
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);
        ClubsPage clubsPage = new ClubsPage(driver);
        headerMenuComponent.clickExtendedSearchButton().clickCentreRadioButton();
        clubsPage.clickCityPopUp().clickCityKiev();
        clubsPage.clickCityDistrictPopUp().clickCityDistrictDesnyanskiy();
        clubsPage.clickNearestMetroStationPopUp().clickArsenalMetroStation();
        Assert.assertEquals(clubsPage.checkAvailableOnline(),false);
        Assert.assertEquals(clubsPage.checkAvailableAgeField(),false);

    }
}
