package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.testruners.SpeakUkrainianRunner;
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
        softAssert.assertTrue(clubsPage.IsClubButtonSelected(), "Club radioButton was not pushed");
               clubsPage.clickCentreRadioButton();
        softAssert.assertTrue(clubsPage.IsCentreButtonSelected(), "Centre radioButton was not pushed");
               clubsPage.clickSortMenuBarButton();
        softAssert.assertTrue(clubsPage.IsCentresSortedAsList(), "Centers was not sorted as list");
        softAssert.assertAll();
    }
}
