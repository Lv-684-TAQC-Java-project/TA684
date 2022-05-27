package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.EditProfilePage;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import jdk.jfr.Name;
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

    @DataProvider(name = "data1")
    public Object[][] SmallestCombine() {
        Object[][] data = new Object[][]{
                {"06895", "Телефон не відповідає вказаному формату"},
                {"065987458", "Телефон не відповідає вказаному формату"},
                {"06593859632586", "Телефон не відповідає вказаному формату"},
                {"06598521475", "Телефон не відповідає вказаному формату"},
                {"jngeoлщшогнеп", "Телефон не відповідає вказаному формату"},
                {"!@#$%^&*(_+.:", "Телефон не відповідає вказаному формату"}
        };
        return data;
    }

    @Test(dataProvider = "data1",priority = 1)
    @Description("[allure] Not valid enter phone number")
    @Issue("TUA-356")
    public void testNotValidEnterPhoneNumber(String testCase1Value, String expected) {
        String error = new EditProfilePage(driver)
                .clearPhoneField()
                .sendKeysPhoneField(testCase1Value)
                .getErrorWrongNumber();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(error, expected);
    }

    @Test(priority = 2)
    @Description("[allure] Not valid enter phone number")
    @Issue("TUA-356")
    public void testIsDisplayedSaveButton() {
        String error = new EditProfilePage(driver)
                .clearPhoneField()
                .getEnterAnyNumberAlert();
        Assert.assertEquals(error, "Будь ласка введіть Ваш номер телефону");
    }



    @Test(priority = 3)
    @Description("Verify that error messages are shown while leaving empty any field in the 'Змінити пароль' pop-up")
    @Issue("TUA-359")
    public void testConfirmYourPasswordField() {
        String error = new EditProfilePage(driver)
                .clickChangePasswordCheckbox()
                .sendKeysCurrentPasswordField("123456")
                .sendKeysNewPasswordField("123456Qq@")
                .clickSubmitButton()
                .getConfirmYourPasswordAlert();
        Assert.assertEquals(error, "Будь ласка, підтвердіть пароль");
    }

    @Test(priority = 4)
    @Description("Verify that error messages are shown while leaving empty any field in the 'Змінити пароль' pop-up")
    @Issue("TUA-359")
    public void testNewPasswordField() {
        String error = new EditProfilePage(driver)
                .clickChangePasswordCheckbox()
                .clickSubmitButton()
                .getNewPasswordAlert();
        Assert.assertEquals(error, "Будь ласка, введіть новий пароль");
    }

    @Test(priority = 5)
    @Description("Verify that error messages are shown while leaving empty any field in the 'Змінити пароль' pop-up")
    @Issue("TUA-359")
    public void testCurrentPasswordField() {
        String error = new EditProfilePage(driver)
                .clickChangePasswordCheckbox()
                .clickSubmitButton()
                .getCurrentPasswordAlert();
        Assert.assertEquals(error, "Введіть старий пароль");
    }

}
