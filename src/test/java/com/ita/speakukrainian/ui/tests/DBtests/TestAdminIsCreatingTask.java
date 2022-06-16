package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Tasks.AddTaskPage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        softAssert.assertTrue(addTaskPage.AllFieldIsEmpty());
        addTaskPage.fillDateField("2022-11-11");
        addTaskPage.fillNameField("Українська-_-English=@#+123");
        addTaskPage.fillDescriptionField("дуже круте завдання для дітей від 8 років :-) and its not all for more information call on 141242353465474123");
        addTaskPage.clickSelectChallenge().clickDniproChallenge();
        addTaskPage.clickSave();

        softAssert.assertAll();

    }
}