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
import java.util.List;

public class TestAddClubPopUp extends TestRuneWithAdmin {

    @BeforeMethod
    public void beforeMethodClubPopUp() {
        new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddClubButton()
                .fillInClubNameInput("Football")
                .clickOptionCheckboxes(2)
                .clickOptionCheckboxes(1)
                .fillInAgeFromInput("2")
                .fillInAgeToInput("18")
                .clickNextStepButton();
    }


    @DataProvider(name = "data173")
    public Object[][] dataProvider173() {
        Object[][] data = new Object[][]{
                {"testтестclubгуртокeducationосвітаfootball"},
                {"1234567890123456789012345678901234567890"},
                {"!\"#$%&'()*+,-./:;<=>?@[]^_`{}~123456789ЇD"},
        };
        return data;
    }

    @Test(dataProvider = "data173")
    public void verifySuccessIconDisplayedForValidNumberOfUkrainianEnglishLetters(String testCaseData) {
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
                .fillInBasicDescriptionInput(testCaseData)
                .isSuccessIconDisplayed();
        Assert.assertTrue(isSuccessIconDisplayed);
    }

//    @Test
//    public void verifySuccessIconDisplayedForValidNumberOfDigits() {
//        boolean isSuccessIconDisplayed = new HomePage(driver)
//                .header()
//                .clickUserProFileButton()
//                .clickSingInButton()
//                .sendKeysEmail(valueProvider.getAdminEmail())
//                .sendKeysPassword(valueProvider.getAdminPassword())
//                .clickLoginButton()
//                .header()
//                .clickUserProFileButton()
//                .clickAddClubButton()
//                .fillInClubNameInput("Dance")
//                .clickOptionCheckboxes(3)
//                .fillInAgeFromInput("6")
//                .fillInAgeToInput("21")
//                .clickNextStepButton()
//                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
//                .clickNextStepButton()
//                .fillInBasicDescriptionInput("1234567890123456789012345678901234567890")
//                .isSuccessIconDisplayed();
//        Assert.assertTrue(isSuccessIconDisplayed);
//    }
//
//    @Test
//    public void verifySuccessIconDisplayedForValidNumberOfSpecialCharacters() {
//        boolean isSuccessIconDisplayed = new HomePage(driver)
//                .header()
//                .clickUserProFileButton()
//                .clickSingInButton()
//                .sendKeysEmail(valueProvider.getAdminEmail())
//                .sendKeysPassword(valueProvider.getAdminPassword())
//                .clickLoginButton()
//                .header()
//                .clickUserProFileButton()
//                .clickAddClubButton()
//                .fillInClubNameInput("Theater")
//                .clickOptionCheckboxes(5)
//                .fillInAgeFromInput("10")
//                .fillInAgeToInput("22")
//                .clickNextStepButton()
//                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
//                .clickNextStepButton()
//                .fillInBasicDescriptionInput("!\"#$%&'()*+,-./:;<=>?@[]^_`{}~123456789ЇD")
//                .isSuccessIconDisplayed();
//        Assert.assertTrue(isSuccessIconDisplayed);
//    }

    private String listString(int size){
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= size; i++) {
            list.add("a");
        }
        return String.join("", list);
    }

    @Test
    @Description("[allure]  Is Extended Massage is displayed when add  same symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnterSameSymbols() {
        SoftAssert softAssert = new SoftAssert();
        var explanationLotSymbols = new Contacts(driver)
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton();

        boolean isDisplayedMassageWrite1500Symbols = explanationLotSymbols
                .fillInBasicDescriptionInput(listString(1500))
                .isSuccessIconDisplayed();
        explanationLotSymbols
                .clearDescriptionField();

        boolean isDisplayedMassageWrite1400Symbol = explanationLotSymbols
                .fillInBasicDescriptionInput(listString(1400))
                .isSuccessIconDisplayed();
        explanationLotSymbols
                .clearDescriptionField();

        String errorMassageWrite1501Symbols = explanationLotSymbols
                .fillInBasicDescriptionInput(listString(1501))
                .TextWrongDescriptionDownAlert();

        boolean IconErrorDisplayedWrite1501Symbols = explanationLotSymbols
                .issuccessIconErrorDisplayed();
        explanationLotSymbols
                .clearDescriptionField();

        String errorMassageWrite1550Symbols = explanationLotSymbols
                .fillInBasicDescriptionInput(listString(1550))
                .TextWrongDescriptionDownAlert();
        softAssert.assertEquals(errorMassageWrite1550Symbols, "Опис гуртка може містити від 40 до 1500 символів.");

        boolean IconErrorDisplayedWrite1550Symbols = explanationLotSymbols
                .issuccessIconErrorDisplayed();


        softAssert.assertTrue(isDisplayedMassageWrite1500Symbols, "is Displayed Massage Write 1500 Symbols");
        softAssert.assertTrue(isDisplayedMassageWrite1400Symbol, "is Displayed Massage Write 1400 Symbol");
        softAssert.assertEquals(errorMassageWrite1501Symbols, "Опис гуртка може містити від 40 до 1500 символів.", "error Massage Write 1501 Symbols");
        softAssert.assertTrue(IconErrorDisplayedWrite1501Symbols, "Error Displayed Write 1501 Symbols");
        softAssert.assertEquals(errorMassageWrite1550Symbols, "Опис гуртка може містити від 40 до 1500 символів.", "error Massage Write 1550 ymbols");
        softAssert.assertTrue(IconErrorDisplayedWrite1550Symbols, "Icon Error Displayed Write 1550 Symbols");
        softAssert.assertAll();
    }

    @Test()
    @Description("[allure] Not valid enter description ")
    @Issue("TUA-176")
    public void testNotValidEnterPhoneNumber() {
        String expected = "Некоректний опис гуртка";
        SoftAssert softAssert = new SoftAssert();

        Explanation explanation = new Contacts(driver).fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton();

        String[] dataArray = new String[]{"qwertyuiopasdfghjklk","q","qwertyuiopasdfghjkljzxcvbnmkmnbvczlkjhg"};

        for (int i = 0 ; i < dataArray.length; i++) {
            String errorMassage = explanation
                    .fillInBasicDescriptionInput(dataArray[i])
                    .getWrongDescriptionAlert();
            softAssert.assertEquals(errorMassage,expected);
            explanation.clearDescriptionField();
        }

        softAssert.assertAll();
    }
}
