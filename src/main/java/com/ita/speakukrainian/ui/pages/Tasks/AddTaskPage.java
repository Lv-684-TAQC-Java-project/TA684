package com.ita.speakukrainian.ui.pages.Tasks;

import com.ita.speakukrainian.ui.dropdowns.AddTaskPageDropDown;
import com.ita.speakukrainian.ui.pages.BaseObjectPage;
import com.ita.speakukrainian.utils.DateProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class AddTaskPage extends BaseObjectPage {

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement nameField;
    @FindBy(xpath = "//*[@id=\"root\"]//div[4]/div[2]/div/div/div/div/div[2]/div[1]")
    private WebElement titleField;

    @FindBy(xpath = "//*[@id=\"root\"]/section/section/main/div/form/div[4]/div[2]/div/div/div/div/div[2]/div[1]")
    private WebElement headerField;

    @FindBy(xpath ="//*[@id=\"root\"]//div[5]/div[2]/div/div/div/div/div[2]/div[1]")
    private WebElement descriptionField;
    @FindBy(xpath = "//*[@id=\"startDate\"]")
    private WebElement dateField;
    @FindBy(xpath = "//*[@class=\"ant-upload-list-picture-card-container\"]")
    private WebElement firstPhoto;
    @FindBy(xpath = "//*[@class=\"ant-select-selection-placeholder\"]")
    private WebElement challengeField;
    @FindBy(xpath="//*[@id=\"root\"]/section/section/main/div/form/div[2]/div[2]/div/div/span/div/div[1]/div/div/span/a/img")
    private WebElement image;
    @FindBy(id="picture")
     private WebElement inputImage;
    @FindBy(xpath = "//*[@class=\"ant-select-selection-placeholder\"]")
    private WebElement challengeDropDownForVerifyEmptyField;
    @FindBy(xpath = "//*[@id=\"challengeId\"]")
    private WebElement challengeDropDownForClick;
    @FindBy(xpath ="//*[text()=\"Зберегти\"]")
    private WebElement saveChanges;
    @FindBy(xpath = "//*[@class=\"ant-message-custom-content ant-message-warning\"]")
    private WebElement errorMassage;
    @FindBy(xpath = "//*[@class=\"ant-upload-list-picture-card-container\"]")
    private WebElement firstPhotoContainer;

    @FindBy(xpath = "//*[@id=\"root\"]/section/section/main/div/form/div[6]/div[2]/div/div/div/div/span[2]")
    private WebElement chosenDniproChallenge;

    @FindBy(xpath = "//div[@class = 'ant-picker-input']/span[2]")
    private WebElement dateFieldCleaner;


    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    @Step("verify that date field is empty")
    public boolean dateFieldIsEmpty() {
        return dateField.getAttribute("value").equals("");
    }

    @Step("verify that header field is empty")
    public boolean headerFieldIsEmpty() {
        return headerField.getText().equals("");
    }
    @Step("That header field text")
    public String TextHeaderField() {
        return headerField.getText();
    }
    @Step("verify that name field is empty")
    public boolean nameFieldIsEmpty() {
        return nameField.getAttribute("value").equals("");
    }

    @Step("verify that name field value")
    public String nameFieldValue() {
        return nameField.getAttribute("value");
    }

    @Step("verify that description field is empty")
    public boolean descriptionFieldIsEmpty() {
        return descriptionField.getAttribute("value") == null;
    }

    @Step("verify that description field is empty")
    public boolean isDescriptionFieldEmpty() {
        return descriptionField.getText().equals("");
    }
    @Step("get that description text")
    public String TextDescriptionField() {
        return descriptionField.getText();
    }

    @Step("verify that title field is empty")
    public boolean titleFieldIsEmpty() {
        return titleField.getAttribute("value") == null;
    }

    @Step("verify that challenge popup is not selected ")
    public boolean challengeDropDownIsNotSelected() {
        return challengeDropDownForVerifyEmptyField.getAttribute("value") == null;
    }

    @Step("verify that all field is empty")
    public boolean AllFieldIsEmpty() {
        return dateFieldIsEmpty()&&nameFieldIsEmpty()&&descriptionFieldIsEmpty()&& challengeDropDownIsNotSelected()&&titleFieldIsEmpty();
    }

    @Step("verify that photo was added")
    public boolean isPhotoAdded() {
        return firstPhotoContainer.isEnabled();
    }

    @Step("verify that challenge was added")
    public boolean isChallengeAdded() {
        sleep(3000);
        return chosenDniproChallenge.getText().equals("Дніпро");
    }


    @Step("fill date field present date")
    public AddTaskPage fillDateField(){
        DateProvider dateProvider = new DateProvider();
        dateField.click();
        dateField.sendKeys(dateProvider.dateFuture());
        dateField.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("fill date field present date")
    public AddTaskPage fillDateField(String date){
        dateField.click();
        dateField.sendKeys(date);
        dateField.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("fill date field present date")
    public AddTaskPage fillDateFieldFuture(){
        DateProvider dateProvider = new DateProvider();
        dateField.click();
        dateField.sendKeys(dateProvider.dateFuture());
        dateField.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("fill title field")
    public AddTaskPage fillTitleField(String title){
        titleField.sendKeys(title);
        return this;
    }

    @Step("fill header field")
    public AddTaskPage fillHeaderField(String header){
        headerField.sendKeys(header);
        sleep(3000);
        return this;
    }

    @Step("clear title field")
    public AddTaskPage clearTitleField(){
        titleField.clear();
        return this;
    }

    @Step("clear name field")
    public AddTaskPage clearNameField(){
        nameField.clear();
        return this;
    }

    @Step("clear date field")
    public AddTaskPage clearDateField(){
        dateFieldCleaner.clear();
        return this;
    }

    @Step("fill name field")
    public AddTaskPage fillNameField(String name){
        nameField.sendKeys(name);
        sleep(3000);
        return this;
    }

    @Step("fill description field")
    public AddTaskPage fillDescriptionField(String description){
        descriptionField.sendKeys(description);
        sleep(5000);
        return this;
    }

    @Step("click challenge dropdown")
    public AddTaskPageDropDown clickSelectChallenge() {
        challengeDropDownForClick.click();
        AddTaskPageDropDown addTaskPageDropDown = new AddTaskPageDropDown(driver);
        return new AddTaskPageDropDown(driver);
    }

    @Step("click save changes")
    public AddTaskPage clickSave() {
        saveChanges.click();
        sleep(2000);
        return this;
    }
    @Step("Add image")
    public void addImage(File img) {
        inputImage.sendKeys(img.getAbsolutePath());
        sleep(3000);
    }
    @Step ("Verify that image was added")
    public boolean checkIsImageAdded(){
        if (image.isDisplayed()) {
            return true;
        }
        else return false;
    }

    @Step ("Verify that image was added")
    public boolean errorMassageIsDisplayed(){
            return errorMassage.isDisplayed();
    }

    @Step ("Verify that error massage was appeared")
    public String errorMassageIsAppearing(){
        return errorMassage.getText();
    }

    @Step("Take the image")
    public String getUploadedImageBase64() {
        String s = image.getAttribute("src");
        String dataForCompare = s.replace("data:image/png;base64,", "");
        return dataForCompare;
    }
    @Step ("Verify that image was added")
    public String errorMassage(){
        return errorMassage.getText();
    }

    @Step ("get AddTaskPageDropDown")
    public AddTaskPageDropDown getAddTaskPageDropDown(){
        return new AddTaskPageDropDown(driver);
    }

}


