package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDescriptionWithValidData173 extends SpeakUkrainianRunner {

    @Test
    public void verifySuccessIconDisplayedForValidNumberOfUkrainianEnglishLetters () {
        boolean isSuccessIconDisplayed = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickAddClubButton()
                .fillInClubNameInput("Esports")
                .clickOptionCheckboxes(4)
                .fillInAgeFromInput("14")
                .fillInAgeToInput("25")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput("testтестclubгуртокeducationосвітаfootball")
                .isSuccessIconDisplayed();
        Assert.assertTrue(isSuccessIconDisplayed);
    }

    @Test
    public void verifySuccessIconDisplayedForValidNumberOfDigits () {
        boolean isSuccessIconDisplayed = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickAddClubButton()
                .fillInClubNameInput("Dance")
                .clickOptionCheckboxes(3)
                .fillInAgeFromInput("6")
                .fillInAgeToInput("21")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput("1234567890123456789012345678901234567890")
                .isSuccessIconDisplayed();
        Assert.assertTrue(isSuccessIconDisplayed);
    }

    @Test
    public void verifySuccessIconDisplayedForValidNumberOfSpecialCharacters () {
        boolean isSuccessIconDisplayed = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickAddClubButton()
                .fillInClubNameInput("Theater")
                .clickOptionCheckboxes(5)
                .fillInAgeFromInput("10")
                .fillInAgeToInput("22")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput("!\"#$%&'()*+,-./:;<=>?@[]^_`{}~123456789ЇD")
                .isSuccessIconDisplayed();
        Assert.assertTrue(isSuccessIconDisplayed);
    }
}
