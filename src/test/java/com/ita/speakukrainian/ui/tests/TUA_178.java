package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TUA_178 extends SpeakUkrainianRunner {

    @Test
    public void verifyErrorMessageOnRussianLettersInDescription() {
        boolean isAlertDisplayed = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickAddClubButton()
                .fillInClubNameInput("Football")
                .clickOptionCheckboxes(2)
                .fillInAgeFromInput("2")
                .fillInAgeToInput("18")
                .clickNextStepButton()
                .fillInContactFacebookInput("Facebook")
                .fillInContactMailInput("mail@mail.com")
                .fillInContactWhatsAppInput("WhatsUpp")
                .fillInContactInput("Dmytro")
                .fillInContactSkypeInput("Skype")
                .fillInContactPhoneInput("0675775031")
                .clickNextStepButton()
                .fillInBasicDescriptionInput("ъ")
                .isAlertDisplayed();

        Assert.assertTrue(isAlertDisplayed);
    }
    @Test
    public void verifyErrorMessageOnGermanLettersInDescription() {
        boolean isAlertDisplayed = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickAddClubButton()
                .fillInClubNameInput("Football")
                .clickOptionCheckboxes(2)
                .fillInAgeFromInput("2")
                .fillInAgeToInput("18")
                .clickNextStepButton()
                .fillInContactFacebookInput("Facebook")
                .fillInContactMailInput("mail@mail.com")
                .fillInContactWhatsAppInput("WhatsUpp")
                .fillInContactInput("Dmytro")
                .fillInContactSkypeInput("Skype")
                .fillInContactPhoneInput("0675775031")
                .clickNextStepButton()
                .fillInBasicDescriptionInput("öl")
                .isAlertDisplayed();

        Assert.assertTrue(isAlertDisplayed);
    }
}


