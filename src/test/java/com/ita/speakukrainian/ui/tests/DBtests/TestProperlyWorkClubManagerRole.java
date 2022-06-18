package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.MyProfilePage;
import com.ita.speakukrainian.ui.pages.MyliavkyClubPage;
import com.ita.speakukrainian.ui.popup.RedactClubMaliavkyPopUp;
import com.ita.speakukrainian.ui.testruners.BaseTestRunner;
import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;
import com.ita.speakukrainian.utils.jdbc.services.ClubsService;;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.apache.commons.lang.StringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestProperlyWorkClubManagerRole extends BaseTestRunner {
    String clubNameMaliavky="Малявки";
    String rename = "Малявки$";
    int numbOfCheckBox = 3; //"Студії раннього розвитку"
    String age1InMaliavky = "4";
    String age2InMaliavky = "6";
    String phoneOfMaliavky = "0934444444";
    String newPhone = "0935797009";
    Long centerId =264L;
    String descriptionOfMaliavky = "Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.\n" +
            "\n" +
            "У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.";
    String newDescription ="Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії у 2005р.";

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
                .fillInClubNameInput(clubNameMaliavky)
                .clickOptionCheckboxes(numbOfCheckBox)
                .fillInAgeFromInput(age1InMaliavky)
                .fillInAgeToInput(age2InMaliavky)
                .selectCentre()
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
        softAssert.assertEquals(myliavky.TextDescription(), descriptionOfMaliavky, "Information is incorrect");
        softAssert.assertEquals(myliavky.AgeData(),"від "+ "4"+ " до " + "6"+ " років", "Age was specified incorrectly");
        softAssert.assertEquals(myliavky.PhoneNum(),"+38"+phoneOfMaliavky, "Phone number was specified incorrectly");

        ClubsService clubServise = new ClubsService();
        List<ClubsEntity> club = clubServise.getByName(clubNameMaliavky);
        ClubsEntity maliavky = club.get(0);
        new BasePage(driver).saveText(club);
        softAssert.assertEquals(maliavky.getAgeFrom(), Integer. parseInt(age1InMaliavky));
        softAssert.assertEquals(maliavky.getAgeTo(), Integer. parseInt(age2InMaliavky));
        softAssert.assertEquals(maliavky.getName(), clubNameMaliavky);
        softAssert.assertEquals(StringUtils.substringAfter((StringUtils.substringBefore(maliavky.getDescription(), "\",\"type\"")), "\"text\":\""), descriptionOfMaliavky);
        softAssert.assertAll();
    }


    @Test
    @Description("Checking if a changers was saved and if all it's parameters was created correct")
    @Issue("TUA-508")
    public void RewriteClubData(){
        var softAssert = new SoftAssert();
        var clubService = new ClubsService();
        var myProfilePage = new MyProfilePage(driver);
        new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickMyProfileButton();
        List<ClubsEntity> clubIdCenterId = clubService.getByUserIDAndCenterNotNull(centerId);
        softAssert.assertTrue(!clubIdCenterId.isEmpty(), "No such clubs in base");
        new BasePage(driver).saveText(clubIdCenterId);
        myProfilePage
                .clickMoreActionMenu()
                .clickRedactClub();
        List<ClubsEntity> clubName = clubService.getByName(clubNameMaliavky);
        softAssert.assertTrue(!clubName.isEmpty(), "No such club in base");
        new BasePage(driver).saveText(clubName);
        new RedactClubMaliavkyPopUp(driver)
                .changeClubNameField(rename)
                .chooseDevelopmentCheckBox()
                .clickAgeFromChangeDown()
                .clickAgeToChangeDown()
                .saveAgeChanges()
                .chooseNewCenter()
                .addressAndContacts()
                .changePhoneWindow(newPhone)
                .saveContactWindowChangers()
                .clubDescription()
                .makeNewDescription(newDescription)
                .saveMainWindowChangers()
                .saveChanges();
        softAssert.assertTrue(myProfilePage.isCardMaliavkyPresent(),"No such club on the page");
        List<ClubsEntity> clubNameChanged = clubService.getByName(rename);
        softAssert.assertTrue(!clubNameChanged.isEmpty(), "No such club in base");
        softAssert.assertAll();
    }
}
