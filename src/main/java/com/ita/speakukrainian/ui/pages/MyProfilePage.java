package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.AddClubPages.MainInformation;
import com.ita.speakukrainian.ui.popup.AddCenterPopUp;
import com.ita.speakukrainian.ui.popup.RedactClubMaliavkyPopUp;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BaseObjectPage {
    @FindBy(xpath = "//*[@id=\"root\"]/section/section/main/section/main/div[3]/div[1]/div[2]/button")
    private WebElement addButton;
    @FindBy(xpath = "/html/body/div[5]/div/div/ul/li[2]/span/div")
    private WebElement addCenterButton;
    @FindBy(xpath = "/html/body/div[5]/div/div/ul/li[1]/span/div")
    private WebElement addClubButton;
    @FindBy(xpath = "//*[@class=\"ant-btn ant-btn-text button\"]")
    private WebElement editProfile;

    @FindBy(xpath = "//div[contains(text(), 'Малявки')]")
    private WebElement cardMaliavky;

    @FindBy(xpath = "//div[contains(text(), 'Малявки&')]")
    private WebElement cardMaliavky$;

    @FindBy(xpath = "//section[@class='ant-layout user-clubs']/div/div[2]/div/div/button")
    private WebElement detailsMaliavky;

    @FindBy(xpath = "//section[@class='ant-layout user-clubs']/div/div[2]/div/div/div[1]/div[2]/div")
    private WebElement moreActionMenu;

    @FindBy(css =".ant-dropdown-menu-title-content > div > div" )
    private WebElement redactClub;

    private final HeaderMenuComponent headerMenu;

    public MyProfilePage(WebDriver driver) {
        super(driver);

        headerMenu = new HeaderMenuComponent(driver);
    }

    @Step("click Edit Profile")
    public EditProfilePage clickEditProfileButton() {
        editProfile.click();
        return new EditProfilePage(driver);
    }

    @Step("Click Add 'Додати' button ")
    public MyProfilePage clickAddButton() {
        addButton.click();
        return new MyProfilePage(driver);
    }
    @Step("Go to AddCenter")
    public AddCenterPopUp clickAddCenterButton() {
        addCenterButton.click();
        return new AddCenterPopUp(driver);
    }

    @Step("Click add club button")
    public MainInformation clickAddClubButton() {
        sleep(3000);
        addClubButton.click();
        return new MainInformation(driver);
    }
    @Step("is Card Maliavky Present")
    public boolean isCardMaliavkyPresent(){
       return cardMaliavky.isEnabled();
    }

    @Step("is Card Maliavky& Present")
    public boolean isCardMaliavky$Present(){
        return cardMaliavky$.isEnabled();
    }



    @Step("Go to Myliavky club page")
    public MyliavkyClubPage clickDetailsButton(){
        detailsMaliavky.click();
        return new MyliavkyClubPage(driver);
    }

    @Step("Choose menu to Myliavky club page")
    public MyProfilePage clickMoreActionMenu(){
        scrollToElement(moreActionMenu);
        moreActionMenu.click();
        return new MyProfilePage(driver);
    }

    public RedactClubMaliavkyPopUp clickRedactClub(){
        redactClub.click();
        return new RedactClubMaliavkyPopUp(driver);
    }
}

