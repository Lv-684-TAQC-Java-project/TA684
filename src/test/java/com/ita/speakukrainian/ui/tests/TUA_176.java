package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianLoginMainPageRunner;
import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.AddClubPages.Explanation;
import com.ita.speakukrainian.ui.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TUA_176 extends SpeakUkrainianLoginMainPageRunner {
    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        Object[][] data = new Object[][]{
                {"qwertyuiopasdfghjklk", "Некоректний опис гуртка"},
                {"q", "Некоректний опис гуртка"},
                {"qwertyuiopasdfghjkljzxcvbnmkmnbvczlkjhg", "Некоректний опис гуртка"},
        };
        return data;
    }


    @Test(dataProvider = "data")
    @Description("[allure] Not valid enter phone number ")
    @Issue("TUA-224")
    public void testNotValidEnterPhoneNumber(String testCaseValue, String expected) {
        String errorMassage = new Explanation(driver)
                .fillInBasicDescriptionInput(testCaseValue)
                .getWrongDescriptionAlert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorMassage, expected);
        softAssert.assertAll();
    }
}


