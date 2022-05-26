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
   // private ValueProvider valueProvider;

    @Test
    @Description("[allure]  Is Extended AdvancedSearch If Is Opened")
    @Issue("TUA-103")
    public void enteredDataOnRegistrationPage() throws IOException {
//        if (valueProvider == null) {
//            valueProvider = new ValueProvider();
//        }
        SoftAssert softAssert = new SoftAssert();

        var registrationUser = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickRegistrationButton();
        boolean isDisplayedCorrectLastName = new MessageErrorRegistrationUser(driver)
                .clickRegistrationLastName()
                .registrationLastName("Світлана")
                .getMessageErrorRegistrationUser()
                .isCorrectFilledLastNameDisplayed();
        softAssert.assertTrue(isDisplayedCorrectLastName);

        boolean isDisplayedCorrectFirstName = new MessageErrorRegistrationUser(driver)
                .clickRegistrationFirstName()
                .registrationFirstName("Вайтович")
                .getMessageErrorRegistrationUser()
                .isCorrectFilledFirstNameDisplayed();
        softAssert.assertTrue(isDisplayedCorrectFirstName);

        boolean isDisplayedCorrectPhone = new MessageErrorRegistrationUser(driver)
                .clickRegistrationPhone()
                .registrationPhone("0671234567")
                .getMessageErrorRegistrationUser()
                .isCorrectFilledPhoneDisplayed();
        softAssert.assertTrue(isDisplayedCorrectPhone);

        boolean isDisplayedCorrectEmail = new MessageErrorRegistrationUser(driver)
                .clickRegistrationEmail()
                .registrationEmail("svitlanawhite@gmail.com")
                .getMessageErrorRegistrationUser()
                .isCorrectFilledEmailDisplayed();
        softAssert.assertTrue(isDisplayedCorrectEmail);

        boolean isDisplayedCorrectPassword = new MessageErrorRegistrationUser(driver)
                .clickRegistrationPassword()
                .registrationPassword("12345678wW@")
                .getMessageErrorRegistrationUser()
                .isCorrectFilledPasswordDisplayed();
        softAssert.assertTrue(isDisplayedCorrectPassword);

        boolean isDisplayedCorrectConfirm = new MessageErrorRegistrationUser(driver)
                .clickRegistrationConfirm()
                .registrationConfirm("12345678wW@")
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

        String ValuelastName = registrationUser.getFieldValuePage().getLastNameValue();
        System.out.println(ValuelastName);
        System.out.println(valueProvider.getRegistrationLastName());
        softAssert.assertEquals(ValuelastName, valueProvider.getRegistrationLastName());

        String ValueFirstName = registrationUser.getFieldValuePage().getFirstNameValue();
        softAssert.assertEquals(ValueFirstName, valueProvider.getRegistrationFirstName());

        String ValuePhone = registrationUser.getFieldValuePage().getPhoneValue();
        softAssert.assertEquals(ValuePhone, valueProvider.getRegistrationPhone());

        String ValueEmail = registrationUser.getFieldValuePage().getEmailValue();
        softAssert.assertEquals(ValueEmail, valueProvider.getRegistrationEmail());

        String ValuePassword = registrationUser.getFieldValuePage().getPasswordValue();
        softAssert.assertEquals(ValuePassword, valueProvider.getRegistrationPassword());

        String ValueConfirm = registrationUser.getFieldValuePage().getConfirmValue();
        softAssert.assertEquals(ValueConfirm, valueProvider.getRegistrationConfirm());


        softAssert.assertAll();


    }
}
