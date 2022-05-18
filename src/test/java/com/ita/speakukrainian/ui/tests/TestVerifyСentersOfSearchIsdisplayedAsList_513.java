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
        boolean ans1 = clubsPage.getClubRadioButtonIsPushed().isSelected();
        softAssert.assertTrue(ans1, "Club radioButton was not pushed");
               clubsPage.clickCentreRadioButton();
               boolean ans2 = clubsPage.getCentreRadioButton().isSelected();
        softAssert.assertTrue(ans2, "Centre radioButton was not pushed");
               clubsPage.clickSortMenuBarButton();
        boolean ans3 =clubsPage.getListOfCenters().isSelected();
        softAssert.assertTrue(ans3, "Centers was not sorted as list");
        softAssert.assertAll();
    }
}
