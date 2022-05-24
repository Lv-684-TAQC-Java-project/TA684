package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.testruners.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestIncorrectDescriptionsAddClub178 extends SpeakUkrainianRunner {
    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        Object[][] data = new Object[][]{
                {"ъ"},
                {"öl"}
        };
        return data;
    }

    @Test(dataProvider = "data")
    @Description("Verify Error Message On Russian And German Letters In Description")
    @Issue("TUA-178")
    public void verifyErrorMessageOnRussianAndGermanLettersInDescription(String text) {
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
