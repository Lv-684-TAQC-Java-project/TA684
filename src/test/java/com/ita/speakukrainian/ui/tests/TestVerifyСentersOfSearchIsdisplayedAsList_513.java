package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestVerifyСentersOfSearchIsdisplayedAsList_513 extends SpeakUkrainianRunner {
    @Test
    public void testCheckButtonsIsUnavailable () {
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);
        ClubsPage clubsPage = new ClubsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        headerMenuComponent.
                clickExtendedSearchButton();
        softAssert.assertTrue(clubsPage.getClubRadioButtonIsPushed().isEnabled(), "Club RadioButton was not Pushed");
               clubsPage.clickCentreRadioButton();
        softAssert.assertTrue(clubsPage.getCenterRadioButtonIsPushed().isEnabled(), "Centre RadioButton was not Pushed");
               clubsPage.clickSortMenuBarButton();
        softAssert.assertTrue(clubsPage.getListOfCenters().isEnabled(), "Centers was not sorted as list");
        softAssert.assertAll();

    }
}
