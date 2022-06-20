package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Tasks.AddTaskPage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import com.ita.speakukrainian.utils.DateProvider;
import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;
import com.ita.speakukrainian.utils.jdbc.entity.TasksEntity;
import com.ita.speakukrainian.utils.jdbc.services.ClubsService;
import com.ita.speakukrainian.utils.jdbc.services.TasksServise;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class TestAdminIsCreatingTask extends TestRuneWithAdmin {

    private final String header = "Українська-_-English=@#+123";
    private final String headerFilling = "Завдання на кмітливість та розвиток of attention for kids 6-9 years old!";
    private final String description = "Very cool tasks for children 8 years old and its not all, for more information call on 141242353465474123!";
    private final String dataForNameField1 = "ъэы; ผม, Ÿ, ð";
    private final String dataForNameField2= "Good";
    private final String dataForNameField3="qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm";

    private String listString(int size){
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= size; i++) {
            list.add("a");
        }
        return String.join("", list);
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

    @Test
    @Description("Verify that admin can't create a task with invalid date on 'Додайте завдання' page")
    @Issue("TUA-521")
    public void CreatingTackWithInvalidDate(ITestContext context) {

        var addTaskPage = new AddTaskPage(driver);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(addTaskPage.AllFieldIsEmpty(), "Fields are not empty");

        addTaskPage.addImage(valueProvider.getSunFlower());
        softAssert.assertTrue(addTaskPage.checkIsImageAdded(), "Image was not added");

        softAssert.assertEquals(addTaskPage.getUploadedImageBase64(), getImageDataBase64(valueProvider.getSunFlower()), "Image was not the same");

        addTaskPage.fillNameField(header);
        softAssert.assertFalse(addTaskPage.nameFieldIsEmpty(), "Title was not added");

        addTaskPage.fillHeaderField(headerFilling);
        softAssert.assertFalse(addTaskPage.headerFieldIsEmpty(), "Header was not added");

        addTaskPage.fillDescriptionField(description);
        softAssert.assertFalse(addTaskPage.isDescriptionFieldEmpty(), "Description was not added");

        addTaskPage.clickSelectChallenge().clickDniproChallenge();
        softAssert.assertFalse(addTaskPage.isChallengeAdded(), "Challenge was not chosen");

        addTaskPage.clickSave();
        softAssert.assertEquals(addTaskPage.errorMassageIsAppearing(),"startDate must not be null", "error massage is not the same");

        DateProvider dateProvider =new DateProvider();
        addTaskPage.fillDateField(dateProvider.datePast()).clickSave();
        softAssert.assertEquals(addTaskPage.errorMassageIsAppearing(),"Дата не може бути у минулому", "error massage is not the same");

        TasksServise tasksServise = new TasksServise(context);
        List<TasksEntity> name = tasksServise.getAllTasksWhereName("Українська-_-English=@#+123");
        name.get(0);
        softAssert.assertTrue(name.get(0)==null, "Invalid Task was added");
        softAssert.assertAll();
    }

    @Test
    @Description("Verify that admin can't create a task with invalid data in 'Назва' field on 'Додайте завдання' page")
    @Issue("TUA-523")
    public void CreatingTackWithInvalidNameData(ITestContext context) {

        var addTaskPage = new AddTaskPage(driver);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(addTaskPage.AllFieldIsEmpty(), "Fields are not empty");

        DateProvider dateProvider = new DateProvider();
        addTaskPage.fillDateField(dateProvider.dateFuture());
        softAssert.assertFalse(addTaskPage.dateFieldIsEmpty(), "Date was not added");

        addTaskPage.addImage(valueProvider.getSunFlower());
        softAssert.assertTrue(addTaskPage.checkIsImageAdded(), "Image was not added");

        softAssert.assertEquals(addTaskPage.getUploadedImageBase64(), getImageDataBase64(valueProvider.getSunFlower()), "Image was not the same");

        addTaskPage.fillHeaderField(headerFilling);
        softAssert.assertFalse(addTaskPage.headerFieldIsEmpty(), "Header was not added");

        addTaskPage.fillDescriptionField(description);
        softAssert.assertFalse(addTaskPage.isDescriptionFieldEmpty(), "Description was not added");

        addTaskPage.clickSelectChallenge().clickDniproChallenge();
        softAssert.assertFalse(addTaskPage.isChallengeAdded(), "Challenge was not chosen");

        addTaskPage.clickSave();
        softAssert.assertEquals(addTaskPage.errorMassageIsAppearing(), "name must not be blank", "error massage is not the same");

        addTaskPage.fillNameField(dataForNameField1).clickSave();
        softAssert.assertEquals(addTaskPage.errorMassageIsAppearing(), "name Can't contain foreign language symbols except english", "error massage is not the same");
        addTaskPage.delTextNameField();

        addTaskPage.fillNameField(dataForNameField2).clickSave();
        softAssert.assertEquals(addTaskPage.errorMassageIsAppearing(), "name must contain a minimum of 5 and a maximum of 50 letters", "error massage is not the same");
        addTaskPage.delTextNameField();

        addTaskPage.fillNameField(dataForNameField3).clickSave();
        softAssert.assertEquals(addTaskPage.errorMassageIsAppearing(), "name must contain a minimum of 5 and a maximum of 50 letters", "error massage is not the same");

        TasksServise tasksServise = new TasksServise(context);
        List<TasksEntity> task = tasksServise.getDescription("%Very cool tasks for children 8 years old and its not all, for more information call on 141242353465474123!%");

        softAssert.assertTrue(task.get(0) == null, "Invalid Task was added");
        softAssert.assertAll();
    }

    @Test()
    @Description("Verify that admin can't create a task with invalid data in 'Заголовок' field on 'Додайте завдання' page")
    @Issue("TUA-524")
    public void cantCreateDueIncorrectDataInHeader(){
        AddTaskPage addTaskPage = new AddTaskPage(driver);
        SoftAssert softAssert = new SoftAssert();
        TasksServise tasksServise = new TasksServise();
        List<TasksEntity> tasksTable = tasksServise.getAllTasks();
        String textForTitle = "ъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ð";
        softAssert.assertTrue(addTaskPage.AllFieldIsEmpty(),"verify all field is empty");
        addTaskPage.fillDateField().addImage(valueProvider.getSunFlower());
        softAssert.assertTrue(addTaskPage.isPhotoAdded());
        addTaskPage.fillNameField(header).fillDescriptionField(description);
        addTaskPage.clickSelectChallenge().clickDniproChallenge();
        addTaskPage.clickSave();
        softAssert.assertEquals(addTaskPage.errorMassage(),"Поле 'Заголовок' не може бути пустим");
        addTaskPage.clearTitleField().fillTitleField(textForTitle).clickSave();
        softAssert.assertEquals(addTaskPage.errorMassage(),"Поле 'Заголовок' може містити тільки українські та англійські літери, цифри та спеціальні символи");
        softAssert.assertTrue(addTaskPage.errorMassageIsDisplayed(),"is error massage displayed");
        addTaskPage.clearTitleField().fillTitleField("dsfsdfsdgdfghdfggjhdghjksghfgdfgdfgdfgg").clickSave();
        softAssert.assertEquals(addTaskPage.errorMassage(),"Поле 'Заголовок' може містити мінімум 40 максимум 3000 символів");
        addTaskPage.clearTitleField().fillTitleField(listString(3001));
        softAssert.assertEquals(addTaskPage.errorMassage(),"Поле 'Заголовок' може містити мінімум 40 максимум 3000 символів");
        boolean tasksIsNotAdded = true;
        String [] array = new String[]{textForTitle,header};
        for (int i = 0 ; i < tasksTable.size() && tasksIsNotAdded;i++) {
            for (int j = 0; j < array.length; j++) {
                if (tasksTable.get(i).equals(array[j])) {
                    tasksIsNotAdded = false;
                }
            }
        }
        softAssert.assertTrue(tasksIsNotAdded);
        softAssert.assertAll();

    }
}

