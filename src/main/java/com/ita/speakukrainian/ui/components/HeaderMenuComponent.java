package com.ita.speakukrainian.ui.components;

import com.ita.speakukrainian.ui.pages.*;
import com.ita.speakukrainian.ui.pages.AddClubPages.MainInformation;
import com.ita.speakukrainian.ui.pages.ChallengesPages.ChallengesPage;
import com.ita.speakukrainian.ui.pages.RegistrationPages.RegistrationPage;
import com.ita.speakukrainian.ui.pages.Tasks.TaskPage;
import com.ita.speakukrainian.ui.popup.AddCenterPopUp;
import com.ita.speakukrainian.ui.popup.SingInPopup;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderMenuComponent extends BaseComponent {

    Actions action;
    private final String avatarSelector = "//div[contains(@class,'user-profile')]//img";

    @FindBy(xpath = "//div[@id='root']/section/header/div[3]/div[2]/span[2]")
    private WebElement userProFileButton;
    @FindBy(xpath = "//li[2]/span/div")
    private WebElement singInButton;
    @FindBy(xpath = "//li[1]/span/div")
    private WebElement registrationButton;
    @FindBy(xpath = "//*[@id='root']/section/header/div[1]/a/div")
    private WebElement homePageButton;
    @FindBy(css = "[title='Розширений пошук']")
    private WebElement extendedSearchButton;
    @FindBy(how = How.CSS, using = "[class*='ant-dropdown-menu-item']")
    private WebElement addClubButton;
    @FindBy(xpath = "//*[@id='root']/section/header/div[3]/button")
    private WebElement addClubButtonOnHeader;
    @FindBy(xpath = avatarSelector)
    private WebElement avatar;
    @FindBy(css = ".ant-dropdown-menu-title-content > a")
    private WebElement myProfileButton;
    @FindBy(xpath = "//li[2]/span/div")
    private WebElement addCenterButton;
    @FindBy(xpath = "//div[2]/ul/li[1]/span/a")
    private WebElement clubsPageHeader;
    @FindBy(xpath = "//input[@id='rc_select_1']")
    private WebElement searchInput;
    @FindBy(xpath = "//div[4]/div/div")
    private WebElement searchInputDropdown;
    @FindBy(xpath ="//span[contains(.,'Адміністрування')]" )
    private WebElement administrationButtonInDropdown;
    @FindBy(xpath = "//a[contains(text(),'Челенджі')]")
    private  WebElement challengeInAdministrationButton;

    @FindBy(xpath="//a[contains(text(),'Завдання')]")
    private WebElement taskButton;


    public HeaderMenuComponent(WebDriver driver) {

        super(driver);
        action=new Actions(driver);
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

    public WebElement getAddClubButton() {
        return addClubButton;
    }

    @Step("open user dropdown-menu")
    public HeaderMenuComponent clickUserProFileButton() {
        userProFileButton.click();
        sleep(500);
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

    @Step("Click SingIn")
    public SingInPopup clickSingInButton() {
        if (isDisplayedSingInButton()) {
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

    @Step("Click extended search")
    public ClubsPage clickExtendedSearchButton() {
        getExtendedSearchButton().click();
        return new ClubsPage(driver);
    }

    /**
     * AddCenter
     *
     * @return AddCenterPopUp
     */
    @Step("Go to AddCenter")
    public AddCenterPopUp clickAddCenterButton() {
        addCenterButton.click();
        return new AddCenterPopUp(driver);
    }
    @Step("Go to AddClubPopUp")
    public MainInformation clickAddClubButtonOnHeader() {

        addClubButtonOnHeader.click();
        return new MainInformation(driver);
    }
    /**
     * MyProfile
     *
     * @return MyProfilePage
     */
    @Step("Go to MyProfile")
    public MyProfilePage clickMyProfileButton() {
        if (isDisplayedMyProfileButton()) {
            myProfileButton.click();
        }
        sleep(500);
        return new MyProfilePage(driver);
    }

    public boolean isDisplayedMyProfileButton() {
        return myProfileButton.isDisplayed();
    }

    @Step("Click Add Club")
    public MainInformation clickAddClubButton() {
        getAddClubButton().click();
        return new MainInformation(driver);
    }

    /**
     * Go to
     * ClubsPage
     */
    @Step("click Clubs Page Header")
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
        saveScreenshot();
        return searchInputDropdown.isDisplayed();
    }

    @Step("Click Add Add New User")
    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return new RegistrationPage(driver);
    }
    @Step("Click Add Add New User")
    public HeaderMenuComponent clickAdministrationButtonInDropdown() {
        action.moveToElement(administrationButtonInDropdown).build().perform();
        sleep(1000);
        return this;
    }
    @Step("Click Add Add New User")
    public ChallengesPage clickChallengeInAdministrationButton() {
        challengeInAdministrationButton.click();
        return new ChallengesPage(driver);
    }

    @Step("Click task button")
    public TaskPage clickTaskButton() {
        taskButton.click();
        return new TaskPage(driver);
    }

}
