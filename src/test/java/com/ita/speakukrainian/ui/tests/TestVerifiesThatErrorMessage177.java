package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.AddClubInMyProfileExplanationStageRunner;
import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.AddClubPages.Explanation;
import com.ita.speakukrainian.ui.pages.HomePage;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;



public class TestVerifiesThatErrorMessage177 extends AddClubInMyProfileExplanationStageRunner {


    private String listString(int size){
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= size; i++) {
            list.add("a");
        }
        System.out.println(list.size());
        return String.join("", list);

    }

    @DataProvider(name = "data1500Symbols")
    public Object[][] dataProvider1500Symbols() {
        int symbols = 1500;
        Object[][] data = new Object[][]{
                {listString(symbols)},
        };
        return data;
    }

    @Test(dataProvider = "data1500Symbols")
    @Description("[allure]  Is Extended Massage is displayed whan add  1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1500Symbols(String testCaseValue) {
        boolean isDisplayedMassage =new Explanation(driver)
                .fillInBasicDescriptionInput(testCaseValue)
                .isSuccessIconDisplayed();

        Assert.assertTrue(isDisplayedMassage);

    }

    @DataProvider(name = "dataLess1500Symbols")
    public Object[][] dataProviderLess1500Symbols() {
        int symbols = 1400;
        Object[][] data = new Object[][]{
                {listString(symbols)},
        };
        return data;
    }

    @Test(dataProvider = "dataLess1500Symbols")
    @Description("[allure]  Is Extended Massage is displayed whan add less 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnterLess1500Symbols(String testCaseValue) {
        boolean isDisplayedMassage =new Explanation(driver)
                .fillInBasicDescriptionInput(testCaseValue)
                .isSuccessIconDisplayed();

        Assert.assertTrue(isDisplayedMassage);

    }

    @DataProvider(name = "data1501symbols")
    public Object[][] dataProvider1501symbols() {
        int symbols = 1501;

        Object[][] data = new Object[][]{
                {listString(symbols)},
        };
        return data;
    }

    @Test(dataProvider = "data1501symbols")
    @Description("[allure]  Is Extended errorMassage whan add more 1501 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1501Symbols(String testCaseValue) {
        String errorMassage = new Explanation(driver)
                .fillInBasicDescriptionInput(testCaseValue)
                .TextWrongDescriptionDownAlert();
        Assert.assertEquals(errorMassage, "Опис гуртка може містити від 40 до 1500 символів.");


    }

    @Test(dataProvider = "data1501symbols")
    @Description("[allure]  Is Extended errorMassage is displayed whan add more 1501 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1501Symbols2(String testCaseValue) {
        Boolean IconErrorDisplayed =new Explanation(driver)
                .fillInBasicDescriptionInput(testCaseValue)
                .issuccessIconErrorDisplayed();
        Assert.assertTrue(IconErrorDisplayed);


    }

    @DataProvider(name = "dataMore1500symbols")
    public Object[][] dataProviderMore1500symbols() {
        int symbols = 1550;

        Object[][] data = new Object[][]{
                {listString(symbols)},
        };
        return data;
    }

    @Test(dataProvider = "dataMore1500symbols")
    @Description("[allure]  Is Extended errorMassage  whan add more 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnterMore1500Symbols(String testCaseValue) {
        String errorMassage = new Explanation(driver)
                .fillInBasicDescriptionInput(testCaseValue)
                .TextWrongDescriptionDownAlert();
        Assert.assertEquals(errorMassage, "Опис гуртка може містити від 40 до 1500 символів.");
    }

    @Test(dataProvider = "dataMore1500symbols")
    @Description("[allure]  Is Extended errorMassage is displayed whan add more 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnterMore1500Symbols2(String testCaseValue) {
        Boolean IconErrorDisplayed =new Explanation(driver)
                .fillInBasicDescriptionInput(testCaseValue)
                .issuccessIconErrorDisplayed();
        Assert.assertTrue(IconErrorDisplayed);
    }
}
