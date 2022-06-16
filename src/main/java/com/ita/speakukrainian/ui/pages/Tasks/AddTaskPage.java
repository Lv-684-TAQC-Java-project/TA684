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
import java.io.IOException;
import java.util.Base64;

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
    @FindBy(xpath="//*[@id='root']/section/section/main/div/form/div[2]/div[2]/div/div/span/div/div[1]")
    private WebElement image;
    @FindBy(id="picture")
     private WebElement inputImage;
    @FindBy(xpath = "//*[@class=//*[@class=\"ant-select-selection-placeholder\"]]")
    private WebElement challengeDropDownForVerifyEmptyField;
    @FindBy(xpath = "//*[@id=\"challengeId\"]")
    private WebElement challengeDropDownForClick;
    @FindBy(xpath ="//*[text()=\"Зберегти\"]")
    private WebElement saveChanges;
    @FindBy(xpath = "//*[@class=\"ant-message-custom-content ant-message-warning\"]")
    private WebElement errorMassage;


    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    @Step("verify that date field is empty")
    public boolean dateFieldIsEmpty() {
        boolean isEmpty;
        if (dateField.getAttribute("value").equals("")) {

            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("verify that header field is empty")
    public boolean headerFieldIsEmpty() {
        boolean isEmpty;
        if (headerField.getAttribute("value")==null) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }
    @Step("verify that name field is empty")
    public boolean nameFieldIsEmpty() {
        boolean isEmpty;
        if (nameField.getAttribute("value").equals("")) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("verify that description field is empty")
    public boolean descriptionFieldIsEmpty() {
        boolean isEmpty;

        if (descriptionField.getAttribute("value") == null) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("verify that description field is empty")
    public boolean descriptionFieldIsEmpty1() {
        boolean isEmpty;
        if (descriptionField.getAttribute("value").equals("")) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("verify that title field is empty")
    public boolean titleFieldIsEmpty() {
        boolean isEmpty;
        if (titleField.getAttribute("value") == null) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("verify that challenge popup is not selected ")
    public boolean challengeDropDownIsNotSelected() {
        boolean isEmpty;
        if (challengeDropDownForVerifyEmptyField.getAttribute("value").equals("")) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("verify that all field is empty")
    public boolean AllFieldIsEmpty() {
        boolean isEmpty;
        if (dateFieldIsEmpty()&&nameFieldIsEmpty()&&descriptionFieldIsEmpty()&& challengeDropDownIsNotSelected()&&titleFieldIsEmpty()) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("fill date field present date")
    public AddTaskPage fillDateField(){
        DateProvider dateProvider = new DateProvider();
        dateField.click();
        dateField.sendKeys(dateProvider.date());
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


    @Step("fill name field")
    public AddTaskPage fillNameField(String name){
        nameField.sendKeys(name);
        return this;
    }

    @Step("fill description field")
    public AddTaskPage fillDescriptionField(String description){
        descriptionField.sendKeys(description);
        sleep(3000);
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
        sleep(10000);
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
        if (errorMassage.isDisplayed()) {
            return true;
        }
        else return false;
    }

    @Step("Take the image")
    public String takeSRCImageFromSite() {
        WebElement image = driver.findElement(By.xpath("//*[@id=\"root\"]/section/section/main/div/form/div[2]/div[2]/div/div/span/div/div[1]/div/div/span/a/img"));
        String s = image.getAttribute("src");
        String dataForCompare = s.replace("data:image/png;base64,", "");
        return dataForCompare;
    }

    @Step("Get data of initial image")
    public String getImageData(){
        File inputFile = new File("src/test/resources/img2.png");

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
//    BufferedImage img1 = ImageIO.read(new File("D:\\Projects\\TA684\\src\\test\\resources\\foto.jpg"));
//    Base64.getEncoder().encodeToString()
//        img1.toString();

}
