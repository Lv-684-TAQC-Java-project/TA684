package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Tasks.AddTaskPage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import com.ita.speakukrainian.utils.jdbc.entity.ChallengesEntity;
import com.ita.speakukrainian.utils.jdbc.entity.TasksEntity;
import com.ita.speakukrainian.utils.jdbc.services.ChallengesService;
import com.ita.speakukrainian.utils.jdbc.services.TasksServise;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class VerifyAdminCreateTaskValidData520 extends TestRuneWithAdmin {

    private final String TitleData50Symbols = RandomStringUtils.randomAlphabetic(50);
    private final String TitleData100Symbols = RandomStringUtils.randomAlphabetic(100);
    private final String name="Математика в UA "+RandomStringUtils.randomAlphabetic(5);

    @Step("Get data of initial image")
    public String getImageDataBase64(File inputFile) {
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

    @Description("Verify that admin can create a task with valid data on 'Додайте завдання' page")
    @Test(description = "TUA-520")
    @Issue("TUA-520")
    public void CreatingTackWithValidData() {
        var addTaskPage = new AddTaskPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(addTaskPage.AllFieldIsEmpty(), "Fields are not empty");
        addTaskPage.fillDateFieldFuture();
        softAssert.assertFalse(addTaskPage.dateFieldIsEmpty(), "Date was not added");
        addTaskPage.addImage(valueProvider.getSunFlower());
        softAssert.assertTrue(addTaskPage.checkIsImageAdded(), "Image was not added");
        softAssert.assertEquals(addTaskPage.getUploadedImageBase64(), getImageDataBase64(valueProvider.getSunFlower()), "Image was not the same");
        addTaskPage.fillNameField(name);
        softAssert.assertEquals(addTaskPage.nameFieldValue(), name);
        addTaskPage.fillHeaderField(TitleData50Symbols);
        softAssert.assertEquals(addTaskPage.TextHeaderField(), TitleData50Symbols);
        addTaskPage.fillDescriptionField(TitleData100Symbols);
        softAssert.assertEquals(addTaskPage.TextDescriptionField(), TitleData100Symbols);
        addTaskPage.clickSelectChallenge().clickDniproChallenge();
        String nameChallenge=addTaskPage.getAddTaskPageDropDown().TextChallenge();
        softAssert.assertFalse(addTaskPage.isChallengeAdded(), "Challenge was not chosen");
        addTaskPage.clickSave();
        TasksServise tasksServise=new TasksServise();
        List<TasksEntity> taskList = tasksServise.getAllTasksWhereName(name);
        TasksEntity first = taskList.get(0);
        softAssert.assertEquals(first.getDescription(),"<p>"+TitleData100Symbols+"</p>");
        softAssert.assertEquals(first.getName(),name);
        softAssert.assertEquals(first.getPicture(),"/upload/tasks/img2.png");
        softAssert.assertEquals(first.getHeaderText(),"<p>"+TitleData50Symbols+"</p>");
        Long idChallenge=first.getChallengeId();
        softAssert.assertEquals(first.getChallengeId(),241);
        ChallengesService challengesService=new ChallengesService();
        List<ChallengesEntity> challengesList = challengesService.getMameWhereId(idChallenge);
        ChallengesEntity second = challengesList.get(0);
        softAssert.assertEquals(second.getName(),nameChallenge);
        softAssert.assertAll();
    }
}
