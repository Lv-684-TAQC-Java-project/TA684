package com.ita.speakukrainian.ui.pages.Tasks;

import com.ita.speakukrainian.ui.pages.BaseObjectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class AddTaskPage extends BaseObjectPage {

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

    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    public boolean dateFieldIsEmpty() {
        boolean isEmpty;
        if (dateField.getAttribute("value") == null) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    public boolean nameFieldIsEmpty() {
        boolean isEmpty;
        if (nameField.getAttribute("value").equals("")) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    public boolean descriptionFieldIsEmpty() {
        boolean isEmpty;
        if (descriptionField.getAttribute("value") == null) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    public boolean titleFieldIsEmpty() {
        boolean isEmpty;
        if (titleField.getAttribute("value") == null) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    public boolean challengePopUPIsEmpty() {
        boolean isEmpty;
        if (challengePopUp.getAttribute("value") == null) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    public boolean challengePopUpIsNotSelected() {
        boolean isEmpty;
        if (challengePopUp.getAttribute("value") == null) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    public boolean AllFieldIsEmpty() {
        boolean isEmpty;
        if (dateFieldIsEmpty()&&nameFieldIsEmpty()&&descriptionFieldIsEmpty()&&challengePopUPIsEmpty()&&titleFieldIsEmpty()) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }



}
