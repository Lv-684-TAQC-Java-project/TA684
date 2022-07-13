package com.ita.speakukrainian.ui.dropdowns;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.MyProfilePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePageDropDown extends BasePage {

    private MyProfilePage myProfilePage;
    @FindBy(xpath = "//*[text()=\"центри\"]")
    private WebElement myCenters;
    @FindBy(xpath = "//*[text()=\"гуртки\"]")
    private WebElement myClubs;
    @FindBy(xpath = "//*[@class=\"ant-select club-center-select ant-select-single ant-select-show-arrow\"]")
    private WebElement dropDown;

    public MyProfilePageDropDown(WebDriver driver) {
        super(driver);
        myProfilePage = new MyProfilePage(driver);
    }

    @Step("Click centers in DropDown")
    public MyProfilePageDropDown clickMyProfileCenterDropDownPage(){
        sleep(1000);
        dropDown.click();
        myCenters.click();
        return this;
    }

    @Step("Click clubs in DropDown")
    public MyProfilePageDropDown clickMyProfileClubsDropDownPage(){
        sleep(1000);
        dropDown.click();
        myClubs.click();
        return this;
    }

}
