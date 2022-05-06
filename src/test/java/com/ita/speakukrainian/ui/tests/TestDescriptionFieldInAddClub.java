package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestDescriptionFieldInAddClub extends SpeakUkrainianRunner {

   @DataProvider(name = "data")
    public Object[][] dataProvider(){
       Object[][] data = new Object[][]{
               {"qwertyuiopasdfghjklk", "Некоректний опис гуртка"},
               {"q", "Некоректний опис гуртка"},
               {"qwertyuiopasdfghjkljzxcvbnmkmnbvczlkjhg", "Некоректний опис гуртка"},
       };
       return data;
   }


    @Test(dataProvider = "data")
    public void testNotValidEnterPhoneNumber(String testCaseValue , String expected) {
        String errorMassage = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddClubButton()
                .fillNameField("Best club")
                .clickCategory()
                .fillAgeField(2,16)
                .clickNextStepFirstStageButton()
                .fillPhoneField(valueProvider.getPhoneNumber())
                .clickNextStepSecondStageButton()
                .fillDescriptionField(testCaseValue)
                .getWrongDescriptionAlert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorMassage,expected);
    }
}
