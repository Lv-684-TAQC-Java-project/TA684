import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestHomePage extends SpeakUkrainianRunner{
    @Test
    public void testActualPage() {
        System.out.println("Check pageURL");
        assertEquals("https://speak-ukrainian.org.ua/dev/", driver.getCurrentUrl());

        System.out.println("Check page title");
        assertEquals("Навчай українською", driver.getTitle());
    }

    @Test
    public void Check(){
        HomePage homePage = LoadApplication();


    }

}
