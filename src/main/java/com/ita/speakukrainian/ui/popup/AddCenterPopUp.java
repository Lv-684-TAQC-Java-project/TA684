package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.HomePage;
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
    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div/div[2]/button")
    private WebElement closeAddCentre;

    public AddCenterPopUp(WebDriver driver) {
        super(driver);
    }

    @Step("Click Next Step 'Нступний крок' button")
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
        waitForElement(incorrectCenterName);
        scrollToElement(incorrectCenterName);
        return incorrectCenterName.getText();
    }

    /**
     * Location
     * return LocationPopUp
     */
    @Step("Click button AddLocation 'Додати локацію'")
    public LocationPopUp clickAddLocation() {
        addLocation.click();
        return new LocationPopUp(driver);
    }

    public HeaderMenuComponent closeAddCentrePopUp (){
        closeAddCentre.click();
        return new HeaderMenuComponent(driver);
    }
}
