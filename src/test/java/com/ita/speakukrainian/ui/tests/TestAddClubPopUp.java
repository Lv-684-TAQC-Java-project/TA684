package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.pages.AddClubPages.Contacts;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAddClubPopUp extends TestRuneWithAdmin {

    @BeforeClass
    public void beforeClassClubPopUp() {
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

    private String listString(int size){
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= size; i++) {
            list.add("a");
        }
        System.out.println(list.size());
        return String.join("", list);

    }

    @DataProvider(name = "data1500Symbols")
    public Object[][] dataProvider1500Symbols() {
        int symbols = 1500;
        Object[][] data = new Object[][]{
                {listString(symbols)},
        };
        return data;
    }

    @Test(dataProvider = "data1500Symbols")
    @Description("[allure]  Is Extended Massage is displayed whan add  1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1500Symbols(String testCaseValue) {
        boolean isDisplayedMassage =new Contacts(driver)
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .isSuccessIconDisplayed();

        Assert.assertTrue(isDisplayedMassage);

    }

    @DataProvider(name = "dataLess1500Symbols")
    public Object[][] dataProviderLess1500Symbols() {
        int symbols = 1400;
        Object[][] data = new Object[][]{
                {listString(symbols)},
        };
        return data;
    }

    @Test(dataProvider = "dataLess1500Symbols")
    @Description("[allure]  Is Extended Massage is displayed whan add less 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnterLess1500Symbols(String testCaseValue) {
        boolean isDisplayedMassage =new Contacts(driver)
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .isSuccessIconDisplayed();

        Assert.assertTrue(isDisplayedMassage);

    }

    @DataProvider(name = "data1501symbols")
    public Object[][] dataProvider1501symbols() {
        int symbols = 1501;

        Object[][] data = new Object[][]{
                {listString(symbols)},
        };
        return data;
    }

    @Test(dataProvider = "data1501symbols")
    @Description("[allure]  Is Extended errorMassage whan add more 1501 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1501Symbols(String testCaseValue) {
        String errorMassage = new Contacts(driver)
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .TextWrongDescriptionDownAlert();
        Assert.assertEquals(errorMassage, "Опис гуртка може містити від 40 до 1500 символів.");


    }

    @Test(dataProvider = "data1501symbols")
    @Description("[allure]  Is Extended errorMassage is displayed whan add more 1501 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1501Symbols2(String testCaseValue) {
        Boolean IconErrorDisplayed =new Contacts(driver)
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .issuccessIconErrorDisplayed();
        Assert.assertTrue(IconErrorDisplayed);


    }

    @DataProvider(name = "dataMore1500symbols")
    public Object[][] dataProviderMore1500symbols() {
        int symbols = 1550;

        Object[][] data = new Object[][]{
                {listString(symbols)},
        };
        return data;
    }

    @Test(dataProvider = "dataMore1500symbols")
    @Description("[allure]  Is Extended errorMassage  whan add more 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnterMore1500Symbols(String testCaseValue) {
        String errorMassage = new Contacts(driver)
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .TextWrongDescriptionDownAlert();
        Assert.assertEquals(errorMassage, "Опис гуртка може містити від 40 до 1500 символів.");
    }

    @Test(dataProvider = "dataMore1500symbols")
    @Description("[allure]  Is Extended errorMassage is displayed whan add more 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnterMore1500Symbols2(String testCaseValue) {
        Boolean IconErrorDisplayed =new Contacts(driver)
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .issuccessIconErrorDisplayed();
        Assert.assertTrue(IconErrorDisplayed);
    }

    List<String> expectedErrorMessagesRusLetter = Arrays.asList("Некоректний опис гуртка",
            "Опис гуртка може містити від 40 до 1500 символів.", "Опис гуртка не може містити російські літери");

    List<String> expectedErrorMessagesGerLetter = Arrays.asList("Некоректний опис гуртка",
            "Опис гуртка може містити від 40 до 1500 символів.");

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        Object[][] data = new Object[][]{
                {"ъ", expectedErrorMessagesRusLetter},
                {"öl", expectedErrorMessagesGerLetter}
        };
        return data;
    }

    @Test(dataProvider = "data")
    @io.qameta.allure.Description("Verify Error Message On Russian And German Letters In Description")
    @Issue("TUA-178")
    public void verifyErrorMessageOnRussianAndGermanLettersInDescription(String text, List<String> expectedErrorMessages) {
        boolean areErrorMessageDisplayed = new Contacts(driver)
                .fillInContactFacebookInput(valueProvider.getContactFacebook())
                .fillInContactMailInput(valueProvider.getContactEmail())
                .fillInContactWhatsAppInput(valueProvider.getContactWhatsUpp())
                .fillInContactInput(valueProvider.getContactName())
                .fillInContactSkypeInput(valueProvider.getContactSkype())
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(text)
                .areErrorMessagesDisplayed(expectedErrorMessages);

        Assert.assertTrue(areErrorMessageDisplayed);
    }

    @DataProvider(name = "dataAnton")
    public Object[][] dataProvider1() {
        Object[][] data = new Object[][]{
                {"qwertyuiopasdfghjklk", "Некоректний опис гуртка"},
                {"q", "Некоректний опис гуртка"},
                {"qwertyuiopasdfghjkljzxcvbnmkmnbvczlkjhg", "Некоректний опис гуртка"},
        };
        return data;
    }


    @Test(dataProvider = "dataAnton")
    @Description("[allure] Not valid enter phone number ")
    @Issue("TUA-224")
    public void testNotValidEnterPhoneNumber(String testCaseValue, String expected) {
        String errorMassage = new Contacts(driver)
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .getWrongDescriptionAlert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorMassage, expected);
        softAssert.assertAll();
    }
}
