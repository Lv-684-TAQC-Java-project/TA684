package com.ita.speakukrainian.ui.tests.DBtests;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.Tasks.AddTaskPage;
import com.ita.speakukrainian.ui.testruners.TestRuneWithAdmin;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAdminIsCreatingTask extends TestRuneWithAdmin {

    String header = "Українська-_-English=@#+123";
    String description = "дуже круте завдання для дітей від 8 років :-) and its not all for more information call on 141242353465474123";

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
        softAssert.assertEquals(addTaskPage.takeSRCImageFromSite(), addTaskPage.getImageData(), "Image was not the same");

        softAssert.assertTrue(addTaskPage.headerFieldIsEmpty(), "Header was not empty");
        addTaskPage.fillHeaderField(header);
        softAssert.assertFalse(addTaskPage.headerFieldIsEmpty(), "Header was not added");

        softAssert.assertTrue(addTaskPage.descriptionFieldIsEmpty1(), "Description was not empty");
        addTaskPage.fillDescriptionField(description);
        softAssert.assertFalse(addTaskPage.descriptionFieldIsEmpty1(), "Description was not added");

        softAssert.assertAll();
    }


    @Test()
    @Description("Verify that admin can't create a task with invalid data in 'Заголовок' field on 'Додайте завдання' page")
    @Issue("TUA-524")
    public void cantCreateDueIncorrectDataInHeader(){
        AddTaskPage addTaskPage = new AddTaskPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(addTaskPage.AllFieldIsEmpty());
        addTaskPage.fillDateField();
        addTaskPage.addImage(valueProvider.getSunFlower());
        addTaskPage.fillNameField("Українська-_-English=@#+123");
        addTaskPage.fillDescriptionField("дуже круте завдання для дітей від 8 років :-) and its not all for more information call on 141242353465474123");
        addTaskPage.clickSelectChallenge().clickDniproChallenge();
        addTaskPage.clickSave();
        softAssert.assertTrue(addTaskPage.errorMassageIsDisplayed());
        addTaskPage.fillTitleField("ъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ð");
        addTaskPage.clickSave();
        softAssert.assertTrue(addTaskPage.errorMassageIsDisplayed());
        addTaskPage.clearTitleField();
        addTaskPage.fillTitleField("dsfsdfsdgdfghdfggjhdghjksghfgdfgdfgdfgg");
        addTaskPage.clickSave();
        softAssert.assertAll();

    }
}
