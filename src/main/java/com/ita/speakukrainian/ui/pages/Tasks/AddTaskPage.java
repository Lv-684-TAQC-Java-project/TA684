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
    private WebElement challengeField;

    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    public boolean dateFieldIsEmpty() {
        boolean isEmpty;
        if (nameField.getAttribute("value").equals(null)) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }



}
