package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TUA_178 extends SpeakUkrainianRunner {
    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        Object[][] data = new Object[][]{
                {"ъ"},
                {"öl"}
        };
        return data;
    }

    @Test(dataProvider = "data")
    public void verifyErrorMessageOnRussianLettersInDescription(String text) {
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
                .fillInContactFacebookInput(valueProvider.getContactFacebook())
                .fillInContactMailInput(valueProvider.getContactEmail())
                .fillInContactWhatsAppInput(valueProvider.getContactWhatsUpp())
                .fillInContactInput(valueProvider.getContactName())
                .fillInContactSkypeInput(valueProvider.getContactSkype())
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(text)
                .isAlertDisplayed();

        Assert.assertTrue(isAlertDisplayed);
    }
}
//    @Test
//    public void verifyErrorMessageOnGermanLettersInDescription() {
//        boolean isAlertDisplayed = new HomePage(driver)
//                .header()
//                .clickUserProFileButton()
//                .clickSingInButton()
//                .sendKeysEmail(valueProvider.getAdminEmail())
//                .sendKeysPassword(valueProvider.getAdminPassword())
//                .clickLoginButton()
//                .header()
//                .clickUserProFileButton()
//                .clickAddClubButton()
//                .fillInClubNameInput("Football")
//                .clickOptionCheckboxes(2)
//                .fillInAgeFromInput("2")
//                .fillInAgeToInput("18")
//                .clickNextStepButton()
//                .fillInContactFacebookInput(valueProvider.getContactFacebook())
//                .fillInContactMailInput(valueProvider.getContactEmail())
//                .fillInContactWhatsAppInput(valueProvider.getContactWhatsUpp())
//                .fillInContactInput(valueProvider.getContactName())
//                .fillInContactSkypeInput(valueProvider.getContactSkype())
//                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
//                .clickNextStepButton()
//                .fillInBasicDescriptionInput("öl")
//                .isAlertDisplayed();
//
//        Assert.assertTrue(isAlertDisplayed);
//    }
//}


