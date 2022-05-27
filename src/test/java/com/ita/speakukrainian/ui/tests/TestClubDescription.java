package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.pages.AddClubPages.Contacts;
import com.ita.speakukrainian.ui.pages.AddClubPages.Explanation;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClubDescription extends TestRuneWithAdmin {


    @Test
    @Description("Verify Error Message On Russian And German Letters In Description")
    @Issue("TUA-178")
    public void verifyErrorMessageOnRussianAndGermanLettersInDescription() {
        final String clubName = "Football";
        final int checkboxDancingСhoreography = 2;
        final String ageFrom = "2";
        final String ageTo = "18";
        final String russianCharacter = "ъ";
        final String germanCharacter = "öl";


        List<String> expectedErrorMessagesRussianLetter = Arrays.asList("Некоректний опис гуртка",
                "Опис гуртка може містити від 40 до 1500 символів.", "Опис гуртка не може містити російські літери");

        List<String> expectedErrorMessagesGermanLetter = Arrays.asList("Некоректний опис гуртка",
                "Опис гуртка може містити від 40 до 1500 символів.");

        SoftAssert softAssert = new SoftAssert();

        boolean areErrorMessagesForRussianDisplayed = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickAddClubButton()
                .fillInClubNameInput(clubName)
                .clickOptionCheckboxes(checkboxDancingСhoreography)
                .fillInAgeFromInput(ageFrom)
                .fillInAgeToInput(ageTo)
                .clickNextStepButton()
                .fillInContactFacebookInput(valueProvider.getContactFacebook())
                .fillInContactMailInput(valueProvider.getContactEmail())
                .fillInContactWhatsAppInput(valueProvider.getContactWhatsUpp())
                .fillInContactInput(valueProvider.getContactName())
                .fillInContactSkypeInput(valueProvider.getContactSkype())
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(russianCharacter)
                .areErrorMessagesDisplayed(expectedErrorMessagesRussianLetter);
        new Explanation(driver)
                .clearDescriptionField();

        boolean areErrorMessagesGermanDisplayed = new Explanation(driver)
                .fillInBasicDescriptionInput(germanCharacter)
                .areErrorMessagesDisplayed(expectedErrorMessagesGermanLetter);

        softAssert.assertTrue(areErrorMessagesForRussianDisplayed);
        softAssert.assertTrue(areErrorMessagesGermanDisplayed);
        softAssert.assertAll();
    }

}
