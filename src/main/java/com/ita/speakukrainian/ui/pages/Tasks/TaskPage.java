package com.ita.speakukrainian.ui.pages.Tasks;

import com.ita.speakukrainian.ui.pages.BaseObjectPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends BaseObjectPage {

    @FindBy(xpath = "//*[@id='root']/section/section/main/div/button")
    private WebElement addTaskButton;
    public TaskPage(WebDriver driver) {
        super(driver);
    }
    @Step("Go to AddTaskPage")
    public AddTaskPage clickAddTaskButton(){
        addTaskButton.click();
        return new AddTaskPage (driver);
    }
}
