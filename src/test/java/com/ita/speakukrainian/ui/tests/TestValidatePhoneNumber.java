package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.EditProfilePage;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestValidatePhoneNumber extends SpeakUkrainianRunner {

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
            public void testNotValidEnterPhoneNumber(String testCase1Value , String expected) {
        String myProfile = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickMyProfileButton()
                .clickEditProfileButton()
                .sendKeysPhoneField(testCase1Value)
                .getError();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(myProfile,expected);
    }

    @Test
    public void testIsDisplayedSaveButton() {
        boolean myProfile = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickMyProfileButton()
                .clickEditProfileButton()
                .clearPhoneField()
                .isDisplayedSaveButton();
        Assert.assertEquals(myProfile,false);
    }
}
