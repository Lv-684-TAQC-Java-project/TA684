package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.pages.ExtendedSearchComponent;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.testruners.BaseTestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestMainSearchField extends BaseTestRunner {

    @Test
    @Description("[allure] Verify search field behavior for invalid number of symbols entered")
    @Issue("TUA-428")

    public void verifySearchFieldBehaviorForInvalidNumberOfsSymbolsEntered() {


        final String value1Symbol = RandomStringUtils.randomAlphabetic(1);
        final String value50Symbol = RandomStringUtils.randomAlphabetic(50);
        final String value60Symbol = RandomStringUtils.randomAlphabetic(60);

        final String text50 = "Ми поставили перед собою ціль створити мережу найк";

        ExtendedSearchComponent extendedSearchComponent = new ExtendedSearchComponent(driver);
        SoftAssert softAssert = new SoftAssert();

        boolean resultOfSearchWith1Symbol = new HomePage(driver)
                .header()
                .clickExtendedSearchButton()
                .getExtendedSearchComponent()
                .fillInMainSearchField(text50)
                .clickDataIconSearch()
                .verifyCardsHasText(text50);

        extendedSearchComponent.clearMainSearchField();

        boolean isClubsNotFoundMessageDisplayed = extendedSearchComponent
                .fillInMainSearchField(value50Symbol)
                .clickDataIconSearch()
                .isClubsNotFoundMessageDisplayed();

        extendedSearchComponent.clearMainSearchField();

        int numberOfCharacters = extendedSearchComponent
                .fillInMainSearchField(value60Symbol)
                .clickDataIconSearch()
                .readMainSearchField();

        extendedSearchComponent.clearMainSearchField();

        boolean isClubsNotFoundMessageDisplayed60Symbols = extendedSearchComponent
                .fillInMainSearchField(value60Symbol)
                .clickDataIconSearch()
                .isClubsNotFoundMessageDisplayed();

        extendedSearchComponent.clearMainSearchField();

        boolean resultOfSearchWith1SymbolPaste = extendedSearchComponent
                .copyText(text50)
                .clickMainSearchField()
                .controlPlusV()
                .clickDataIconSearch()
                .verifyCardsHasText(text50);

        extendedSearchComponent.clearMainSearchField();

        boolean isClubsNotFoundMessageDisplayed60SymbolsPaste = extendedSearchComponent
                .copyText(value60Symbol)
                .clickMainSearchField()
                .controlPlusV()
                .clickDataIconSearch()
                .isClubsNotFoundMessageDisplayed();

        softAssert.assertTrue(resultOfSearchWith1Symbol);
        softAssert.assertTrue(isClubsNotFoundMessageDisplayed);
        softAssert.assertEquals(numberOfCharacters, 50);
        softAssert.assertTrue(isClubsNotFoundMessageDisplayed60Symbols);
        softAssert.assertTrue(resultOfSearchWith1SymbolPaste);
        softAssert.assertTrue(isClubsNotFoundMessageDisplayed60SymbolsPaste);
        softAssert.assertAll();

    }

}
