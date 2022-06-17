package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Tasks.AddTaskPage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import com.ita.speakukrainian.utils.jdbc.entity.TasksEntity;
import com.ita.speakukrainian.utils.jdbc.services.TasksServise;
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
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class TestAdminIsCreatingTask extends TestRuneWithAdmin {
   private final String header = "Українська-_-English=@#+123";
   private final String description = "дуже круте завдання для дітей від 8 років :-) and its not all for more information call on 141242353465474123";

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
    @Description("Verify that admin can't create a task with invalid data in 'Назва' field on 'Додайте завдання' page")
    @Issue("TUA-523")
    public void CreatingTackWithInvalidNameData() {

        var addTaskPage = new AddTaskPage(driver);
        SoftAssert softAssert = new SoftAssert();

       // softAssert.assertTrue(addTaskPage.AllFieldIsEmpty(), "Fields are not empty");
        softAssert.assertTrue(addTaskPage.dateFieldIsEmpty(), "Date was not added");
        addTaskPage.fillDateField();
        softAssert.assertFalse(addTaskPage.dateFieldIsEmpty(), "Date was not added");

        addTaskPage.addImage(valueProvider.getSunFlower());
        softAssert.assertTrue(addTaskPage.checkIsImageAdded(), "Image was not added");

        softAssert.assertEquals(addTaskPage.getUploadedImageBase64(), getImageDataBase64(valueProvider.getSunFlower()), "Image was not the same");

        softAssert.assertTrue(addTaskPage.headerFieldIsEmpty(), "Header was not empty");
        addTaskPage.fillHeaderField(header);
        softAssert.assertFalse(addTaskPage.headerFieldIsEmpty(), "Header was not added");

        softAssert.assertTrue(addTaskPage.descriptionFieldIsEmpty(), "Description was not empty");
        addTaskPage.fillDescriptionField(description);
        softAssert.assertFalse(addTaskPage.descriptionFieldIsEmpty(), "Description was not added");

        //softAssert.assertTrue(addTaskPage.challengeDropDownIsNotSelected(), "Challenge was not empty");


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
//'Поле 'Заголовок' може містити мінімум 40 максимум 3000 символів
