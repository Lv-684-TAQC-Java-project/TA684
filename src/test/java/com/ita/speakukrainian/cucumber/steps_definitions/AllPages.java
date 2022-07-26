package com.ita.speakukrainian.cucumber.steps_definitions;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.popup.SingInPopup;
import org.openqa.selenium.WebDriver;

public class AllPages {
    private WebDriver driver;
    private HomePage homePage;
    private HeaderMenuComponent headerMenuComponent;
    private  SingInPopup singInPopup;
    private ClubsPage clubsPage;

    public AllPages(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return homePage == null ? new HomePage(driver) : homePage;
    }
    public HeaderMenuComponent getHeaderMenuComponent() {
        return headerMenuComponent == null ? new HeaderMenuComponent(driver) : headerMenuComponent;
    }
    public SingInPopup getSingInPopup() {
        return singInPopup == null ? new  SingInPopup(driver) : singInPopup;
    }
    public ClubsPage getClubsPage() {
        return clubsPage == null ? new  ClubsPage(driver) : clubsPage;
    }

}
