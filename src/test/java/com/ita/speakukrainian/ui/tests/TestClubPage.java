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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestClubPage extends BaseTestRunner {

    @Test
    @Description("[allure]  Is Extended AdvancedSearch If Is Opened")
    @Issue("TUA-103")
    public void AdvancedSearchIfIsOpened() {
        boolean isSearchOpenedDisplayed = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .getExtendedSearchComponent()
                .isDisplayedadvancedSearch();
        Assert.assertTrue(isSearchOpenedDisplayed);
    }

    @Test
    @Description("[allure]  Is Extended Sorted Alp habetically Descending Order")
    @Issue("TUA-103")
    public void SortedAlphabeticallyDescendingOrder() {

        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .getExtendedSearchComponent()
                .getcard();
        List<Item> cardsItem = new ArrayList<>();
        for (WebElement element : card) {
            cardsItem.add(new Item(driver, element));
        }
        List<String> cardsItem2 = new ArrayList<>();
        for (Item item : cardsItem) {
            cardsItem2.add(item.getName());
        }
        List<String> sortedList = cardsItem2.stream().sorted().collect(Collectors.toList());
        int count = 0;
        int cardsItemlenght = cardsItem2.size();
        SoftAssert softAssert = new SoftAssert();
        for (String item : cardsItem2) {
            for (String sri : sortedList) {
                if (item.equals(sri)) {
                    count++;

                }
            }
        }
        softAssert.assertEquals(count, cardsItemlenght);
        for (String e : sortedList) {
            softAssert.assertTrue(cardsItem2.contains(e));
        }
        softAssert.assertNotEquals(cardsItem2, sortedList);
        softAssert.assertFalse(cardsItem2.equals(sortedList));
        softAssert.assertAll();

    }


    @Test
    @Description("[allure]  Is Extended Sorted Alp habetically Click Button Up")
    @Issue("TUA-103")
    public void SortedAlphabeticallClickButtonUp() {
        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .getExtendedSearchComponent()
                .clickArrowUpButton()
                .getcard();
        List<Item> cardsItem = new ArrayList<>();
        for (WebElement element : card) {
            cardsItem.add(new Item(driver, element));
        }
        List<String> cardsItem2 = new ArrayList<>();
        for (Item item : cardsItem) {
            cardsItem2.add(item.getName());
        }
        List<String> sortedListrevers = cardsItem2.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int count = 0;
        int cardsItemlenght = cardsItem2.size();
        SoftAssert softAssert = new SoftAssert();
        for (String item : cardsItem2) {
            for (String sri : sortedListrevers) {
                if (item.equals(sri)) {
                    count++;
                }
            }
        }
        softAssert.assertEquals(count, cardsItemlenght);
        for (String e : sortedListrevers) {
            Assert.assertTrue(cardsItem2.contains(e));
        }
        softAssert.assertEquals(cardsItem2, sortedListrevers);
        softAssert.assertTrue(cardsItem2.equals(sortedListrevers));
        softAssert.assertAll();

    }

    @Test
    @Description("[allure]  Is Extended Sorted Alp habetically Click Button Douwn")
    @Issue("TUA-103")
    public void SortedAlphabeticallClickButtonDown() {
        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .getExtendedSearchComponent()
                .clickArrowDownButton()
                .getcard();
        List<Item> cardsItem = new ArrayList<>();
        for (WebElement element : card) {
            cardsItem.add(new Item(driver, element));
        }
        List<String> cardsItem2 = new ArrayList<>();
        for (Item item : cardsItem) {
            cardsItem2.add(item.getName());
        }
        List<String> sortedList = cardsItem2.stream().sorted().collect(Collectors.toList());
        int count = 0;
        int cardsItemlenght = cardsItem2.size();
        SoftAssert softAssert = new SoftAssert();
        for (String item : cardsItem2) {
            for (String sri : sortedList) {
                if (item.equals(sri)) {
                    count++;
                    System.out.println(item + " = " + sri);
                }
            }
        }
        softAssert.assertEquals(count, cardsItemlenght);
        for (String e : sortedList) {
            System.out.println(cardsItem2.contains(e));
            Assert.assertTrue(cardsItem2.contains(e));
        }
        softAssert.assertNotEquals(cardsItem2, sortedList);
        softAssert.assertFalse(cardsItem2.equals(sortedList));
        softAssert.assertAll();

    }

    @Test
    @Description("[allure]  Is Extended Sorted Alphabetically Descending Orde rClick Center")
    @Issue("TUA-103")
    public void SortedAlphabeticallyDescendingOrderClickCenter() {

        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .clickCheckedToCenterButton()
                .getcardCentr();
        List<Item> cardsItem = new ArrayList<>();
        for (WebElement element : card) {
            cardsItem.add(new Item(driver, element));
        }
        List<String> cardsItem2 = new ArrayList<>();
        for (Item item : cardsItem) {
            cardsItem2.add(item.getName());
        }
        List<String> sortedList = cardsItem2.stream().sorted().collect(Collectors.toList());
        int count = 0;
        int cardsItemlenght = cardsItem2.size();
        SoftAssert softAssert = new SoftAssert();
        for (String item : cardsItem2) {
            for (String sri : sortedList) {
                if (item.equals(sri)) {
                    count++;

                }
            }
        }
        softAssert.assertEquals(count, cardsItemlenght);
        for (String e : sortedList) {
            softAssert.assertTrue(cardsItem2.contains(e));
        }
        softAssert.assertNotEquals(cardsItem2, sortedList);
        softAssert.assertFalse(cardsItem2.equals(sortedList));
        softAssert.assertAll();

    }


    @Test
    @Description("[allure]  Is Extended Sorted Alphabetically Click Button Up Click Cenret")
    @Issue("TUA-103")
    public void SortedAlphabeticallClickButtonUpClickCenret() {
        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .clickCheckedToCenterButton()
                .clickArrowUpButton()
                .getcardCentr();
        List<Item> cardsItem = new ArrayList<>();
        for (WebElement element : card) {
            cardsItem.add(new Item(driver, element));
        }
        List<String> cardsItem2 = new ArrayList<>();
        for (Item item : cardsItem) {
            cardsItem2.add(item.getName());
        }
        List<String> sortedListrevers = cardsItem2.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int count = 0;
        int cardsItemlenght = cardsItem2.size();
        SoftAssert softAssert = new SoftAssert();
        for (String item : cardsItem2) {
            for (String sri : sortedListrevers) {
                if (item.equals(sri)) {
                    count++;
                    System.out.println(item + " = " + sri);
                }
            }
        }
        softAssert.assertEquals(count, cardsItemlenght);
        for (String e : sortedListrevers) {
            Assert.assertTrue(cardsItem2.contains(e));
        }
        softAssert.assertNotEquals(cardsItem2, sortedListrevers);
        softAssert.assertFalse(cardsItem2.equals(sortedListrevers));
        softAssert.assertAll();

    }

    @Test
    @Description("[allure]  Is Extended Sorted Alphabetically Click Button Down Click Cenret")
    @Issue("TUA-103")
    public void SortedAlphabeticallClickButtonDownClickCenter() {
        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .clickCheckedToCenterButton()
                .clickArrowDownButton()
                .getcardCentr();
        List<Item> cardsItem = new ArrayList<>();
        for (WebElement element : card) {
            cardsItem.add(new Item(driver, element));
        }
        List<String> cardsItem2 = new ArrayList<>();
        for (Item item : cardsItem) {
            cardsItem2.add(item.getName());
        }
        List<String> sortedList = cardsItem2.stream().sorted().collect(Collectors.toList());

        int count = 0;
        int cardsItemlenght = cardsItem2.size();
        SoftAssert softAssert = new SoftAssert();
        for (String item : cardsItem2) {
            for (String sri : sortedList) {
                if (item.equals(sri)) {
                    count++;
                    System.out.println(item + " = " + sri);
                }
            }
        }
        softAssert.assertEquals(count, cardsItemlenght);
        for (String e : sortedList) {
            System.out.println(cardsItem2.contains(e));
            Assert.assertTrue(cardsItem2.contains(e));
        }
        softAssert.assertNotEquals(cardsItem2, sortedList);
        softAssert.assertFalse(cardsItem2.equals(sortedList));
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

    @Test
    @jdk.jfr.Description("[allure]  Is Extended search menu is displayed")
    @Issue("TUA-224")
    public void testIsExtendedSearchMenuDisplayed(){
        ClubsPage clubsPage = new ClubsPage(driver);
        Assert.assertEquals(clubsPage.isExtendedSearchMenuDisplayed(),true);
    }
    @Test
    @jdk.jfr.Description("[allure]  Is Extended search menu is hidden")
    @Issue("TUA-224")
    public void testIsExtendedSearchMenuHidden(){
        ClubsPage clubsPage = new ClubsPage(driver);
        Assert.assertEquals(clubsPage.isExtendedSearchMenuHidden(),true);
    }

    @Test
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

    @Test
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
