package com.ita.speakukrainian.ui.pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClubsPage extends BasePage {

    private final ExtendedSearchComponent extendedSearchComponent;

    @FindBy(xpath = "//*[@class = \"ant-layout-sider ant-layout-sider-dark club-list-sider\"]")
    private WebElement advancedSearchField;
    @FindBy(xpath = "//*[@id=\"root\"]/section/section/main/section/section")
    private WebElement mainSection;
    @FindBy(css = "[title='Розширений пошук']")
    private WebElement extendedSearchButton;


    public ClubsPage(WebDriver driver) {
        super(driver);
        this.extendedSearchComponent = new ExtendedSearchComponent(driver);
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

