package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Tasks.AddTaskPageDG;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import com.ita.speakukrainian.utils.jdbc.entity.TaskEntity;
import com.ita.speakukrainian.utils.jdbc.services.TaskServise;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class TestAddTask extends TestRuneWithAdmin {

    @BeforeMethod
    @Override
    public void beforeMethod(ITestContext context) {
        super.beforeMethod(context);
        new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickAdministrationButtonInDropdown()
                .clickTaskButton()
                .clickAddTaskButtonTwo();
    }

    @Test()
    @Description("Verify that admin can't create a task with invalid data in 'Опис' field on 'Додайте завдання' page")
    @Issue("TUA-525")
    public void verifyAdminCantCreateTaskWithInvalidData() {
        AddTaskPageDG addTaskPageDg = new AddTaskPageDG(driver);
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);
        TaskServise taskServise = new TaskServise();
        SoftAssert softAssert = new SoftAssert();

        final String validData = "2022-07-01";
        final String validNameData = "Test_Завдання-=@#+123";
        final String validTitleData = "Test_Завдання-=@#+123 Test_Завдання-=@#+123 Test_Завдання-=@#+123";
        final String invalidDescriptionData = "ъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ð";
        final String invalidTitleData39Symbols = RandomStringUtils.randomAlphabetic(39);
        final String invalidTitleData3001Symbols = RandomStringUtils.randomAlphabetic(3001);

        boolean isAllFieldEmpty = addTaskPageDg.isAllFieldsEmpty();
        softAssert.assertTrue(isAllFieldEmpty);

        String isDataSaved = addTaskPageDg
                .fillInDateInputField(validData)
                .getValueDateField();

        softAssert.assertEquals(validData, isDataSaved);

        boolean isImageAdd = addTaskPageDg
                .uploadPhoto(valueProvider.getImage())
                .isAddedImageDisplayed();

        softAssert.assertTrue(isImageAdd, "Image didn't add");

        boolean isChallengeFieldSelected = addTaskPageDg
                .fillInNameField(validNameData)
                .fillInTitleField(validTitleData)
                .clickChallengeField()
                .selectChallenge()
                .isChallengeFieldSelected();

        softAssert.assertTrue(isChallengeFieldSelected, "Challenge field is not selected");

        boolean isDescriptionFieldEmptyErrorMessageDisplayed = addTaskPageDg
                .clickSaveButton()
                .isDescriptionCharactersQuantityErrorMessageDisplayed();

        softAssert.assertTrue(isDescriptionFieldEmptyErrorMessageDisplayed,
                "Description field is empty you can't add task");

        boolean isDescriptionFieldInvalidDataErrorMessageDisplayed = headerMenuComponent
                .clickUserProFileButton()
                .clickAdministrationButtonInDropdown()
                .clickTaskButton()
                .clickAddTaskButtonTwo()
                .fillInDateInputField(validData)
                .uploadPhoto(valueProvider.getImage())
                .fillInNameField(validNameData)
                .fillInTitleField(validTitleData)
                .fillInDescriptionField(invalidDescriptionData)
                .clickChallengeField()
                .selectChallenge()
                .clickSaveButton()
                .isDescriptionInvalidDataErrorMassageDisplayed();

        softAssert.assertTrue(isDescriptionFieldInvalidDataErrorMessageDisplayed,
                "Description field invalid data");

        boolean isDescriptionErrorMessageDisplayed = addTaskPageDg
                .clearDescriptionField()
                .clearTitleField()
                .fillInTitleField(invalidTitleData39Symbols)
                .clickSaveButton()
                .isDescriptionCharactersQuantityErrorMessageDisplayed();

        softAssert.assertTrue(isDescriptionErrorMessageDisplayed,
                "Description field can't contains less the 40 symbols");

        boolean isDescriptionErrorMessageDisplayed2 = addTaskPageDg
                .clearTitleField()
                .fillInTitleField(invalidTitleData3001Symbols)
                .clickSaveButton()
                .isDescriptionCharactersQuantityErrorMessageDisplayed();

        softAssert.assertTrue(isDescriptionErrorMessageDisplayed2,
                "Description field can't contains more the 3001 symbols");

        List<TaskEntity> expectedTableFormDb = taskServise.getAllByName();

        softAssert.assertNotEquals(validNameData, expectedTableFormDb.get(0).getName(), "Task was added");

        softAssert.assertAll();
    }
}
