import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class TopPage {

    protected WebDriver driver;

    public TopPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        initialElements();

    }

    private void initialElements() {


    }


}
