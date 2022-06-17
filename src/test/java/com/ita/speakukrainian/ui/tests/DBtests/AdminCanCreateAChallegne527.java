package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.pages.ChallengesPages.AddChallengePage;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdminCanCreateAChallegne527 extends TestRuneWithAdmin {
    String expected = """
            lhkmpmnpit
            jmnpyjmlkmnotmhn
            otmnplknt""";

    @BeforeMethod
    @Override
    public void beforeMethod(ITestContext context) {
        super.beforeMethod(context);
        new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickAdministrationButtonInDropdown()
                .clickChallengeInAdministrationButton()
                .clickAddChallengesButton();
    }

    @Test
    public void TestVerifyAllFieldsEmpty() {
        SoftAssert softAssert = new SoftAssert();

        var addChallengePage = new AddChallengePage(driver);

        String NameValue = addChallengePage
                .clickChallengeName()
                .getChallengeNameValue();
        softAssert.assertEquals(NameValue, "");

        String NumberValue = addChallengePage
                .clickSortNumber()
                .getSortNumberValue();
        softAssert.assertEquals(NumberValue, "");

        String TitleValue = addChallengePage
                .clickChallengeTitle()
                .getChallengeTitleValue();
        softAssert.assertEquals(TitleValue, "");

        List<String> depictionChallengeOne = addChallengePage
                .getDepictionChallenge();
        String GetListDepictionOne = String.join("\n", depictionChallengeOne);
        softAssert.assertEquals(GetListDepictionOne, "");

        String NumberValueTwo = addChallengePage
                .addChallengeSortNumber("123")
                .getSortNumberValue();
        softAssert.assertEquals(NumberValueTwo, "123");

        String NameValueTwo = addChallengePage
                .addChallengeName("Гопак")
                .getChallengeNameValue();
        softAssert.assertEquals(NameValueTwo, "Гопак");

        String TitleValueTwo = addChallengePage
                .addChallengeTitle("Присідання")
                .getChallengeTitleValue();
        softAssert.assertEquals(TitleValueTwo, "Присідання");

        addChallengePage.addDepictionChallenge(expected);
        List<String> depictionChallenge = addChallengePage.getDepictionChallenge();
        String GetListDepiction = String.join("\n", depictionChallenge);
        softAssert.assertEquals(GetListDepiction, expected);

        //softAssert.assertFalse(addChallengePage.checkIsImageAdded());

        addChallengePage.addImage(valueProvider.getSunFlower());

        softAssert.assertTrue(addChallengePage.checkIsImageAdded(), "Image was not added");

        softAssert.assertEquals(addChallengePage.takeSRCImageFromSite(), addChallengePage.getImageData());


        softAssert.assertAll();


    }
}
