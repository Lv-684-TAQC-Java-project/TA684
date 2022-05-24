package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.testruners.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TUA_224 extends SpeakUkrainianRunner {
    @Test
    @Description("[allure]  Is Extended search menu is displayed")
    @Issue("TUA-224")
    public void testIsExtendedSearchMenuDisplayed(){
        ClubsPage clubsPage = new ClubsPage(driver);
        Assert.assertEquals(clubsPage.isExtendedSearchMenuDisplayed(),true);
    }
    @Test
    @Description("[allure]  Is Extended search menu is hidden")
    @Issue("TUA-224")
    public void testIsExtendedSearchMenuHidden(){
        ClubsPage clubsPage = new ClubsPage(driver);
        Assert.assertEquals(clubsPage.isExtendedSearchMenuHidden(),true);
    }
}
