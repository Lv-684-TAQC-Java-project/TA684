package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.EditProfileRunner;
import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.EditProfilePage;
import com.ita.speakukrainian.ui.pages.HomePage;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TUA_356 extends EditProfileRunner {

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

    @Test(dataProvider = "data1")
    @Description("[allure] Not valid enter phone number")
    @Issue("TUA-356")
    public void testNotValidEnterPhoneNumber(String testCase1Value, String expected) {
        String error = new EditProfilePage(driver)
                .sendKeysPhoneField(testCase1Value)
                .getErrorWrongNumber();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(error, expected);
    }

    @Test
    @Description("[allure] Not valid enter phone number")
    @Issue("TUA-356")
    public void testIsDisplayedSaveButton() {
        String error = new EditProfilePage(driver)
                .getEnterAnyNumberAlert();
        Assert.assertEquals(error, "Будь ласка введіть Ваш номер телефону");
    }
}
