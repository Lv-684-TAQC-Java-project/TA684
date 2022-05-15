package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtendedSearchCityPopUp extends BasePage {

    private ClubsPage clubsPage;

    @FindBy(xpath = "//*[@title = \"Київ\"]")
    private WebElement cityKiev;

    public ExtendedSearchCityPopUp(WebDriver driver) {
        super(driver);
        clubsPage = new ClubsPage(driver);
    }

    public WebElement getCityKiev(){return cityKiev;}

    public ExtendedSearchCityPopUp clickCityKiev(){
        sleep(1000);
        getCityKiev().click();
        return this;
    }


}
