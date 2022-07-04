package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.testruners.BaseTestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestRegistrationPage454 extends BaseTestRunner {
    private static final String lastNameRegistrationUser = "Світлана";
    private static final String firstNameRegistrationUser = "Вайтович";
    private static final String phoneRegistrationUser = "0671234567";
    private static final String emailRegistrationUser = "svitlanawhite@gmail.com";
    private static final String passwordRegistrationUser = "12345678wW@";
    private static final String confirmRegistrationUser = "12345678wW@";


    @Test
    @Description("[allure]  Is Extended Registration New User")
    @Issue("TUA-454")
    public void enteredDataOnRegistrationPage() {

        SoftAssert softAssert = new SoftAssert();

        var registrationUser = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickRegistrationButton();
        boolean isDisplayedCorrectLastName = registrationUser
                .clickRegistrationLastName()
                .registrationLastName(lastNameRegistrationUser)
                .getMessageErrorRegistrationUser()
                .isCorrectFilledLastNameDisplayed();
        softAssert.assertTrue(isDisplayedCorrectLastName);

        boolean isDisplayedCorrectFirstName = registrationUser
                .clickRegistrationFirstName()
                .registrationFirstName(firstNameRegistrationUser)
                .getMessageErrorRegistrationUser()
                .isCorrectFilledFirstNameDisplayed();
        softAssert.assertTrue(isDisplayedCorrectFirstName);

        boolean isDisplayedCorrectPhone = registrationUser
                .clickRegistrationPhone()
                .registrationPhone(phoneRegistrationUser)
                .getMessageErrorRegistrationUser()
                .isCorrectFilledPhoneDisplayed();
        softAssert.assertTrue(isDisplayedCorrectPhone);

        boolean isDisplayedCorrectEmail = registrationUser
                .clickRegistrationEmail()
                .registrationEmail(emailRegistrationUser)
                .getMessageErrorRegistrationUser()
                .isCorrectFilledEmailDisplayed();
        softAssert.assertTrue(isDisplayedCorrectEmail);

        boolean isDisplayedCorrectPassword = registrationUser
                .clickRegistrationPassword()
                .registrationPassword(passwordRegistrationUser)
                .getMessageErrorRegistrationUser()
                .isCorrectFilledPasswordDisplayed();
        softAssert.assertTrue(isDisplayedCorrectPassword);

        boolean isDisplayedCorrectConfirm = registrationUser
                .clickRegistrationConfirm()
                .registrationConfirm(confirmRegistrationUser)
                .getMessageErrorRegistrationUser()
                .isCorrectFilledConfirmDisplayed();
        softAssert.assertTrue(isDisplayedCorrectConfirm);

        boolean DisplayedRegistrationPage = registrationUser
                .closeRegistrationPage()
                .isRegistrationPageDisplayed();
        softAssert.assertFalse(DisplayedRegistrationPage);

        boolean DisplayedRegistrationPage2 = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickRegistrationButton()
                .getHomePageinRegistrationPage()
                .isRegistrationPageDisplayed();
        softAssert.assertTrue(DisplayedRegistrationPage2);

        String ValueLastName = registrationUser.getFieldValuePage().getLastNameValue();
        softAssert.assertEquals(ValueLastName, lastNameRegistrationUser);

        String ValueFirstName = registrationUser.getFieldValuePage().getFirstNameValue();
        softAssert.assertEquals(ValueFirstName, firstNameRegistrationUser);

        String ValuePhone = registrationUser.getFieldValuePage().getPhoneValue();
        softAssert.assertEquals(ValuePhone, phoneRegistrationUser);

        String ValueEmail = registrationUser.getFieldValuePage().getEmailValue();
        softAssert.assertEquals(ValueEmail, emailRegistrationUser);

        String ValuePassword = registrationUser.getFieldValuePage().getPasswordValue();
        softAssert.assertEquals(ValuePassword, passwordRegistrationUser);

        String ValueConfirm = registrationUser.getFieldValuePage().getConfirmValue();
        softAssert.assertEquals(ValueConfirm, confirmRegistrationUser);


        softAssert.assertAll();


    }
}
