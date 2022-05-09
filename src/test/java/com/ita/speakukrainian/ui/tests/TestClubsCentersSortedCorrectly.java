package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Item;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.collections.CollectionUtils;

import javax.management.ObjectName;
import java.util.*;
import java.util.stream.Collectors;

public class TestClubsCentersSortedCorrectly extends SpeakUkrainianRunner {


    @Test
    public void searchDropdownOpened() {
        boolean isSearchDropdownDisplayed = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickSearchInput()
                .isDisplayedSearchInputDropdown();
        Assert.assertTrue(isSearchDropdownDisplayed);
    }

    @Test
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
                    System.out.println(item+" = "+sri);
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
    public void SortedAlphabeticallyDescendingOrderClickCenter() {

        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .getExtendedSearchComponent()
                .clickcheckedToCenterButtonon()
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
    public void SortedAlphabeticallClickButtonUpClickCenret() {
        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .getExtendedSearchComponent()
                .clickcheckedToCenterButtonon()
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
                    System.out.println(item+" = "+sri);
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
    public void SortedAlphabeticallClickButtonDownClickCenter() {
        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .getExtendedSearchComponent()
                .clickcheckedToCenterButtonon()
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
                    System.out.println(item+" = "+sri);
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
}