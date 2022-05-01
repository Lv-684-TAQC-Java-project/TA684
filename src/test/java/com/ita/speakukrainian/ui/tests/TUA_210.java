package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TUA_210 extends SpeakUkrainianRunner {

    @Test
    public void verifyInputAcceptsPositiveIntegersFrom2To18() {
        String actualAgeValue = new HomePage(driver)
                .header().clickExtendedSearchButton()
                .getExtendedSearchComponent().fillInAgeInput(1)
                .getExtendedSearchComponent().readAgeInput();

       Assert.assertEquals(Integer.valueOf(actualAgeValue),2);
    }

    @Test
    public void verifyInputAcceptsPositiveIntegersFrom2To182() {
        String actualAgeValue = new HomePage(driver)
                .header().clickExtendedSearchButton()
                .getExtendedSearchComponent().fillInAgeInput(2)
                .getExtendedSearchComponent().readAgeInput();

        Assert.assertEquals(Integer.valueOf(actualAgeValue),2);
    }

    @Test
    public void verifyInputAcceptsPositiveIntegersFrom2To183() {
        String actualAgeValue = new HomePage(driver)
                .header().clickExtendedSearchButton()
                .getExtendedSearchComponent().fillInAgeInput(18)
                .getExtendedSearchComponent().readAgeInput();

        Assert.assertEquals(Integer.valueOf(actualAgeValue),18);
    }

    @Test
    public void verifyInputAcceptsPositiveIntegersFrom2To184() {
        String actualAgeValue = new HomePage(driver)
                .header().clickExtendedSearchButton()
                .getExtendedSearchComponent().fillInAgeInput(20)
                .getExtendedSearchComponent().readAgeInput();

        Assert.assertEquals(Integer.valueOf(actualAgeValue),18);
    }
}

