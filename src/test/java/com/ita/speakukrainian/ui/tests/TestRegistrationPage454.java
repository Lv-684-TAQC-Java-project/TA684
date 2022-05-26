package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.RegistrationPages.MessageErrorRegistrationUser;
import com.ita.speakukrainian.ui.pages.RegistrationPages.RegistrationPage;
import com.ita.speakukrainian.ui.testruners.BaseTestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestRegistrationPage454 extends BaseTestRunner {

    @Test
    @Description("[allure]  Is Extended Registration New User")
    @Issue("TUA-454")
    public void enteredDataOnRegistrationPage() throws IOException {

        String lastName, firstName, phone, email, password, confirm;
        SoftAssert softAssert = new SoftAssert();

        var registrationUser = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickRegistrationButton();
        boolean isDisplayedCorrectLastName = new MessageErrorRegistrationUser(driver)
                .clickRegistrationLastName()
                .registrationLastName(lastName = "Світлана")
                .getMessageErrorRegistrationUser()
                .isCorrectFilledLastNameDisplayed();
        softAssert.assertTrue(isDisplayedCorrectLastName);

        boolean isDisplayedCorrectFirstName = new MessageErrorRegistrationUser(driver)
                .clickRegistrationFirstName()
                .registrationFirstName(firstName = "Вайтович")
                .getMessageErrorRegistrationUser()
                .isCorrectFilledFirstNameDisplayed();
        softAssert.assertTrue(isDisplayedCorrectFirstName);

        boolean isDisplayedCorrectPhone = new MessageErrorRegistrationUser(driver)
                .clickRegistrationPhone()
                .registrationPhone(phone = "0671234567")
                .getMessageErrorRegistrationUser()
                .isCorrectFilledPhoneDisplayed();
        softAssert.assertTrue(isDisplayedCorrectPhone);

        boolean isDisplayedCorrectEmail = new MessageErrorRegistrationUser(driver)
                .clickRegistrationEmail()
                .registrationEmail(email = "svitlanawhite@gmail.com")
                .getMessageErrorRegistrationUser()
                .isCorrectFilledEmailDisplayed();
        softAssert.assertTrue(isDisplayedCorrectEmail);

        boolean isDisplayedCorrectPassword = new MessageErrorRegistrationUser(driver)
                .clickRegistrationPassword()
                .registrationPassword(password = "12345678wW@")
                .getMessageErrorRegistrationUser()
                .isCorrectFilledPasswordDisplayed();
        softAssert.assertTrue(isDisplayedCorrectPassword);

        boolean isDisplayedCorrectConfirm = new MessageErrorRegistrationUser(driver)
                .clickRegistrationConfirm()
                .registrationConfirm(confirm = "12345678wW@")
                .getMessageErrorRegistrationUser()
                .isCorrectFilledConfirmDisplayed();
        softAssert.assertTrue(isDisplayedCorrectConfirm);

        boolean DisplayedRegistrationPage = new RegistrationPage(driver)
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
        System.out.println(ValueLastName);
        System.out.println(valueProvider.getRegistrationLastName());
        softAssert.assertEquals(ValueLastName, lastName);

        String ValueFirstName = registrationUser.getFieldValuePage().getFirstNameValue();
        softAssert.assertEquals(ValueFirstName, firstName);

        String ValuePhone = registrationUser.getFieldValuePage().getPhoneValue();
        softAssert.assertEquals(ValuePhone, phone);

        String ValueEmail = registrationUser.getFieldValuePage().getEmailValue();
        softAssert.assertEquals(ValueEmail, email);

        String ValuePassword = registrationUser.getFieldValuePage().getPasswordValue();
        softAssert.assertEquals(ValuePassword, password);

        String ValueConfirm = registrationUser.getFieldValuePage().getConfirmValue();
        softAssert.assertEquals(ValueConfirm, confirm);


        softAssert.assertAll();


    }
}
