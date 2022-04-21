import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderManu {
    protected WebDriver driver;


    @FindBy(css = "user-profile > .anticon path")
    private WebElement userProFileButton;
    @FindBy(xpath = "//li[2]/span/div")
    private WebElement singInButton;
    public HeaderManu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * UserProFileButton
     */
    public WebElement getUserProFileButton() {
        return userProFileButton;
    }

    public void clickUserProFileButton() {
        if (isDisplayedUserProFileButton()){
            getUserProFileButton().click();
        }
    }

    public String getUserProFileButtonText() {
        return getUserProFileButton().getText();
    }

    public boolean isDisplayedUserProFileButton() {
        return userProFileButton.isDisplayed();
    }

    /**
     * SingInButton
     */
    public WebElement getSingInButton() {
        return singInButton;
    }

    public void clickSingInButton() {
        if(isDisplayedSingInButton()) {
            getSingInButton().click();
        }
    }

    public String getSingInButtonText() {
        return getSingInButton().getText();
    }

    public boolean isDisplayedSingInButton() {
        return singInButton.isDisplayed();
    }

}