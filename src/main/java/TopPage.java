import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class TopPage {

    protected WebDriver driver;
    private HeaderManu headerManu;
    private Data data;

    public TopPage(WebDriver driver) {
        this.driver = driver;
        data = new Data();


        PageFactory.initElements(driver, this);
        initialElements();

    }

    private void initialElements() {
        headerManu = new HeaderManu(driver);


    }

    /**
     * HeaderManu
     */
    private HeaderManu getHeaderManu() {
        return headerManu;
    }

    /**
     * SingIn
     */
    private SingIn getSingIn() { return new SingIn(driver);
    }


    public HomePage navigateMenuHome() {
        getHeaderManu().clickHomePage();
        return new HomePage(driver);
    }

    public SingIn navigatEnterSingIn() throws InterruptedException {
        getHeaderManu().clickUserProFileButton();
        getHeaderManu().clickSingInButton();
        //Thread.sleep(1000);
        return new SingIn(driver);
    }

    public HomePage navigatEnterData() throws InterruptedException {
        getSingIn().clickEnterName();
        getSingIn().clearEnterName();
        getSingIn().sendKeysName(data.getEmail());
        getSingIn().clickEnterPassword();
        getSingIn().clickEnterPassword();
        getSingIn().sendKeysPassword(data.getPassword());
        getSingIn().clickLoginButton();
       // Thread.sleep(1000);
        return new HomePage(driver);
    }


}
