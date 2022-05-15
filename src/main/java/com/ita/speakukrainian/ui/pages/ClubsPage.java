package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.popup.ExtendedSearchCityDistrictPopUp;
import com.ita.speakukrainian.ui.popup.ExtendedSearchCityPopUp;
import com.ita.speakukrainian.ui.popup.ExtendedSearchNearestMetroStationPopUp;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClubsPage extends BasePage {
    private HeaderMenuComponent headerMenuComponent;
    private ExtendedSearchComponent extendedSearchComponent;

    @FindBy(css = "#basic_age input")
    private WebElement ageInputClubs;
    @FindBy(xpath = "//*[@id=\"basic_isOnline\"]/label/span[1]/input")
    private WebElement availableOnline;
    @FindBy(xpath = "//span[contains(.,'Центр')]")
    private WebElement checkedToCenterButton;
    @FindBy(css = "[title='Розширений пошук']")
    private WebElement extendedSearchButton;
    @FindBy(xpath = "//*[@class = \"ant-layout-sider ant-layout-sider-dark club-list-sider\"]")
    private WebElement extendSearchMenu;
    @FindBy(xpath = "//*[@id=\"basic_isCenter\"]/label[2]/span[1]/input")
    private WebElement centreRadioButton;
    @FindBy(xpath = "//*[@id=\"basic\"]/div[2]/div[2]/div/div/div/div")
    private WebElement cityPopUp;
    @FindBy(xpath = "//*[@id = \"basic_districtName\"]")
    private WebElement cityDistrictPopUp;
    @FindBy(xpath = "//*[@id=\"basic\"]/div[4]/div[2]/div/div/div/div/span[1]")
    private WebElement metroStationPopUp;

    public ClubsPage(WebDriver driver) {
        super(driver);
        headerMenuComponent = new HeaderMenuComponent(driver);
        extendedSearchComponent = new ExtendedSearchComponent(driver);
    }

    public WebElement getCityPopUP() {
        return cityPopUp;
    }

    public WebElement getCityDistrictPopUp() {
        return cityDistrictPopUp;
    }

    public WebElement getMetroStationPopUp() {
        return metroStationPopUp;
    }

    public WebElement getAgeInput() {
        return ageInputClubs;
    }

    public WebElement getCheckedToCenterButton() {
        return checkedToCenterButton;
    }

    public WebElement getCentreRadioButton() {
        return centreRadioButton;
    }

    public WebElement getAvailableOnline(){return availableOnline;}

    public WebElement getExtendSearchMenu(){
        return extendSearchMenu;
    }

    public WebElement getExtendedSearchButton(){
        return extendedSearchButton;
    }

    public ClubsPage fillInAgeInput(int age) {
        getAgeInput().sendKeys(Integer.toString(age));
        return new ClubsPage(driver);
    }

    public ExtendedSearchComponent clickCheckedToCenterButton() {
        checkedToCenterButton.click();
        return new ExtendedSearchComponent(driver);
    }

    public String readAgeInput() {
        return getAgeInput().getAttribute("value");
    }

    public ExtendedSearchComponent getExtendedSearchComponent() {
        return extendedSearchComponent;
    }

    public HeaderMenuComponent getHeaderMenuComponent() {
        return headerMenuComponent;
    }

    public boolean checkAvailableOnline(){
        try {
            getAvailableOnline().isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }
    public ClubsPage clickCentreRadioButton(){
        getCentreRadioButton().click();
        return this;
    }

    public boolean checkAvailableAgeField(){
        try {
            getAgeInput().isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public ExtendedSearchCityPopUp clickCityPopUp() {
        getCityPopUP().click();
        return new ExtendedSearchCityPopUp(driver);
    }

    public ExtendedSearchCityDistrictPopUp clickCityDistrictPopUp() {
        getCityDistrictPopUp().click();
        return new ExtendedSearchCityDistrictPopUp(driver);
    }

    public ExtendedSearchNearestMetroStationPopUp clickNearestMetroStationPopUp() {
        getMetroStationPopUp().click();
        return new ExtendedSearchNearestMetroStationPopUp(driver);
    }

    public boolean isExtendedSearchMenuDisplayed(){
        extendedSearchButton.click();
        return extendSearchMenu.isDisplayed();
    }

    public boolean isExtendedSearchMenuHidden(){
        extendedSearchButton.click();
        extendedSearchButton.click();
        try {
            extendSearchMenu.isDisplayed();
        }catch (NoSuchElementException e){
            return true;
        }
        return false;
    }

}

