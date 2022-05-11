package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestInputAgeAcceptsOnlyPositiveIntegersFrom2To18_210 extends SpeakUkrainianRunner {

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        Object[][] data = new Object[][]{
                {1, 2},
                {2, 2},
                {18, 18},
                {20, 18}
        };
        return data;
    }

    @Test(dataProvider = "data")
    public void verifyInputAcceptsPositiveIntegersFrom2To18(int age, int expected) {
        String actualAgeValue = new HomePage(driver)
                .header().clickExtendedSearchButton()
                .fillInAgeInput(age)
                .readAgeInput();



        Assert.assertEquals(Integer.valueOf(actualAgeValue), expected);
    }

}

