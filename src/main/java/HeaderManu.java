import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HeaderManu {
    protected WebDriver driver;


    public HeaderManu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }
}
