package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import com.ita.speakukrainian.ui.pages.ExtendedSearchComponent;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Item;
import com.ita.speakukrainian.ui.testruners.BaseTestRunner;
import com.ita.speakukrainian.utils.jdbc.entity.CenterEntity;
import com.ita.speakukrainian.utils.jdbc.services.CenterServise;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TestClubPage extends BaseTestRunner {

    private List<String> sorted(List<String> list) {
        List<String> listsorted = new ArrayList<>(list);
        listsorted.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
        return listsorted;
    }

    private List<String> sortedrevers(List<String> list) {
        List<String> listsortedrevers = new ArrayList<>(list);
        listsortedrevers.sort(String.CASE_INSENSITIVE_ORDER.thenComparing(CharSequence::compare).reversed());
        return listsortedrevers;
    }

    private List<String> cardsItem(List<WebElement> list) {
        List<String> cardsItemOne = new ArrayList<>();
        for (WebElement element : list) {
            cardsItemOne.add(new Item(driver, element).getName());
        }
        return cardsItemOne;
    }

    private List<String> cardsName(List<WebElement> list) {
        List<String> cardsItemOne = new ArrayList<>();
        for (WebElement element : list) {
            cardsItemOne.add(new Item(driver, element).getName().trim());
        }
        return cardsItemOne;
    }

    @Test()
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
        softAssert.assertTrue(isSearchOpenedDisplayed);
        for (int i = 1; i <= 6; i++) {
            System.out.println(i + "-----------------------------------------");
            List<WebElement> card;
            switch (i) {
                case 1:
                    card = isSearchOpened
                            .getcard();
                    break;
                case 2:
                    card = isSearchOpened
                            .clickArrowUpButton()
                            .getcard();
                    break;
                case 3:
                    card = isSearchOpened
                            .clickArrowDownButton()
                            .getcard();
                    break;
                case 4:
                    card = isSearchOpened
                            .getClubsPage()
                            .clickCheckedToCenterButton()
                            .clickSortedAlphabeticallyButton()
                            .getcardCentr();
                    break;
                case 5:
                    card = isSearchOpened
                            .clickArrowUpButton()
                            .getcardCentr();
                    break;
                case 6:
                    card = isSearchOpened
                            .clickArrowDownButton()
                            .getcardCentr();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }


            for (int j = 0; j < cardsItem(card).size(); j++) {
                if ((i == 1) || (i == 3) || (i == 4) || (i == 6)) {
                    softAssert.assertEquals(cardsItem(card).get(j), sorted(cardsItem(card)).get(j), "the item=" + cardsItem(card).get(j) + " does not match the value of the sorted list=" + sorted(cardsItem(card)).get(j));

                } else {
                    softAssert.assertEquals(cardsItem(card).get(j), sortedrevers(cardsItem(card)).get(j), "the item=" + cardsItem(card).get(j) + " does not match the value of the sorted list=" + sortedrevers(cardsItem(card)).get(j));

                }
            }
            softAssert.assertAll();

        }
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

    @Test(dataProvider = "data")
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

    @Test()
    @Description("[allure]  Is Extended search menu is displayed and hidden after re-click")
    @Issue("TUA-224")
    public void testIsExtendedSearchMenuDisplayed() {
        ClubsPage clubsPage = new ClubsPage(driver);
        Assert.assertTrue(clubsPage.isExtendedSearchMenuDisplayed());
        Assert.assertTrue(clubsPage.isExtendedSearchMenuHidden());
    }

    @Test()
    @Description("[allure]  Verify child age andAvailable online")
    @Issue("TUA-510")
    public void testVerifyChildAgeAndAvailableOnline() {
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);
        ClubsPage clubsPage = new ClubsPage(driver);
        headerMenuComponent.clickExtendedSearchButton().clickCentreRadioButton();
        clubsPage.openCityDropDown().clickCityKiev();
        clubsPage.openCityDistrictDropDown().clickCityDistrictDesnyanskiy();
        clubsPage.openNearestMetroStationDropDown().clickArsenalMetroStation();
        Assert.assertEquals(clubsPage.checkAvailableOnline(), false);
        Assert.assertEquals(clubsPage.checkAvailableAgeField(), false);

    }

    @Test()
    @Description("[allure] Checking, is 'Гурток' radio-button pushed and after choosing 'Центр' radio-button was ordering as blocks. Reorder centers as list")
    @Issue("TUA-513")
    public void testCheckButtonsIsUnavailable() {
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


    @Description("Verify that the user can sort the search results alphabetically after clicking on the 'Центр' radio button")
    @Issue("TUA-440")
    public void verifySearchResultsAlphabeticallyAfterClickingOnCenterRadioButton() {
        ClubsPage clubsPage = new ClubsPage(driver);
        SoftAssert softAssert = new SoftAssert();

        ClubsPage extendedSearchOpened = new HomePage(driver)
                .header()
                .clickExtendedSearchButton();

        boolean isExtendedSearchPageDisplayed = extendedSearchOpened
                .isExtendedSearchPageDisplayed();

        softAssert.assertTrue(isExtendedSearchPageDisplayed);

        List<WebElement> centersCardAscFromUi = extendedSearchOpened
                .clickCentreRadioButton()
                .clickClearButton()
                .clickSortAlphabeticallyButton()
                .getCentersCard();

        List<String> centerNamesFromUiAsc = cardsItem(centersCardAscFromUi);

        List<String> sortedCenterNamesFromUiAsc = sorted(centerNamesFromUiAsc);

        for (int i = 0; i < centerNamesFromUiAsc.size(); i++) {
            System.out.println(centerNamesFromUiAsc.get(i));
            System.out.println(sortedCenterNamesFromUiAsc.get(i));
            softAssert.assertEquals(centerNamesFromUiAsc.get(i), sortedCenterNamesFromUiAsc.get(i));
            System.out.println("--------------------------------------------------------------");
        }
        CenterServise centerServise = new CenterServise();

        List<CenterEntity> sortedCenterNamesFromDbAsc = centerServise.getIdNamesAsc();

        for (int i = 0; i < centerNamesFromUiAsc.size(); i++) {
            System.out.println(centerNamesFromUiAsc.get(i));
            System.out.println(sortedCenterNamesFromDbAsc.get(i).getName());
            softAssert.assertEquals(centerNamesFromUiAsc.get(i), sortedCenterNamesFromDbAsc.get(i).getName());
            System.out.println("--------------------------------------------------------------");
        }

        List<WebElement> centersCardDescFromUi = clubsPage.
                clickArrowUpButton()
                .getCentersCard();

        List<String> centerNamesFromUiDesc = cardsItem(centersCardDescFromUi);

        List<String> sortedCenterNamesFromUiDesc = sortedrevers(centerNamesFromUiDesc);

        for (int i = 0; i < centerNamesFromUiDesc.size(); i++) {
            System.out.println(centerNamesFromUiDesc.get(i));
            System.out.println(sortedCenterNamesFromUiDesc.get(i));
            softAssert.assertEquals(centerNamesFromUiDesc.get(i), sortedCenterNamesFromUiDesc.get(i));
            System.out.println("--------------------------------------------------------------");
        }

        List<CenterEntity> sortedCenterNamesFromDbDesc = centerServise.getIdNamesDesc();

        for (int i = 0; i < centerNamesFromUiDesc.size(); i++) {
            System.out.println(centerNamesFromUiDesc.get(i));
            System.out.println(sortedCenterNamesFromDbDesc.get(i).getName());
            softAssert.assertEquals(centerNamesFromUiDesc.get(i), sortedCenterNamesFromDbDesc.get(i).getName());
            System.out.println("--------------------------------------------------------------");
        }

        softAssert.assertAll();
    }


    @Test()
    @Description("Verify that the user can sort the search results alphabetically after clicking on the 'Центр' radio button")
    @Issue("TUA-440")
    public void verifySearchResultsAlphabeticallyAfterClickingOnCenterRadioButton1() {
        ClubsPage clubsPage = new ClubsPage(driver);
        SoftAssert softAssert = new SoftAssert();

        ClubsPage extendedSearchOpened = new HomePage(driver)
                .header()
                .clickExtendedSearchButton();

        boolean isExtendedSearchPageDisplayed = extendedSearchOpened
                .isExtendedSearchPageDisplayed();

        softAssert.assertTrue(isExtendedSearchPageDisplayed);

        List<WebElement> centersCardAscFromUi = extendedSearchOpened
                .clickCentreRadioButton()
                .clickClearButton()
                .clickSortAlphabeticallyButton()
                .getCentersCard();

        List<String> centerNamesFromUiAsc = cardsName(centersCardAscFromUi);

        List<String> sortedCenterNamesFromUiAsc = sorted(centerNamesFromUiAsc);

        softAssert.assertEquals(centerNamesFromUiAsc, sortedCenterNamesFromUiAsc);

        for (int i = 0; i < centerNamesFromUiAsc.size(); i++) {
            System.out.println(centerNamesFromUiAsc.get(i));
            System.out.println(sortedCenterNamesFromUiAsc.get(i));
//            softAssert.assertEquals(centerNamesFromUiAsc.get(i), sortedCenterNamesFromUiAsc.get(i));
            System.out.println("--------------------------------------------------------------");
        }
        CenterServise centerServise = new CenterServise();

        List<CenterEntity> sortedCenterNamesFromDbAsc = centerServise.getIdNamesAsc();

        List<String> expectedSortedCenterNamesFromDbAsc = sortedCenterNamesFromDbAsc.
                stream().map(el -> el.getName().trim()).toList().subList(0, centerNamesFromUiAsc.size());


        for (int i = 0; i < centerNamesFromUiAsc.size(); i++) {
            System.out.println(centerNamesFromUiAsc.get(i));
            System.out.println(expectedSortedCenterNamesFromDbAsc.get(i));
//            softAssert.assertEquals(centerNamesFromUiAsc.get(i), sortedCenterNamesFromDbAsc.get(i).getName());
            System.out.println("--------------------------------------------------------------");
        }

        List<WebElement> centersCardDescFromUi = clubsPage.
                clickArrowUpButton()
                .getCentersCard();

        List<String> centerNamesFromUiDesc = cardsItem(centersCardDescFromUi);

        List<String> sortedCenterNamesFromUiDesc = sortedrevers(centerNamesFromUiDesc);

        softAssert.assertEquals(centerNamesFromUiDesc, sortedCenterNamesFromUiDesc);

        for (int i = 0; i < centerNamesFromUiDesc.size(); i++) {
            System.out.println(centerNamesFromUiDesc.get(i));
            System.out.println(sortedCenterNamesFromUiDesc.get(i));
//            softAssert.assertEquals(centerNamesFromUiDesc.get(i), sortedCenterNamesFromUiDesc.get(i));
            System.out.println("--------------------------------------------------------------");
        }

        List<CenterEntity> sortedCenterNamesFromDbDesc = centerServise.getIdNamesDesc();

        List<String> expectedSortedCenterNamesFromDbDesc = sortedCenterNamesFromDbDesc.stream().map(el -> el.getName()
                .trim()).collect(Collectors.toList()).subList(0, centerNamesFromUiDesc.size());

        softAssert.assertEquals(centerNamesFromUiDesc, expectedSortedCenterNamesFromDbDesc);

        for (int i = 0; i < centerNamesFromUiDesc.size(); i++) {
            System.out.println(centerNamesFromUiDesc.get(i));
            System.out.println(expectedSortedCenterNamesFromDbDesc.get(i));
            //        softAssert.assertEquals(centerNamesFromUiDesc.get(i), sortedCenterNamesFromDbDesc.get(i).getName());
            System.out.println("--------------------------------------------------------------");
        }

        softAssert.assertAll();
    }

    @Test()
    @Description("[allure] Verify that the user can sort the search results by rating after clicking on the 'Центр' radio button")
    @Issue("TUA-449")
    public void testCheckSorterInDataBase() {
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);
        ClubsPage clubsPage = new ClubsPage(driver);
        ExtendedSearchComponent extendedSearchComponent = new ExtendedSearchComponent(driver);
        SoftAssert softAssert = new SoftAssert();
        CenterServise centerServise = new CenterServise();
        List<CenterEntity> tableByAcs = centerServise.getIdNameRatingByAscCenters();
        List<CenterEntity> tableByDecs = centerServise.getIdNameRatingByDescCenters();

        headerMenuComponent.clickExtendedSearchButton();
        extendedSearchComponent.clickClearDefaultCityButton();

        List<WebElement> card;
        card = clubsPage.clickCheckedToCenterButton()
                .clickSortedRatingButton()
                .getcardCentr();
        List<String> cards = cardsItem(card);

        for (int i = 0; i < cards.size(); i++) {
            softAssert.assertEquals(cards.get(i), tableByAcs.get(i).getName());
        }

        extendedSearchComponent.clickArrowUpButton();
        card = clubsPage.clickCheckedToCenterButton()
                .clickSortedRatingButton()
                .getcardCentr();
        cards = cardsItem(card);

        for (int i = 0; i < cards.size(); i++) {
            softAssert.assertEquals(cards.get(i), tableByDecs.get(i).getName());
        }
    }
}
