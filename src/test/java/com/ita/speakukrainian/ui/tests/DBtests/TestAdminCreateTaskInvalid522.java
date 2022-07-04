package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Tasks.AddTaskPage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class TestAdminCreateTaskInvalid522 extends TestRuneWithAdmin {

    private final String header = "Українська-_-English=@#+123";
    private final String headerFilling = "Завдання на кмітливість та розвиток of attention for kids 6-9 years old!";
    private final String description = "Very cool tasks for children 8 years old and its not all, for more information call on 141242353465474123!";
    @BeforeMethod
    @Override
    public void beforeMethod(ITestContext context) {
        super.beforeMethod(context);
        new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickAdministrationButtonInDropdown()
                .clickTaskButton()
                .clickAddTaskButton();
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

    @Test()
    @Description("Verify that admin can't create a task without an image on 'Додайте завдання' page")
    @Issue("TUA-522")
    public void verifyAdminCantCreateTaskWithoutAnImage(){

        var addTaskPage = new AddTaskPage(driver);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(addTaskPage.AllFieldIsEmpty(), "Fields are not empty");

        addTaskPage.fillDateFieldFuture();
        softAssert.assertFalse(addTaskPage.dateFieldIsEmpty(), "Date was not added");

        addTaskPage.fillNameField(header);
        softAssert.assertFalse(addTaskPage.nameFieldIsEmpty(), "Title was not added");

        addTaskPage.fillHeaderField(headerFilling);
        softAssert.assertFalse(addTaskPage.headerFieldIsEmpty(), "Header was not added");

        addTaskPage.fillDescriptionField(description);
        softAssert.assertFalse(addTaskPage.isDescriptionFieldEmpty(), "Description was not added");

        addTaskPage.clickSelectChallenge().clickDniproChallenge();
        softAssert.assertFalse(addTaskPage.isChallengeAdded(), "Challenge was not chosen");

        addTaskPage.clickSave();
        softAssert.assertEquals(addTaskPage.errorMassageIsAppearing(),"picture не може бути пустим", "error massage is not the same");

        softAssert.assertAll();

    }

    @Test()
    @Description("Verify that admin can't create a task without choosing any challenge on 'Додайте завдання' page")
    @Issue("TUA-526")
    public void verifyAdminCantCreateTaskWithoutChallenge(){
        var addTaskPage = new AddTaskPage(driver);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(addTaskPage.AllFieldIsEmpty(), "Fields are not empty");

        addTaskPage.fillDateFieldFuture();
        softAssert.assertFalse(addTaskPage.dateFieldIsEmpty(), "Date was not added");

        addTaskPage.addImage(valueProvider.getSunFlower());
        softAssert.assertTrue(addTaskPage.checkIsImageAdded(), "Image was not added");

        softAssert.assertEquals(addTaskPage.getUploadedImageBase64(), getImageDataBase64(valueProvider.getSunFlower()), "Image was not the same");

        addTaskPage.fillNameField(header);
        softAssert.assertFalse(addTaskPage.nameFieldIsEmpty(), "Title was not added");

        addTaskPage.fillHeaderField(headerFilling);
        softAssert.assertFalse(addTaskPage.headerFieldIsEmpty(), "Header was not added");

        addTaskPage.fillDescriptionField(description);
        softAssert.assertFalse(addTaskPage.isDescriptionFieldEmpty(), "Description was not added");

        addTaskPage.clickSave();
        softAssert.assertEquals(addTaskPage.errorMassageIsAppearing(),"Please, select challenge", "error massage is not the same");

        softAssert.assertAll();
    }
}
