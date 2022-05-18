package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCenterPopUp extends BasePage {
    @FindBy(css = ".ant-btn > span:nth-child(2)")
    private WebElement addLocation;
    @FindBy(xpath = "//*[@id=\"basic\"]/div[2]/button")
    private WebElement nextStepButton;
    @FindBy(xpath = "//*[@id=\"basic_locations\"]/div/label/span[1]/input")
    private WebElement checkbox;
    @FindBy(xpath = "//*[@id=\"basic\"]/div[1]/div[1]/div[2]/div[2]/div")
    private WebElement incorrectCenterName;

    public AddCenterPopUp(WebDriver driver) {
        super(driver);
    }

    @Step("Click next step button")
    public AddCenterPopUp clickNextStepButton() {
        scrollToElement(nextStepButton);
        sleep(2000);
        nextStepButton.click();
        return new AddCenterPopUp(driver);
    }

    public AddCenterPopUp clickCheckbox() {
        checkbox.click();
        return new AddCenterPopUp(driver);
    }
    @Step("Reading error massage")
    public String getError() {
        scrollToElement(incorrectCenterName);
        sleep(2000);
        return incorrectCenterName.getText();
    }

    /**
     * Location
     * return LocationPopUp
     */
    @Step("click button addLocation")
    public LocationPopUp clickAddLocation() {
        addLocation.click();
        return new LocationPopUp(driver);
    }
}
