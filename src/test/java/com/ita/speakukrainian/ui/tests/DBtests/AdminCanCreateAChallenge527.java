package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.pages.ChallengesPages.AddChallengePage;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import com.ita.speakukrainian.utils.jdbc.entity.ChallengesEntity;
import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;
import com.ita.speakukrainian.utils.jdbc.entity.DistrictEntity;
import com.ita.speakukrainian.utils.jdbc.services.ChallengesService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Random;

public class AdminCanCreateAChallenge527 extends TestRuneWithAdmin {
    private final String expected = "У виконання гопака включаються елементи хореографічної імпровізації стрибки присідання обертання й інших віртуозних танцювальних рухів Існують різн варіанти гопака сольний парний руповий";
    private Random random = new Random();
    private final int number = random.nextInt(100);

    @BeforeMethod
    @Override
    public void beforeMethod(ITestContext context) {
        super.beforeMethod(context);
        new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickAdministrationButtonInDropdown()
                .clickChallengeInAdministrationButton()
                .clickAddChallengesButton();
    }

    @Step("Get data of initial image")
    public String getImageDataBase64(File inputFile){
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(inputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String encodedString = Base64
                .getEncoder()
                .encodeToString(fileContent);
        return encodedString;
    }

    @Description("Verify that admin can create a challegne with valid data 'Додайте челендж' page")
    @Test(description = "TUA-527")
    @Issue("TUA-527")
    public void TestVerifyAllFieldsEmpty() {
        SoftAssert softAssert = new SoftAssert();
        var addChallengePage = new AddChallengePage(driver);
        String NameValue = addChallengePage
                .clickChallengeName()
                .getChallengeNameValue();
        softAssert.assertEquals(NameValue, "");
        String NumberValue = addChallengePage
                .clickSortNumber()
                .getSortNumberValue();
        softAssert.assertEquals(NumberValue, "");
        String TitleValue = addChallengePage
                .clickChallengeTitle()
                .getChallengeTitleValue();
        softAssert.assertEquals(TitleValue, "");
        List<String> depictionChallengeOne = addChallengePage
                .getDepictionChallenge();
        String GetListDepictionOne = String.join("\n", depictionChallengeOne);
        softAssert.assertEquals(GetListDepictionOne, "");
        String NumberValueTwo = addChallengePage
                .addChallengeSortNumber("123" + number)
                .getSortNumberValue();
        System.out.println("123" + number);
        softAssert.assertEquals(NumberValueTwo, "123" + number);
        String NameValueTwo = addChallengePage
                .addChallengeName("Гопак")
                .getChallengeNameValue();
        softAssert.assertEquals(NameValueTwo, "Гопак");
        String TitleValueTwo = addChallengePage
                .addChallengeTitle("Присідання")
                .getChallengeTitleValue();
        softAssert.assertEquals(TitleValueTwo, "Присідання");
        addChallengePage.addDepictionChallenge(expected);
        List<String> depictionChallenge = addChallengePage.getDepictionChallenge();
        String GetListDepiction = String.join("\n", depictionChallenge);
        softAssert.assertEquals(GetListDepiction, expected);
        addChallengePage.addImage(valueProvider.getSunFlower());
        softAssert.assertTrue(addChallengePage.checkIsImageAdded(), "Image was not added");
        softAssert.assertEquals(addChallengePage.getUploadedImageBase64() , getImageDataBase64(valueProvider.getSunFlower()));
        addChallengePage.clickButtonSaveChallenge();
        ChallengesService challengesService=new ChallengesService();
        List<ChallengesEntity> challengesList = challengesService.getAll("123",number);
        ChallengesEntity first = challengesList.get(0);
        softAssert.assertEquals(first.getDescription(),"<p>"+expected+"</p>");
        softAssert.assertEquals(first.getName(),"Гопак");
        softAssert.assertEquals(first.getPicture(),"/upload/challenges/img2.png");
        softAssert.assertEquals(first.getSortNumber(),"123"+number);
        softAssert.assertEquals(first.getTitle(),"Присідання");
        softAssert.assertAll();


    }


    }

