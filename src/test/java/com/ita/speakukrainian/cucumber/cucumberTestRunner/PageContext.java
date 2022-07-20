package com.ita.speakukrainian.cucumber.cucumberTestRunner;

import org.openqa.selenium.WebDriver;

public class PageContext {
    private WebDriver driver;
    private AllPages allPages;
    private AllHeaderComponents allHeaderComponents;

    public PageContext(WebDriver driver){
        this.driver = driver;
    }

    public AllPages getAllPages() {
        allPages = new AllPages(driver);
        return  allPages;
    }

    public AllHeaderComponents getAllHeaderComponents(){
        allHeaderComponents = new AllHeaderComponents(driver);
        return allHeaderComponents;
    }
}
