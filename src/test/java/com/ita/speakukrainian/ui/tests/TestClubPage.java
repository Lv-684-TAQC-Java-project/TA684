package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.ClubsPage;
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

    @Test()
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

        List<WebElement> centersCardAsc = extendedSearchOpened
                .clickCentreRadioButton()
                .clickClearButton()
                .clickSortAlphabeticallyButton()
                .getCentersCard();

        List<String> listCenterCards = cardsItem(centersCardAsc);

        List<String> sortedListCenterCardsAsc = sorted(listCenterCards);

        for (int i = 0; i < listCenterCards.size(); i++) {
            System.out.println(listCenterCards.get(i));
            System.out.println(sortedListCenterCardsAsc.get(i));
            softAssert.assertEquals(listCenterCards.get(i), sortedListCenterCardsAsc.get(i));
            System.out.println("--------------------------------------------------------------");
        }
        CenterServise centerServise = new CenterServise();

        List<CenterEntity> centers = centerServise.getIdNamesAsc();

        for (int i = 0; i < listCenterCards.size(); i++) {
            System.out.println(listCenterCards.get(i));
            System.out.println(centers.get(i).getName());
            softAssert.assertEquals(listCenterCards.get(i), centers.get(i).getName());
            System.out.println("--------------------------------------------------------------");
        }

        List<WebElement> centerCardsRevers = clubsPage.
                clickArrowUpButton()
                .getCentersCard();

        List<String> listCenterCardsRevers = cardsItem(centerCardsRevers);

        List<String> sortedListCenterCardsDesc = sortedrevers(listCenterCardsRevers);

        for (int i = 0; i < listCenterCardsRevers.size(); i++) {
            System.out.println(listCenterCardsRevers.get(i));
            System.out.println(sortedListCenterCardsDesc.get(i));
            softAssert.assertEquals(listCenterCardsRevers.get(i), sortedListCenterCardsDesc.get(i));
            System.out.println("--------------------------------------------------------------");
        }

        List<CenterEntity> centersRevers = centerServise.getIdNamesDesc();

        for (int i = 0; i < listCenterCardsRevers.size(); i++) {
            System.out.println(listCenterCardsRevers.get(i));
            System.out.println(centersRevers.get(i).getName());
            softAssert.assertEquals(listCenterCardsRevers.get(i), centersRevers.get(i).getName());
            System.out.println("--------------------------------------------------------------");
        }

        softAssert.assertAll();
    }
}
