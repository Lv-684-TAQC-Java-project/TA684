package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Item;
import com.ita.speakukrainian.ui.testruners.BaseTestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestClubPage extends BaseTestRunner {

    private List<String> sorted(List<String> list) {
        List<String> listsorted = new ArrayList<>(list);
        listsorted.sort(String.CASE_INSENSITIVE_ORDER);
        return listsorted;
    }

    private List<String> sortedrevers(List<String> list) {
        List<String> listsortedrevers = new ArrayList<>(list);
        listsortedrevers.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        return listsortedrevers;
    }

    private List<String> cardsItem(List<WebElement> list) {
        List<String> cardsItemOne = new ArrayList<>();
        for (WebElement element : list) {
            cardsItemOne.add(new Item(driver, element).getName());
        }
        return cardsItemOne;
    }

    @Test(priority = 1)
    @Description("[allure]  Is Extended AdvancedSearch If Is Opened And Sorted")
    @Issue("TUA-103")
    public void AdvancedSearchIfIsOpenedAndSorted() {
        SoftAssert softAssert = new SoftAssert();
        var isSearchOpened = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .getExtendedSearchComponent();
        var isSearchOpenedDisplayed = isSearchOpened
                .isDisplayedadvancedSearch();
        Assert.assertTrue(isSearchOpenedDisplayed);
        System.out.println("1-----------------------------------------");


        List<WebElement> cardOne = isSearchOpened
                .getcard();
        for (int i1 = 0; i1 < cardsItem(cardOne).size(); i1++) {
            if (cardsItem(cardOne).get(i1).equals(sorted(cardsItem(cardOne)).get(i1))) {
               // System.out.println(cardsItem(cardOne).get(i1) + " = " + sorted(cardsItem(cardOne)).get(i1));
                Assert.assertEquals(cardsItem(cardOne).get(i1), sorted(cardsItem(cardOne)).get(i1));
            } else {
                System.out.println(cardsItem(cardOne).get(i1) + " != " + sorted(cardsItem(cardOne)).get(i1));
                Assert.assertNotEquals(cardsItem(cardOne).get(i1), sorted(cardsItem(cardOne)).get(i1));
            }
        }
        System.out.println("2-----------------------------------------");

        List<WebElement> cardArrowUp = isSearchOpened
                .clickArrowUpButton()
                .getcard();
        for (int i2 = 0; i2 < cardsItem(cardArrowUp).size(); i2++) {
            if (cardsItem(cardArrowUp).get(i2).equals(sortedrevers(cardsItem(cardArrowUp)).get(i2))) {
               // System.out.println(cardsItem(cardArrowUp).get(i2) + " = " + sortedrevers(cardsItem(cardArrowUp)).get(i2));
                Assert.assertEquals(cardsItem(cardArrowUp).get(i2), sortedrevers(cardsItem(cardArrowUp)).get(i2));
            } else {
                System.out.println(cardsItem(cardArrowUp).get(i2) + " != " + sortedrevers(cardsItem(cardArrowUp)).get(i2));
                Assert.assertNotEquals(cardsItem(cardArrowUp).get(i2), sortedrevers(cardsItem(cardArrowUp)).get(i2));

            }
        }
        System.out.println("3-----------------------------------------");


        List<WebElement> cardArrowDown = isSearchOpened
                .clickArrowDownButton()
                .getcard();
        for (int i3 = 0; i3 < cardsItem(cardArrowDown).size(); i3++) {
            if(cardsItem(cardArrowDown).get(i3).equals(sorted(cardsItem(cardArrowDown)).get(i3))){
          //  System.out.println(cardsItem(cardArrowDown).get(i3) + " = " + sorted(cardsItem(cardArrowDown)).get(i3));
            Assert.assertEquals(cardsItem(cardArrowDown).get(i3), sorted(cardsItem(cardArrowDown)).get(i3));

        }else{
                System.out.println(cardsItem(cardArrowDown).get(i3) + " != " + sorted(cardsItem(cardArrowDown)).get(i3));
                Assert.assertNotEquals(cardsItem(cardArrowDown).get(i3), sorted(cardsItem(cardArrowDown)).get(i3));
            }
        }
        System.out.println("4-----------------------------------------");


        List<WebElement> cardCentr = new ClubsPage(driver)
                .clickCheckedToCenterButton()
                .getcardCentr();
        for (int i4 = 0; i4 < cardsItem(cardCentr).size(); i4++) {
            if (cardsItem(cardCentr).get(i4).equals(sorted(cardsItem(cardCentr)).get(i4))) {
                System.out.println(cardsItem(cardCentr).get(i4) + " = " + sorted(cardsItem(cardCentr)).get(i4));
                Assert.assertEquals(cardsItem(cardCentr).get(i4), sorted(cardsItem(cardCentr)).get(i4));
            } else {
                System.out.println(cardsItem(cardCentr).get(i4) + " != " + sorted(cardsItem(cardCentr)).get(i4));
                Assert.assertNotEquals(cardsItem(cardCentr).get(i4), sorted(cardsItem(cardCentr)).get(i4));
            }
        }
        System.out.println("5-----------------------------------------");

        List<WebElement> cardUpButtonCentr = isSearchOpened
                .clickArrowUpButton()
                .getcardCentr();
        for (int i5 = 0; i5 < cardsItem(cardUpButtonCentr).size(); i5++) {
            if (cardsItem(cardUpButtonCentr).get(i5).equals(sortedrevers(cardsItem(cardUpButtonCentr)).get(i5))) {
                System.out.println(cardsItem(cardUpButtonCentr).get(i5) + " = " + sortedrevers(cardsItem(cardUpButtonCentr)).get(i5));
                Assert.assertEquals(cardsItem(cardUpButtonCentr).get(i5), sortedrevers(cardsItem(cardUpButtonCentr)).get(i5));
            } else {
                System.out.println(cardsItem(cardUpButtonCentr).get(i5) + " != " + sortedrevers(cardsItem(cardUpButtonCentr)).get(i5));
                Assert.assertNotEquals(cardsItem(cardUpButtonCentr).get(i5), sortedrevers(cardsItem(cardUpButtonCentr)).get(i5));
            }
        }
        System.out.println("6-----------------------------------------");


        List<WebElement> cardDownButtonCenter = isSearchOpened
                .clickArrowDownButton()
                .getcardCentr();
        for (int i6 = 0; i6 < cardsItem(cardDownButtonCenter).size(); i6++) {
            if (cardsItem(cardDownButtonCenter).get(i6).equals(sorted(cardsItem(cardDownButtonCenter)).get(i6))) {
                System.out.println(cardsItem(cardDownButtonCenter).get(i6) + " = " + sorted(cardsItem(cardDownButtonCenter)).get(i6));
                Assert.assertEquals(cardsItem(cardDownButtonCenter).get(i6), sorted(cardsItem(cardDownButtonCenter)).get(i6));
            } else {
                System.out.println(cardsItem(cardDownButtonCenter).get(i6) + " != " + sorted(cardsItem(cardDownButtonCenter)).get(i6));
                Assert.assertNotEquals(cardsItem(cardDownButtonCenter).get(i6), sorted(cardsItem(cardDownButtonCenter)).get(i6));
            }
        }
        softAssert.assertAll();

    }

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

    @Test(dataProvider = "data", priority = 8)
    @Description("Verify Input Accepts Positive Integers From 2 To 18")
    @Issue("TUA-210")
    public void verifyInputAcceptsPositiveIntegersFrom2To18(int age, int expected) {
        String actualAgeValue = new HomePage(driver)
                .header()
                .clickExtendedSearchButton()
                .fillInAgeInput(age)
                .readAgeInput();

        int actual = Integer.parseInt(String.valueOf(actualAgeValue));

        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 9)
    @Description("[allure]  Is Extended search menu is displayed and hidden after re-click")
    @Issue("TUA-224")
    public void testIsExtendedSearchMenuDisplayed() {
        ClubsPage clubsPage = new ClubsPage(driver);
        Assert.assertTrue(clubsPage.isExtendedSearchMenuDisplayed());
        Assert.assertTrue(clubsPage.isExtendedSearchMenuHidden());
    }

    @Test(priority = 10)
    @Description("[allure]  Verify child age andAvailable online")
    @Issue("TUA-510")
    public void testVerifyChildAgeAndAvailableOnline() {
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);
        ClubsPage clubsPage = new ClubsPage(driver);
        headerMenuComponent.clickExtendedSearchButton().clickCentreRadioButton();
        clubsPage.openCityDropDown().clickCityKiev();
        clubsPage.openCityDistrictDropDown().clickCityDistrictDesnyanskiy();
        clubsPage.openNearestMetroStationDropDown().clickArsenalMetroStation();
        Assert.assertEquals(clubsPage.checkAvailableOnline(),false);
        Assert.assertEquals(clubsPage.checkAvailableAgeField(),false);

    }

    @Test()
    @Description("[allure] Checking, is 'Гурток' radio-button pushed and after choosing 'Центр' radio-button was ordering as blocks. Reorder centers as list")
    @Issue("TUA-513")
    public void testCheckButtonsIsUnavailable () {
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);
        ClubsPage clubsPage = new ClubsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        headerMenuComponent.
                clickExtendedSearchButton();
        softAssert.assertTrue(clubsPage.IsClubButtonSelected(), "Club radioButton was not pushed");
        clubsPage.clickCentreRadioButton();
        softAssert.assertTrue(clubsPage.IsCentreButtonSelected(), "Centre radioButton was not pushed");
        clubsPage.clickSortMenuBarButton();
        softAssert.assertTrue(clubsPage.IsCentresSortedAsList(), "Centers was not sorted as list");
        softAssert.assertAll();
    }

}
