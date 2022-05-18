package com.ita.speakukrainian.ui.dropdowns;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtendedSearchNearestMetroStationDropDown extends BasePage {

    private ClubsPage clubsPage;

    @FindBy(xpath = "//*[@title = \"Арсенальна\"]")
    private WebElement arsenalMetroStation;

    public ExtendedSearchNearestMetroStationDropDown(WebDriver driver) {
        super(driver);
        clubsPage = new ClubsPage(driver);
    }

    public WebElement getArsenalMetroStation(){return arsenalMetroStation;}

    @Step("Click nearest metro station Arsenal")
    public ExtendedSearchNearestMetroStationDropDown clickArsenalMetroStation(){
        sleep(1000);
        getArsenalMetroStation().click();
        return this;
    }

}
