package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.testruners.BaseTestRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIncorrectNameOfCenter252 extends BaseTestRunner {


    @Test
    public void CheckErrorMessage() {
        String incorrectCenterName = new HomePage(driver)
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
                .clickAddCenterButton()
                .clickNextStepButton()
                .getError();
        Assert.assertEquals(incorrectCenterName, "Некоректна назва центру");
    }
}
