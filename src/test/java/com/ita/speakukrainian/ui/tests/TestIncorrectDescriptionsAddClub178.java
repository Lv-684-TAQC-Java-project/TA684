package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.RunnerForTUA_178;
import com.ita.speakukrainian.ui.pages.AddClubPages.Explanation;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestIncorrectDescriptionsAddClub178 extends RunnerForTUA_178 {

    List<String> expectedErrorMessagesRusLetter = Arrays.asList("Некоректний опис гуртка",
            "Опис гуртка може містити від 40 до 1500 символів.", "Опис гуртка не може містити російські літери");

    List<String> expectedErrorMessagesGerLetter = Arrays.asList("Некоректний опис гуртка",
            "Опис гуртка може містити від 40 до 1500 символів.");

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        Object[][] data = new Object[][]{
                {"ъ", expectedErrorMessagesRusLetter},
                {"öl", expectedErrorMessagesGerLetter}
        };
        return data;
    }

    @Test(dataProvider = "data")
    @Description("Verify Error Message On Russian And German Letters In Description")
    @Issue("TUA-178")
    public void verifyErrorMessageOnRussianAndGermanLettersInDescription(String text, List<String> expectedErrorMessages) {
        boolean areErrorMessageDisplayed = new Explanation(driver)
                .fillInBasicDescriptionInput(text)
                .areErrorMessagesDisplayed(expectedErrorMessages);

        Assert.assertTrue(areErrorMessageDisplayed);
    }
}
