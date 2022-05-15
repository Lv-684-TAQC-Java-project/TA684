package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ExtendedSearchCityDistrictPopUp extends BasePage {

    private ClubsPage clubsPage;

    @FindBy(xpath = "//*[@title = \"Деснянський\"]")
    private WebElement cityDistrictDesnyanskiy;

    public ExtendedSearchCityDistrictPopUp(WebDriver driver) {
        super(driver);
        clubsPage = new ClubsPage(driver);
    }

    public WebElement getCityDistrictDesnyanskiy(){return cityDistrictDesnyanskiy;}

    public ExtendedSearchCityDistrictPopUp clickCityDistrictDesnyanskiy(){
        sleep(1000);
        getCityDistrictDesnyanskiy().click();
        return this;
    }
}
