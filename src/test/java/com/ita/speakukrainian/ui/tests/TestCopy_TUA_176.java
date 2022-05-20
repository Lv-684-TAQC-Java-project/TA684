package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianLoginMainPageRunner;
import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.AddClubPages.Description1;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCopy_TUA_176 extends SpeakUkrainianLoginMainPageRunner {
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
        String errorMassage = new HomePage(driver)
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
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .getWrongDescriptionAlert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorMassage, expected);
        softAssert.assertAll();
        Description1 description = new Description1(driver);
        description.clickCloseMyProfile();
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);
        headerMenuComponent.cliHomePage();
    }
}
