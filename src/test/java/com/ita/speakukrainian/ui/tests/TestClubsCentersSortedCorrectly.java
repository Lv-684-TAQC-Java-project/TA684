package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClubsCentersSortedCorrectly extends SpeakUkrainianRunner {


    @Test
    public void AdvancedSearchOpened(){
        boolean isSearchOpenedDisplayed = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickSearchInput()
                .isDisplayedSearchInputDropdown();
        Assert.assertTrue(isSearchOpenedDisplayed);
    }
}
