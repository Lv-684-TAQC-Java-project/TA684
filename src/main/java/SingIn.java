import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingIn{
    protected WebDriver driver;
    @FindBy(xpath="//input[@id='basic_email']")
    private WebElement enterName;
    @FindBy(xpath="//input[@id='basic_password']")
    private WebElement enterPassword;
    @FindBy(css =".login-button > span")
    private WebElement loginButton;
    @FindBy (css = ".ant-modal-wrap:nth-child(2) .ant-modal-close svg")
    private WebElement closeButton;
    private HeaderMenu headerManu;

    public SingIn(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        initElements();
    }
    private void initElements() {
        headerManu=new HeaderMenu(driver);
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

    public void sendKeysEnterName(String enterName){
        getEnterName().sendKeys(enterName);
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

    public void sendKeysPassword(String password){
        getEnterPassword().sendKeys(password);
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

    public boolean isDisplayedCloseButton() {
        return closeButton.isDisplayed();
    }

    public void singIn(String email, String password) {
        //headerManu.clickUserProFileButton();
        //headerManu.clickSingInButton();
        clickEnterName();
        sendKeysEnterName(email);
        clickEnterPassword();
        sendKeysPassword(password);
        clickLoginButton();
    }

}
