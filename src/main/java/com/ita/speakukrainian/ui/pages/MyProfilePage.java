package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.popup.AddCenterPopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BaseObjectPage{
    @FindBy(xpath = "//*[@id=\"root\"]/section/section/main/section/main/div[3]/div[1]/div[2]/button")
    private WebElement addButton;
    @FindBy(xpath = "/html/body/div[5]/div/div/ul/li[2]/span/div")
    private WebElement addCenterButton;
    @FindBy(xpath = "/html/body/div[5]/div/div/ul/li[1]/span/div")
    private WebElement addClubButton;

    private HeaderMenuComponent headerMenu;
    public MyProfilePage(WebDriver driver) {
        super(driver);

        headerMenu = new HeaderMenuComponent(driver);
    }

    public  MyProfilePage clickAddButton(){
        addButton.click();
        return new MyProfilePage(driver);
    }

    public AddCenterPopUp clickAddCenterButton(){
        addCenterButton.click();
        return new AddCenterPopUp(driver);
    }


}