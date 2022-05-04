package com.ita.speakukrainian.ui.components;

import com.ita.speakukrainian.ui.pages.*;
import com.ita.speakukrainian.ui.popup.AddCenterPopUp;
import org.openqa.selenium.By;
import com.ita.speakukrainian.ui.popup.SingInPopup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderMenuComponent {
    protected WebDriver driver;

    @FindBy(xpath = "//div[@id='root']/section/header/div[3]/div[2]/span[2]")
    private WebElement userProFileButton;
    @FindBy(xpath = "//li[2]/span/div")
    private WebElement singInButton;
    @FindBy(xpath = "//*[@id='root']/section/header/div[1]/a/div")
    private WebElement homePageButton;
    // @FindBy(xpath = "//*[@id=\"root\"]/section/header/div[3]/div[2]/span[1]/img")
    @FindBy(css = "[title='Розширений пошук']")
    private WebElement extendedSearchButton;
    @FindBy(how = How.CSS, using= "[class*='ant-dropdown-menu-item']")
    // @FindAll(how = How.CSS, using= "[class*='ant-dropdown-menu-item']")
    private WebElement addClubButton;

    private final String avatarSelector = "//div[contains(@class,'user-profile')]//img";

    @FindBy(xpath = avatarSelector)
    private WebElement avatar;

    @FindBy(css=".ant-dropdown-menu-title-content > a")
    private WebElement myProfileButton;
    @FindBy(xpath="//li[2]/span/div")
    private WebElement addCenterButton;
    @FindBy(xpath="//div[2]/ul/li[1]/span/a")
    private WebElement clubsPageHeader;
    @FindBy(xpath = "//input[@id='rc_select_1']")
    private  WebElement searchInput;
    @FindBy(xpath = "//div[4]/div/div")
    private WebElement searchInputDropdown;



    public HeaderMenuComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * UserProFileButton
     */
    public WebElement getUserProFileButton() {
        return userProFileButton;
    }

    public WebElement getExtendedSearchButton() {
        return extendedSearchButton;
    }

    public WebElement getAddClubButton(){
        return  addClubButton;
    }

    public HeaderMenuComponent clickUserProFileButton() {
        userProFileButton.click();
        // try {
        //    Thread.sleep(2000);
        //} catch (InterruptedException e) {
         //   e.printStackTrace();
        //}
        //if (isDisplayedUserProFileButton()) {
         //   getUserProFileButton().click();
        //}
        return this;

    }

    public boolean isDisplayedUserProFileButton() {
        return userProFileButton.isDisplayed();
    }

    /**
     * SingInButton
     */
    public WebElement getSingInButton() {
        return singInButton;
    }

    public SingInPopup clickSingInButton() {
        if(isDisplayedSingInButton()) {
            singInButton.click();
        }
        return new SingInPopup(driver);
    }

    public boolean isDisplayedSingInButton() {
        return singInButton.isDisplayed();
    }

    public HomePage cliHomePage() {
        homePageButton.click();
        return new HomePage(driver);
    }

    public String getAvatarImgPath() {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(avatarSelector)));
        return avatar.getAttribute("src");
    }
    public ClubsPage clickExtendedSearchButton(){
        getExtendedSearchButton().click();
        return new ClubsPage(driver);
    }
    /**
     * AddCenter
     * @return AddCenterPopUp
     */
    public AddCenterPopUp clickAddCenterButton(){
        addCenterButton.click();
        return new AddCenterPopUp(driver);
    }

    /**
     * MyProfile
     * @return MyProfilePage
     */
    public MyProfilePage clickMyProfileButton() {
        if(isDisplayedMyProfileButton()) {
            myProfileButton.click();
        }
        return new MyProfilePage(driver);
    }

    public boolean isDisplayedMyProfileButton() {
        return myProfileButton.isDisplayed();
    }

    public AddClubPage clickAddClubButton() {
        getAddClubButton().click();
        return new AddClubPage(driver);
    }

    /**
     * Go to
     * ClubsPage
     */
    public ClubsPage clickClubsPageHeader() {
        clubsPageHeader.click();
        return new ClubsPage(driver);
    }

    /**
     * click on
     * "який гурток шукаєте?"
     */
    public HeaderMenuComponent clickSearchInput() {
        searchInput.click();
        new BasePage(driver).sleep(2000);
        return this;
    }

    public boolean isDisplayedSearchInputDropdown() {
        return searchInputDropdown.isDisplayed();
    }


}
