package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.pages.AddClubPages.Explanation;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClubDescription extends TestRuneWithAdmin {

    @Test
    @Description("[allure] Verify that error message appears when user enters letters" +
            " in Russian or German languages into the field")
    @Issue("TUA-178")
    public void verifyErrorMessageOnRussianAndGermanLettersInDescription() {
        final String clubName = "Football";
        final int checkboxDancingСhoreography = 2;
        final String ageFrom = "2";
        final String ageTo = "18";
        final String contactFaceboo = "Facebook";
        final String contactEmail = "mail@mail.com";
        final String contactWhatsUpp = "WhatsUpp";
        final String contactName = "Name";
        final String contactSkype = "Skype";
        final String contactPhoneNumber = "0675775031";
        final String russianCharacter = "Жэк Мэр Нэп Пэр СэрЖэк Мэр Нэп Пэр СэрЖэк Мэр Нэп Пэр Сэр";
        final String germanCharacter = "Pax-Gebäude Pax-Gebäude Pax-Gebäude Pax-Gebäude Pax-Gebäude";

        final String expectedErrorMessageRussianText = "Опис гуртка не може містити російські літери";
        final String expectedErrorMessageGermanText = "Некоректний опис гуртка";

        SoftAssert softAssert = new SoftAssert();
        Explanation explanation = new Explanation(driver);

        String actualErrorMessageRussianText = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickAddClubButton()
                .fillInClubNameInput(clubName)
                .clickOptionCheckboxes(checkboxDancingСhoreography)
                .fillInAgeFromInput(ageFrom)
                .fillInAgeToInput(ageTo)
                .clickNextStepButton()
                .fillInContactFacebookInput(contactFaceboo)
                .fillInContactMailInput(contactEmail)
                .fillInContactWhatsAppInput(contactWhatsUpp)
                .fillInContactInput(contactName)
                .fillInContactSkypeInput(contactSkype)
                .fillInContactPhoneInput(contactPhoneNumber)
                .clickNextStepButton()
                .fillInBasicDescriptionInput(russianCharacter)
                .getActualErrorMessage();

        explanation
                .clearDescriptionField();

        String actualErrorMessageGermanText = explanation
                .fillInBasicDescriptionInput(germanCharacter)
                .getActualErrorMessage();

        softAssert.assertEquals(actualErrorMessageRussianText, expectedErrorMessageRussianText);
        softAssert.assertEquals(actualErrorMessageGermanText, expectedErrorMessageGermanText);
        softAssert.assertAll();
    }

}
