package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestSingInPopupPopUp extends SpeakUkrainianRunner {

    @Test
    public void testActualPage() {
        System.out.println("Check pageURL");
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        softAssert.assertEquals(valueProvider.getBaseURL(), homePage.getCurrentUrl(), "current path");
        softAssert.assertEquals("Ініціатива “Навчай українською”", homePage.getTitle(), "title");
        softAssert.assertAll();
    }

    @Test
    public void CheckLoginAbility() {
        String avatarSCR = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
//                .singIn(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .getAvatarImgPath();
        Assert.assertEquals(avatarSCR, "https://speak-ukrainian.org.ua/dev/static/images/user/avatar/user1.png");
    }

}
