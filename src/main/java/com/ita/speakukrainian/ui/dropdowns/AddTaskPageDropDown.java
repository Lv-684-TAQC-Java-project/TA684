package com.ita.speakukrainian.ui.dropdowns;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.Tasks.AddTaskPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTaskPageDropDown extends BasePage {

    @FindBy(xpath = "//*[@title=\"Днипро\"]")
    private WebElement dniproChallenge;

    private AddTaskPage addTaskPage;

    public AddTaskPageDropDown(WebDriver driver) {
        super(driver);
        addTaskPage = new AddTaskPage(driver);
    }


    public AddTaskPageDropDown clickDniproChallenge() {
        sleep(500);
        dniproChallenge.click();
        return this;
    }

}
