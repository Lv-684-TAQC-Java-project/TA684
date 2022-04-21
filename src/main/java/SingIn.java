import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingIn extends TopPage{
    protected WebDriver driver;
    @FindBy(xpath="//input[@id='basic_email']")
    private WebElement enterName;
    @FindBy(xpath="//input[@id='basic_password']")
    private WebElement enterPassword;
    @FindBy(css =".login-button > span")
    private WebElement loginButton;
    @FindBy (css = ".ant-modal-wrap:nth-child(2) .ant-modal-close svg")
    private WebElement closeButton;
    private HeaderManu headerManu;

    public SingIn(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        initElements();
    }
    private void initElements() {
        headerManu=new HeaderManu(driver);
    }


    /**
     * EnterName
     */
    public WebElement getEnterName() {
        return enterName;
    }

    public void clickEnterName () {
        if(isDisplayedEnterName()) {
            getEnterName().click();
        }
    }

    public String getEnterNameText() {
        return getEnterName().getText();
    }

    public boolean isDisplayedEnterName() {
        return enterName.isDisplayed();
    }

    /**
     * EnterPassword
     */
    public WebElement getEnterPassword() {
        return enterPassword;
    }

    public void clickEnterPassword() {
        if(isDisplayedEnterPassword()) {
            getEnterPassword().click();
        }
    }

    public String getEnterPasswordText() {
        return getEnterPassword().getText();
    }

    public boolean isDisplayedEnterPassword() {
        return enterPassword.isDisplayed();
    }
    /**
     * LoginButton
     */
    public WebElement getLoginButton() {
        return loginButton;
    }

    public void clickLoginButton() {
        if(isDisplayedLoginButton()) {
            getLoginButton().click();
        }
    }

    public String getLoginButtonText() {
        return getLoginButton().getText();
    }

    public boolean isDisplayedLoginButton() {
        return loginButton.isDisplayed();
    }

    /**
     * Close
     */
    public WebElement getCloseButton() {
        return closeButton;
    }

    public void clickCloseButton() {
        if(isDisplayedCloseButton()) {
            getCloseButton().click();
        }
    }

    public String getCloseButtonText() {
        return getCloseButton().getText();
    }

    public boolean isDisplayedCloseButton() {
        return closeButton.isDisplayed();
    }

}
