package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TUA_224 extends SpeakUkrainianRunner {
    @Test
    public void testIsExtendedSearchMenuDisplayed(){
        ClubsPage clubsPage = new ClubsPage(driver);
        Assert.assertEquals(clubsPage.isExtendedSearchMenuDisplayed(),true);
    }
    @Test
    public void testIsExtendedSearchMenuHidden(){
        ClubsPage clubsPage = new ClubsPage(driver);
        Assert.assertEquals(clubsPage.isExtendedSearchMenuHidden(),true);
    }
}
