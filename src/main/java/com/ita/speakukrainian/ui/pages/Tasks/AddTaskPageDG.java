package com.ita.speakukrainian.ui.pages.Tasks;

import com.ita.speakukrainian.ui.pages.BaseObjectPage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import java.io.File;

public class AddTaskPageDG extends BaseObjectPage {

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement nameField;
    @FindBy(xpath = "//*[@id=\"root\"]//div[4]/div[2]/div/div/div/div/div[2]/div[1]")
    private WebElement titleField;
    @FindBy(xpath = "//*[@id=\"root\"]//div[5]/div[2]/div/div/div/div/div[2]/div[1]")
    private WebElement descriptionField;
    @FindBy(xpath = "//*[@class=\"ant-picker-input\"]")
    private WebElement dateField;
    @FindBy(xpath = "//*[@class=\"ant-upload-list-picture-card-container\"]")
    private WebElement firstPhoto;
    @FindBy(xpath = "//*[@class=\"ant-select-selection-placeholder\"]")
    private WebElement challengePopUp;
    @FindBy(xpath = "//*[@id='startDate']")
    private WebElement dateFieldInput;
    @FindBy(css = "#picture")
    private WebElement uploadPhoto;
    @FindBy(css = "#startDate")
    private WebElement dataInputField;
    @FindBy(xpath = "//span[text()='name must contain a minimum of 5 and a maximum of 50 letters']")
    private WebElement nameErrorMassage;
    @FindBy(xpath = "//span[text()='headerText must contain a minimum of 40 and a maximum of 3000 letters']")
    private WebElement titleErrorMassage;
    @FindBy(xpath = "//span[contains(text(),'contain foreign language symbols except english')]")
    private WebElement descriptionInvalidDataErrorMassage;
    @FindBy(xpath = "//span[contains(text(),'description must contain a minimum of 40 and a maximum of 3000 letters')]")
    private WebElement descriptionCharactersQuantityErrorMessage;
    @FindBy(xpath = "//span[text()='Please, select challenge']")
    private WebElement challengeErrorMassage;
    @FindBy(xpath = "//span[text()='Оберіть челендж']")
    private WebElement emptyChallengeField;
    @FindBy(css = "#challengeId")
    private WebElement challengeField;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content'] [text()='Днипро']")
    private WebElement challengeDropDownSelectDnipro;
    @FindBy(css = "div[class*='container']")
    private WebElement uploadedPhoto;
    @FindBy(xpath = "//span[@class='ant-select-selection-item'][@title='Днипро']")
    private WebElement challengeFieldIsEntered;
    @FindBy(xpath = "//span[text()='Зберегти']")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@title='Заголовок']/../..//*[@class='ql-editor ql-blank']")
    private WebElement titleFieldInput;
    @FindBy(xpath = "//*[@title='Опис']/../..//*[@class='ql-editor ql-blank']")
    private WebElement descriptionFieldInput;

    public AddTaskPageDG(WebDriver driver) {
        super(driver);
    }

    @Step("Verify is date field is empty")
    public boolean isDateFieldInputEmpty() {
        return dataInputField.getAttribute("value").equals("");
    }

    @Step("Verify is image added")
    public boolean isImageAdded() {
        return uploadPhoto.isDisplayed();
    }

    @Step("Verify is name field is empty")
    public boolean isNameFieldInputEmpty() {
        return nameField.getAttribute("value").equals("");
    }

    @Step("Verify is title field is empty")
    public boolean isTitleFieldInputEmpty() {
        return titleFieldInput.getText().equals("");
    }

    @Step("Verify is description field is empty")
    public boolean isDescriptionFieldEmpty() {
        return descriptionFieldInput.getText().equals("");
    }

    @Step("Verify is challenge option is empty")
    public boolean isChallengeOptionEmpty() {
        return emptyChallengeField.getText().equals("Оберіть челендж");
    }

    @Step("Verify is all fields is empty")
    public boolean isAllFieldsEmpty() {
        return isDateFieldInputEmpty() &&
                !isImageAdded() &&
                isNameFieldInputEmpty() &&
                isTitleFieldInputEmpty() &&
                isDateFieldInputEmpty() &&
                isDescriptionFieldEmpty() &&
                isChallengeOptionEmpty();
    }

    @Step("Fill in date input field")
    public AddTaskPageDG fillInDateInputField(String data) {
        dataInputField.sendKeys(data);
        dataInputField.sendKeys(Keys.ENTER);
        return new AddTaskPageDG(driver);
    }

    @Step("Upload photo")
    public AddTaskPageDG uploadPhoto(String image) {
        uploadPhoto.sendKeys(new File(image).getAbsolutePath());
        return this;
    }

    @Step("Fill in name input field")
    public AddTaskPageDG fillInNameField(String text) {
        nameField.sendKeys(text);
        return this;
    }

    @Step("Fill in title input field")
    public AddTaskPageDG fillInTitleField(String text) {
        titleField.sendKeys(text);
        return this;
    }

    @Step("Fill in description input field")
    public AddTaskPageDG fillInDescriptionField(String text) {
        descriptionField.sendKeys(text);
        return this;
    }

    @Step("Get value from date input field")
    public String getValueDateField() {
        return dataInputField.getAttribute("value");
    }

    @Step("Verify is challenge selected")
    public boolean isChallengeFieldSelected() {
        return challengeFieldIsEntered.isDisplayed();
    }

    @Step("Click challenge field")
    public AddTaskPageDG clickChallengeField() {
        challengeField.click();
        return this;
    }

    @Step("Select challenge")
    public AddTaskPageDG selectChallenge() {
        challengeDropDownSelectDnipro.click();
        sleep(500);
        return this;
    }

    @Step("Click save button")
    public AddTaskPageDG clickSaveButton() {
        saveButton.click();
        sleep(500);
        return this;
    }

    @Step("Verify is name error massage is displayed")
    public boolean isNameErrorMassageDisplayed() {
        return nameErrorMassage.isDisplayed();
    }

    @Step("Verify is title error massage is displayed")
    public boolean isTitleErrorMassageDisplayed() {
        try {
            titleErrorMassage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Step("Verify is description invalid data error massage is displayed")
    public boolean isDescriptionInvalidDataErrorMassageDisplayed() {
        return descriptionInvalidDataErrorMassage.isDisplayed();
    }

    @Step("Verify is description quantity of characters error massage is displayed")
    public boolean isDescriptionCharactersQuantityErrorMessageDisplayed() {
        try {
            descriptionCharactersQuantityErrorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Step("Verify is challenge not select error massage displayed")
    public boolean isChallengeErrorMassageDisplayed() {
        return challengeErrorMassage.isDisplayed();
    }

    @Step("Verify is image added")
    public boolean isAddedImageDisplayed() {
        return uploadedPhoto.isDisplayed();
    }

    @Step("Clear title field input")
    public AddTaskPageDG clearTitleField() {
        titleField.clear();
        return this;
    }

    @Step("Clear description field input")
    public AddTaskPageDG clearDescriptionField() {
        descriptionField.clear();
        return this;
    }

}
