package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.EditProfileRunner177Factory;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.MyProfilePage;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestVerifiesThatErrorMessage177 extends EditProfileRunner177Factory {



    private Object ITestContext;
    private final String param;
    public TestVerifiesThatErrorMessage177(String param) {
        this.param = param;
    }

    @Test
    @Description("[allure]  Is Extended Massage is displayed when add  1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1500Symbols() {
        boolean isDisplayedMassage = new MyProfilePage(driver)
                .clickAddButton()
                .clickAddClubButton()
                .fillInClubNameInput("Юність")
                .clickOptionCheckboxes(0)
                .fillInAgeFromInput("18")
                .fillInAgeToInput("50")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(param)
                .isSuccessIconDisplayed();
        Assert.assertTrue(isDisplayedMassage);

    }

//    @Test
//    @Description("[allure]  Is Extended Massage is displayed when add less 1500 symbols")
//    @Issue("TUA-177")
//    public void TestVerifiesTheErrorMessageWhenEnterLess1500Symbols() {
//        boolean isDisplayedMassage = new HomePage(driver)
//                .header()
//                .clickUserProFileButton()
//                .clickSingInButton()
//                .sendKeysEmail(valueProvider.getAdminEmail())
//                .sendKeysPassword(valueProvider.getAdminPassword())
//                .clickLoginButton()
//                .header()
//                .clickUserProFileButton()
//                .clickMyProfileButton()
//                .clickAddButton()
//                .clickAddClubButton()
//                .fillInClubNameInput("Юність")
//                .clickOptionCheckboxes(0)
//                .fillInAgeFromInput("18")
//                .fillInAgeToInput("50")
//                .clickNextStepButton()
//                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
//                .clickNextStepButton()
//                .fillInBasicDescriptionInput(param)
//                .isSuccessIconDisplayed();
//
//        Assert.assertTrue(isDisplayedMassage);
//
//    }
    /*

   @DataProvider(name = "data1501symbols")
    public Object[][] dataProvider1501symbols() {
        int symbols = 1501;

        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= symbols; i++) {
            list.add("a");
        }
        System.out.println(list.size());

        Object[][] data = new Object[][]{
                {String.join("", list)},
        };
        return data;
    }



    @Test
    @Description("[allure]  Is Extended errorMassage when add more 1501 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1501Symbols(String testCaseValue) {
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
                .fillInClubNameInput("Юність")
                .clickOptionCheckboxes(0)
                .fillInAgeFromInput("18")
                .fillInAgeToInput("50")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .TextWrongDescriptionDownAlert();
        Assert.assertEquals(errorMassage, "Опис гуртка може містити від 40 до 1500 символів.");


    }

    @Test
    @Description("[allure]  Is Extended errorMassage is displayed whan add more 1501 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnter1501Symbols2(String testCaseValue) {
        Boolean IconErrorDisplayed = new HomePage(driver)
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
                .fillInClubNameInput("Юність")
                .clickOptionCheckboxes(0)
                .fillInAgeFromInput("18")
                .fillInAgeToInput("50")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .issuccessIconErrorDisplayed();
        Assert.assertTrue(IconErrorDisplayed);


    }

    @DataProvider(name = "dataMore1500symbols")
    public Object[][] dataProviderMore1500symbols() {
        int symbols = 1550;

        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= symbols; i++) {
            list.add("a");
        }
        System.out.println(list.size());

        Object[][] data = new Object[][]{
                {String.join("", list)},
        };
        return data;
    }



    @Test
    @Description("[allure]  Is Extended errorMassage  whan add more 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnterMore1500Symbols(String testCaseValue) {
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
                .fillInClubNameInput("Юність")
                .clickOptionCheckboxes(0)
                .fillInAgeFromInput("18")
                .fillInAgeToInput("50")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .TextWrongDescriptionDownAlert();
        Assert.assertEquals(errorMassage, "Опис гуртка може містити від 40 до 1500 символів.");
    }

    @Test
    @Description("[allure]  Is Extended errorMassage is displayed whan add more 1500 symbols")
    @Issue("TUA-177")
    public void TestVerifiesTheErrorMessageWhenEnterMore1500Symbols2(String testCaseValue) {
        Boolean IconErrorDisplayed = new HomePage(driver)
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
                .fillInClubNameInput("Юність")
                .clickOptionCheckboxes(0)
                .fillInAgeFromInput("18")
                .fillInAgeToInput("50")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .issuccessIconErrorDisplayed();
        Assert.assertTrue(IconErrorDisplayed);
    }


     */

}
