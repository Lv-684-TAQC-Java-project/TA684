package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.testruners.RunnerForTUA_210;

import com.ita.speakukrainian.ui.pages.ClubsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestInputAgeAcceptsOnlyPositiveIntegersFrom2To18_210 extends RunnerForTUA_210 {

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
    @Description("Verify Input Accepts Positive Integers From 2 To 18")
    @Issue("TUA-210")
    public void verifyInputAcceptsPositiveIntegersFrom2To18(int age, int expected) {
        String actualAgeValue = new ClubsPage(driver)
                .fillInAgeInput(age)
                .readAgeInput();

            int actual = Integer.parseInt(String.valueOf(actualAgeValue));

        Assert.assertEquals(actual, expected);
    }

}

