package com.ita.speakukrainian.ui.dropdowns;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtendedSearchCityDropDown extends BasePage {

    private ClubsPage clubsPage;

    @FindBy(xpath = "//*[@title = \"Київ\"]")
    private WebElement cityKiev;

    public ExtendedSearchCityDropDown(WebDriver driver) {
        super(driver);
        clubsPage = new ClubsPage(driver);
    }

    public WebElement getCityKiev(){return cityKiev;}

    @Step("Click city dropdown in extended search menu")
    public ExtendedSearchCityDropDown clickCityKiev(){
        sleep(1000);
        getCityKiev().click();
        return this;
    }


}
