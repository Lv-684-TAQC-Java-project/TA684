package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.EditProfilePage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestEditProfilePopUp extends TestRuneWithAdmin {

    @BeforeMethod
    public void beforeClassEditProfilePopUp() {
        new HeaderMenuComponent(driver)
                .clickUserProFileButton()
                .clickMyProfileButton()
                .clickEditProfileButton();
    }

    @Test(priority = 1)
    @Description("[allure] Not valid enter phone number")
    @Issue("TUA-356")
    public void testNotValidEnterPhoneNumber() {
        SoftAssert softAssert = new SoftAssert();
        String[] testValue = new String[]{"06895","065987458","06593859632586","06598521475","jngeoлщшогнеп","!@#$%^&*(_+.:"};
        String expected = "Телефон не відповідає вказаному формату";
        String expected2 = "Будь ласка введіть Ваш номер телефону";
        String error ;
        EditProfilePage editProfilePage = new EditProfilePage(driver).clearPhoneField();

        for ( int i = 0 ; i< testValue.length;i++) {
            error = editProfilePage
                    .clearPhoneField()
                    .sendKeysPhoneField(testValue[i])
                    .getErrorWrongNumber();
            softAssert.assertEquals(error, expected);
        }

        error = editProfilePage
                .clearPhoneField()
                .getEnterAnyNumberAlert();
        Assert.assertEquals(error, expected2);
    }

    @Test(priority = 3)
    @Description("Verify that error messages are shown while leaving empty any field in the 'Змінити пароль' pop-up")
    @Issue("TUA-359")
    public void testVerifyPasswordField() {
        EditProfilePage editProfilePage = new EditProfilePage(driver).clickChangePasswordCheckbox().clickSubmitButton();

        String error1 = editProfilePage
                .getConfirmYourPasswordAlert();
        Assert.assertEquals(error1, "Будь ласка, підтвердіть пароль");

        String error2 = editProfilePage
                .getNewPasswordAlert();
        Assert.assertEquals(error2, "Будь ласка, введіть новий пароль");

        String error3 =  editProfilePage
                .getCurrentPasswordAlert();
        Assert.assertEquals(error3, "Введіть старий пароль");
    }
}
