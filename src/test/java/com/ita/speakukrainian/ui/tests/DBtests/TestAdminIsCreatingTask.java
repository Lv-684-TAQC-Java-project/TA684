package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Tasks.AddTaskPage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import com.ita.speakukrainian.utils.jdbc.entity.TasksEntity;
import com.ita.speakukrainian.utils.jdbc.services.TasksServise;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class TestAdminIsCreatingTask extends TestRuneWithAdmin {
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

    @Test()
    @Description("Verify that admin can't create a task with invalid data in 'Назва' field on 'Додайте завдання' page")
    @Issue("TUA-523")
    public void CreatingTackWithInvalidNameData() throws Exception {
        var addTaskPage = new AddTaskPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(addTaskPage.dateFieldIsEmpty(), "Fields is not empty");
        addTaskPage.addImage();
        softAssert.assertTrue(addTaskPage.checkIsImageAdded(), "Image was not added");
            addTaskPage.takeSnapShot();
            softAssert.assertTrue(addTaskPage.compareImages(), "Image was not the same");
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
        String [] array = new String[]{"ъэы", "ผม", "Ÿ", "ðъэы", "ผม", "Ÿ", "ðъэы", "ผม", "Ÿ", "ðъэы", "ผม", "Ÿ", "ð"};
        softAssert.assertTrue(addTaskPage.AllFieldIsEmpty(),"verify all field is empty");
        addTaskPage.fillDateField().addImage();
        softAssert.assertTrue(addTaskPage.isPhotoAdded());
        addTaskPage.fillNameField("Українська-_-English=@#+123");
        addTaskPage.fillDescriptionField("дуже круте завдання для дітей від 8 років :-) and its not all for more information call on 141242353465474123");
        addTaskPage.clickSelectChallenge().clickDniproChallenge();
        addTaskPage.clickSave();
        softAssert.assertTrue(addTaskPage.errorMassageIsDisplayed(),"is error massage displayed");
        for (int i = 0 ; i < array.length; i++) {
            addTaskPage.clearTitleField().fillTitleField(array[i]).clickSave();
        }
        softAssert.assertTrue(addTaskPage.errorMassageIsDisplayed(),"is error massage displayed");
        addTaskPage.clearTitleField().fillTitleField("dsfsdfsdgdfghdfggjhdghjksghfgdfgdfgdfgg").clickSave();
        softAssert.assertTrue(addTaskPage.errorMassageIsDisplayed(),"is error massage displayed");
        boolean tasksIsNotAdded = true;
        array = new String[]{"ъэы", "ผม", "Ÿ", "ðъэы", "ผม", "Ÿ", "ðъэы", "ผม", "Ÿ", "ðъэы", "ผม", "Ÿ", "ð","Українська-_-English=@#+123"};
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
