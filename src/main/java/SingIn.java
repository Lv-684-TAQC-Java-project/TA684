import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SingIn extends TopPage{
    private WebDriver driver;
    private HeaderManu headerManu;

    public SingIn(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        initElements();
    }
    private void initElements() {
        headerManu=new HeaderManu(driver);
    }
}
