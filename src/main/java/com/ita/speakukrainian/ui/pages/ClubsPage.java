package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.dropdowns.ExtendedSearchCityDistrictDropDown;
import com.ita.speakukrainian.ui.dropdowns.ExtendedSearchCityDropDown;
import com.ita.speakukrainian.ui.dropdowns.ExtendedSearchNearestMetroStationDropDown;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
    @FindBy(xpath="//*[@id=\"basic_isCenter\"]/label[1]/span[1]/input")
    private WebElement clubRadioButton;
    @FindBy(xpath = "//*[@id=\"basic_isCenter\"]/label[2]/span[1]/input")
    private WebElement centreRadioButton;

    @FindBy(xpath ="//div[@id='basic_isCenter']/label[@class='ant-radio-wrapper ant-radio-wrapper-checked ant-radio-wrapper-in-form-item']/span[contains(text(),'Центр')]")
    private WebElement centreRadioButtonIsPushed;
    @FindBy(xpath = "//*[@id=\"basic\"]/div[2]/div[2]/div/div/div/div")
    private WebElement cityPopUp;
    @FindBy(xpath = "//*[@id = \"basic_districtName\"]")
    private WebElement cityDistrictPopUp;
    @FindBy(xpath = "//*[@id=\"basic\"]/div[4]/div[2]/div/div/div/div/span[1]")
    private WebElement metroStationPopUp;
    @FindBy(xpath = "//div[@id='root']/section/section/main/section/section/section/div/div[2]/label")
    private WebElement sortMenuBarButton;
    @FindBy ( css=".content-center-list.false")
    private WebElement listOfCentres;
    @FindBy(xpath = "//div[contains(@class,'content-clubs-list content-clubs-block')]/div")
    private List<WebElement> clubsCard;
    @FindBy(xpath = "//div[contains(@class,'content-center-list content-center-block')]/div")
    private List<WebElement> centersCard;
    @FindBy(xpath = "//section[@class='ant-layout ant-layout-has-sider club-list']")
    private WebElement extendedSearchPage;
    @FindBy(xpath = "//span[text()='за алфавітом']")
    private WebElement sortAlphabeticallyButton;
    @FindBy(xpath = "//*[@id='basic']/div[2]/div[2]/div/div/div/span[2]")
    private WebElement clearButton;
    @FindBy(xpath = "//span[@class='anticon anticon-arrow-up control-sort-arrow']")
    private WebElement arrowUpButton;




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

    public WebElement getClubRadioButton() {
        return clubRadioButton;
    }
    public WebElement getCenterRadioButtonIsPushed() {
        return centreRadioButtonIsPushed;
    }

    public WebElement getSortMenuBarButton(){
        return sortMenuBarButton;
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

    public WebElement getListOfCentres(){
        return listOfCentres;
    }

    public List<WebElement> getCentersCard() {
        sleep(1000);
        return centersCard;
    }

    @Step("Fill in age")
    public ClubsPage fillInAgeInput(int age) {
        getAgeInput().sendKeys(Integer.toString(age));
        return new ClubsPage(driver);
    }

    public ExtendedSearchComponent clickCheckedToCenterButton() {
        checkedToCenterButton.click();
        return new ExtendedSearchComponent(driver);
    }

    @Step("Read age")
    public String readAgeInput() {
        return getAgeInput().getAttribute("value");
    }

    public ExtendedSearchComponent getExtendedSearchComponent() {
        return extendedSearchComponent;
    }

    public HeaderMenuComponent getHeaderMenuComponent() {
        return headerMenuComponent;
    }

    @Step("Check available online is hidden")
    public boolean checkAvailableOnline(){
        try {
            getAvailableOnline().isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    @Step("Click center radio button in extended search menu")
    public ClubsPage clickCentreRadioButton(){
        getCentreRadioButton().click();
        return this;
    }

    @Step("Check available online field is displayed")
    public boolean checkAvailableAgeField(){
        try {
            getAgeInput().isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    @Step("Open city dropdown")
    public ExtendedSearchCityDropDown openCityDropDown() {
        getCityPopUP().click();
        return new ExtendedSearchCityDropDown(driver);
    }

    @Step("Open city district dropdown")
    public ExtendedSearchCityDistrictDropDown openCityDistrictDropDown() {
        getCityDistrictPopUp().click();
        return new ExtendedSearchCityDistrictDropDown(driver);
    }

    @Step("Open nearest metro station dropdown")
    public ExtendedSearchNearestMetroStationDropDown openNearestMetroStationDropDown() {
        getMetroStationPopUp().click();
        return new ExtendedSearchNearestMetroStationDropDown(driver);
    }

    @Step("Check extended search menu is displayed")
    public boolean isExtendedSearchMenuDisplayed(){
        extendedSearchButton.click();
        return extendSearchMenu.isDisplayed();
    }

    @Step("Check extended search menu is hidden")
    public boolean isExtendedSearchMenuHidden(){
        extendedSearchButton.click();
        try {
            extendSearchMenu.isDisplayed();
        }catch (NoSuchElementException e){
            return true;
        }
        return false;
    }
    @Step("Click button for sorting centers as list")
    public ClubsPage clickSortMenuBarButton() {
        getSortMenuBarButton().click();
        sleep(1000);
        return new ClubsPage(driver);
    }
    @Step("Verify is 'Гурток' radio-button selected")
    public boolean IsClubButtonSelected(){
        return getClubRadioButton().isSelected();
    }
    @Step("Verify is 'Цент' radio-button selected")
    public boolean IsCentreButtonSelected(){
        return getCentreRadioButton().isSelected();
    }
    @Step("Verify is Centres was sorted as list")
    public boolean IsCentresSortedAsList(){
        try{
            getListOfCentres().isEnabled();
        }
        catch (NoSuchElementException e){
            return false;
        }
        return true;
    }
    @Step("Clear age field")
    public ClubsPage clearAgeField() {
        getAgeInput().sendKeys(Keys.BACK_SPACE);
        return new ClubsPage(driver);
    }
    @Step("Double click on age field ")
    public ClubsPage doubleClickAgeField() {
        Actions actions = new Actions(driver);
        actions.doubleClick(getAgeInput()).perform();
        return new ClubsPage(driver);
    }
    @Step("Verify is extended search page displayed")
    public boolean isExtendedSearchPageDisplayed() {
       return extendedSearchPage.isDisplayed();

    }
    @Step("Click sort alphabetically button")
    public ClubsPage clickSortAlphabeticallyButton() {
        sleep(2000);
        sortAlphabeticallyButton.click();
        return new ClubsPage(driver);
    }
    @Step("Click center button")
    public ClubsPage clickClearButton() {
        sleep(2000);
        clearButton.click();
        return new ClubsPage(driver);
    }
    @Step("Click arrow up button")
    public ClubsPage clickArrowUpButton() {
        sleep(2000);
        arrowUpButton.click();
        return new ClubsPage(driver);
    }


  }

