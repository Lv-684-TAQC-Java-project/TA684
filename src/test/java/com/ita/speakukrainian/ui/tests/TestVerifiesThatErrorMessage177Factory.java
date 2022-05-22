package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.Runner177Factory;
import com.ita.speakukrainian.ui.pages.AddClubPages.MainInformation;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestVerifiesThatErrorMessage177Factory extends Runner177Factory {

    private final String param;
    public TestVerifiesThatErrorMessage177Factory(String param) {
        this.param = param;
    }

    @Test
    @Description("[allure]  Is Extended Massage is displayed when add 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1500Symbols() {
        boolean isDisplayedMassage = new com.ita.speakukrainian.ui.pages.AddClubPages.Description(driver)
                .fillInBasicDescriptionInput(param.substring(0, 1500))
                .isSuccessIconDisplayed();
        Assert.assertTrue(isDisplayedMassage);
    }

    @Test
    @Description("[allure]  Is Extended Massage is displayed when add less 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1400Symbols() {
        boolean isDisplayedMassage = new com.ita.speakukrainian.ui.pages.AddClubPages.Description(driver)
                .fillInBasicDescriptionInput(param.substring(0, 1400))
                .isSuccessIconDisplayed();
        Assert.assertTrue(isDisplayedMassage);
    }

    @Test
    @Description("[allure]  Is Extended errorMassage when add 1501 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1501Symbols() {
        String errorMassage = new com.ita.speakukrainian.ui.pages.AddClubPages.Description(driver)
                .fillInBasicDescriptionInput(param.substring(0, 1501))
                .TextWrongDescriptionDownAlert();
        Assert.assertEquals(errorMassage, "Опис гуртка може містити від 40 до 1500 символів.");
    }

    @Test
    @Description("[allure]  Is Extended errorMassage is displayed when add 1501 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1501Symbols2() {
        Boolean IconErrorDisplayed = new com.ita.speakukrainian.ui.pages.AddClubPages.Description(driver)
                .fillInBasicDescriptionInput(param.substring(0, 1501))
                .issuccessIconErrorDisplayed();
        Assert.assertTrue(IconErrorDisplayed);
    }

    @Test
    @Description("[allure]  Is Extended errorMassage  when add more than 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnterMoreThan1500Symbols() {
         String errorMassage = new com.ita.speakukrainian.ui.pages.AddClubPages.Description(driver)
                .fillInBasicDescriptionInput(param)
                .TextWrongDescriptionDownAlert();
        Assert.assertEquals(errorMassage, "Опис гуртка може містити від 40 до 1500 символів.");
    }

    @Test
    @Description("[allure]  Is Extended errorMassage is displayed when add more 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnterMoreThan1500Symbols2() {
        Boolean IconErrorDisplayed = new com.ita.speakukrainian.ui.pages.AddClubPages.Description(driver)
                .fillInBasicDescriptionInput(param)
                .issuccessIconErrorDisplayed();
        Assert.assertTrue(IconErrorDisplayed);
    }
}
