package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import org.openqa.selenium.WebDriver;

public class ClubsPage extends BasePage {
    private final HeaderMenuComponent headerMenuComponent;
    private final ExtendedSearchComponent extendedSearchComponent;
//    @FindBy(css =".ant-layout-has-sider")
//    private WebElement advancedSearch;


    public ClubsPage(WebDriver driver) {
        super(driver);
        this.headerMenuComponent = new HeaderMenuComponent(driver);
        this.extendedSearchComponent = new ExtendedSearchComponent(driver);
    }

    public ExtendedSearchComponent getExtendedSearchComponent() {
        return extendedSearchComponent;
    }

    public HeaderMenuComponent getHeaderMenuComponent() {
        return headerMenuComponent;
    }


}

