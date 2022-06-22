package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Item;
import com.ita.speakukrainian.ui.testruners.BaseTestRunner;
import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;
import com.ita.speakukrainian.utils.jdbc.services.ClubsService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class SearchByNameClub226 extends BaseTestRunner {

    private boolean compareList(List<String> one, List<String> two) {
        for (int i = 0; i < one.size(); i++) {
            for (int j = 0; j < two.size(); j++) {
                if (one.get(i).equals(two.get(j))) {
                    break;
                }
                return true;
            }
        }
        return false;
    }

    @Description("Verify that user can perform basic search by names of a club  and compare DB List")
    @Test(description = "TUA-226")
    @Issue("TUA-226")
    public void TestAllNameClubs() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getExtendedSearchComponent()
                .getcardFirst();
        List<String> cardsItem = new ArrayList<>();
        for (WebElement element : card) {
            cardsItem.add(new Item(driver, element).getName());
        }
        ClubsService clubsService = new ClubsService();
        List<ClubsEntity> NameClubs = clubsService.getAllNameClubs();
        List<String> rr = new ArrayList<>();
        for (int i = 0; i < NameClubs.size(); i++) {
            rr.add(NameClubs.get(i).getName());
        }
        softAssert.assertTrue(compareList(cardsItem, rr));
        softAssert.assertAll();
    }

    @Description("Verify that user can perform basic search by names of a club  and compare DB name club")
    @Test(description = "TUA-226")
    @Issue("TUA-226")
    public void TestAllNameClubsTwo() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getExtendedSearchComponent()
                .getcardFirst();
        List<String> cardsItem = new ArrayList<>();
        for (WebElement element : card) {
            cardsItem.add(new Item(driver, element).getName());
        }
        ClubsService clubsService = new ClubsService();
        List<ClubsEntity> NameClubs = clubsService.getAllNameClubs();
        softAssert.assertEquals(cardsItem.get(0), NameClubs.get(0).getName());
        softAssert.assertAll();
    }

    @Description("Verify that user can perform basic search by name of a club use DB")
    @Test(description = "TUA-226")
    @Issue("TUA-226")
    public void TestAllNameClubsUseLike() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> card = new HomePage(driver)
                .header()
                .clickClubsPageHeader()
                .getHeaderMenuComponent()
                .clickExtendedSearchButton()
                .getExtendedSearchComponent()
                .fillInMainSearchField("Andalusia2")
                .clickClickButtonFindElement()
                .getcard();
        List<String> cardsItem = new ArrayList<>();
        for (WebElement element : card) {
            cardsItem.add(new Item(driver, element).getName());
        }
        ClubsService clubsService = new ClubsService();
        List<ClubsEntity> NameClubs = clubsService.getAllNameClubsUseLike();
        for (int i = 0; i < cardsItem.size(); i++) {
            softAssert.assertEquals(cardsItem.get(i), NameClubs.get(i).getName());
        }
        softAssert.assertAll();
    }
}

