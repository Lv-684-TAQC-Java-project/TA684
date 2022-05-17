package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtendedSearchNearestMetroStationPopUp extends BasePage {

    private ClubsPage clubsPage;

    @FindBy(xpath = "//*[@title = \"Арсенальна\"]")
    private WebElement arsenalMetroStation;

    public ExtendedSearchNearestMetroStationPopUp(WebDriver driver) {
        super(driver);
        clubsPage = new ClubsPage(driver);
    }

    public WebElement getArsenalMetroStation(){return arsenalMetroStation;}

    public ExtendedSearchNearestMetroStationPopUp clickArsenalMetroStation(){
        sleep(1000);
        getArsenalMetroStation().click();
        return this;
    }

}
