package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.dropdowns.MyProfilePageDropDown;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.MyProfilePage;
import com.ita.speakukrainian.ui.testruners.BaseTestRunner;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDoesNotCrossToPages extends TestRuneWithAdmin {

    @Test
    @Description("Test verify when does cross to next page ")
    public void clickNextPageWhenChosenMyCentersTest(){
        MyProfilePage page = new MyProfilePage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.header().clickUserProFileButton().clickMyProfileButton();
        page.clickMyCenters().clickSecondPage();
        Assert.assertTrue(page.secondPageIsSelected());
    }
}
