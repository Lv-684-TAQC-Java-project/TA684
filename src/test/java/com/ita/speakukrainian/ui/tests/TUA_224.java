package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TUA_224 extends SpeakUkrainianRunner {

    @Test
    public void testSideBarIsDisplayed() {
        ClubsPage clubsPage = new ClubsPage(driver);
        Assert.assertEquals(clubsPage.clickAndOpenExtendedSearch(),true);
    }

    @Test
    public void testSideBarIsHidden() {
        ClubsPage clubsPage = new ClubsPage(driver);
        Assert.assertEquals(clubsPage.clickOpenAndCloseExtendedSearch(),true);
    }
}
