package com.ita.speakukrainian.ui.dropdowns;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtendedSearchCityDistrictDropDown extends BasePage {

    private ClubsPage clubsPage;

    @FindBy(xpath = "//*[@title = \"Деснянський\"]")
    private WebElement cityDistrictDesnyanskiy;

    public ExtendedSearchCityDistrictDropDown(WebDriver driver) {
        super(driver);
        clubsPage = new ClubsPage(driver);
    }

    public WebElement getCityDistrictDesnyanskiy(){return cityDistrictDesnyanskiy;}

    @Step("Click city district dropdown in extended search menu")
    public ExtendedSearchCityDistrictDropDown clickCityDistrictDesnyanskiy(){
        sleep(1000);
        getCityDistrictDesnyanskiy().click();
        return this;
    }
}
