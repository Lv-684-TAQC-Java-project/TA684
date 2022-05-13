package com.ita.speakukrainian.ui.pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClubsPage extends BasePage {
<<<<<<< HEAD

    private final ExtendedSearchComponent extendedSearchComponent;

    @FindBy(xpath = "//*[@class = \"ant-layout-sider ant-layout-sider-dark club-list-sider\"]")
    private WebElement advancedSearchField;
    @FindBy(xpath = "//*[@id=\"root\"]/section/section/main/section/section")
    private WebElement mainSection;
    @FindBy(css = "[title='Розширений пошук']")
    private WebElement extendedSearchButton;
=======
    private HeaderMenuComponent headerMenuComponent;
    private ExtendedSearchComponent extendedSearchComponent;

    @FindBy(css = "#basic_age input")
    private WebElement ageInputClubs;
    @FindBy(xpath = "//span[contains(.,'Центр')]")
    private WebElement checkedToCenterButton;
>>>>>>> 97ae32ba63552f01f8f8838bf5502e9e01c27b21


    public ClubsPage(WebDriver driver) {
        super(driver);
<<<<<<< HEAD
        this.extendedSearchComponent = new ExtendedSearchComponent(driver);
=======
        headerMenuComponent = new HeaderMenuComponent(driver);
        extendedSearchComponent = new ExtendedSearchComponent(driver);
    }

    public WebElement getAgeInput() {
        return ageInputClubs;
    }

    public ClubsPage fillInAgeInput(int age) {
        getAgeInput().sendKeys(Integer.toString(age));
        return new ClubsPage(driver);
    }

    public ExtendedSearchComponent clickcheckedToCenterButtonon() {
        checkedToCenterButton.click();
        return new ExtendedSearchComponent(driver);
    }

    public String readAgeInput() {
        return getAgeInput().getAttribute("value");
>>>>>>> 97ae32ba63552f01f8f8838bf5502e9e01c27b21
    }

    public boolean clickAndOpenExtendedSearch(){
        getExtendedSearchButton().click();
        return getAdvancedSearchField().isDisplayed();
    }

    public ExtendedSearchComponent getExtendedSearchComponent() {
        return extendedSearchComponent;
    }

    public WebElement getAdvancedSearchField(){return advancedSearchField;}

    public WebElement getMainSection(){return mainSection;}

    public WebElement getExtendedSearchButton() {
        return extendedSearchButton;
    }

        public boolean clickOpenAndCloseExtendedSearch() {
                getExtendedSearchButton().click();
                getAdvancedSearchField().isDisplayed();
            try {
                getExtendedSearchButton().click();
                getAdvancedSearchField().isDisplayed();
            }catch (NoSuchElementException e){
                return true;
            }
            return false;
        }
}

