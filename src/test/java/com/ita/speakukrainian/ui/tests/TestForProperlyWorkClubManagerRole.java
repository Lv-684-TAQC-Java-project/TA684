package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.MyProfilePage;
import com.ita.speakukrainian.ui.pages.MyliavkyClubPage;
import com.ita.speakukrainian.ui.popup.RedactClubMaliavkyPopUp;
import com.ita.speakukrainian.ui.testruners.BaseTestRunner;
import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;
import com.ita.speakukrainian.utils.jdbc.services.ClubsService;;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestForProperlyWorkClubManagerRole extends BaseTestRunner {
    String ClubNameMaliavky="Малявки";
    int numbOfCheckBox = 3; //"Студії раннього розвитку"
    String age1InMaliavky = "2";
    String age2InMaliavky = "4";
    String phoneOfMaliavky = "0934444444";
    String descriptionOfMaliavky = "Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.\n" +
            "\n" +
            "У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.";

    @BeforeMethod
    public void beforeMethod() {
        new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail("TestTeach.ua@meta.ua")
                .sendKeysPassword("123456789")
                .clickLoginButton();
    }

    @Test
    @Description("Checking if a new club was added and if all it's parameters was created correct")
    @Issue("TUA-506")
    public void SavingNewInAddClubPopUp() {
        SoftAssert softAssert = new SoftAssert();
        var myProfilePage = new MyProfilePage(driver);
        new HomePage(driver)
                .header()
                .clickAddClubButtonOnHeader()
                .fillInClubNameInput(ClubNameMaliavky)
                .clickOptionCheckboxes(numbOfCheckBox)
                 .fillInAgeFromInput(age1InMaliavky)
                 .fillInAgeToInput(age2InMaliavky)
                .clickNextStepButton()
                .fillInContactPhoneInput(phoneOfMaliavky)
                .clickNextStepButton()
                .fillInBasicDescriptionInput(descriptionOfMaliavky)
                .toCompleteClubsRegistration()
                 .header()
                .clickUserProFileButton()
                .clickMyProfileButton();
        softAssert.assertTrue(myProfilePage.isCardMaliavkyPresent(),"No such club on the page");
        myProfilePage
                .clickDetailsButton();
       var myliavky = new MyliavkyClubPage(driver);
        softAssert.assertTrue(myliavky.isContain(), "Information is incorrect");
        softAssert.assertTrue(myliavky.isCorrectAge(), "Age was specified incorrectly");
        softAssert.assertTrue(myliavky.isCorrectPhone(), "Phone number was specified incorrectly");
        softAssert.assertAll();
    }

    @Test
    public void GetClubFromBase(){
        ClubsService clubServise = new ClubsService();
        List<ClubsEntity> club = clubServise.getByName("Малявки");
        ClubsEntity maliavky = club.get(0);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(maliavky.getAge_from(), 4);
        softAssert.assertEquals(maliavky.getAge_to(), 6);
        softAssert.assertEquals(maliavky.getName(), "Малявки");
        softAssert.assertEquals(maliavky.getDescription(), descriptionOfMaliavky);
    }
    @Test
    @Description("Checking if a changers was saved and if all it's parameters was created correct")
    @Issue("TUA-508")
    public void RewriteClubData(){

        new HomePage(driver)
         .header()
                .clickUserProFileButton()
                .clickMyProfileButton();

        new MyProfilePage(driver)
                .clickMoreActionMenu()
                .clickRedactClub();
        ClubsService clubServise = new ClubsService();
        List<ClubsEntity> club = clubServise.getByName("Малявки");
        ClubsEntity maliavky = club.get(0);
        System.out.println(maliavky);
    }
}
