import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class TestSingInPopUp extends SpeakUkrainianRunner{
    private final userData data = new userData();

    @Test
    public void testActualPage() {
        System.out.println("Check pageURL");
        assertEquals(data.getUrl(), driver.getCurrentUrl());

        System.out.println("Check page title");
        assertEquals("Навчай українською", driver.getTitle());
    }

    @Test
    public void CheckLoginAbility() {
        SingIn  singIn = new SingIn(driver);
            singIn.singIn(userData.getEmail(), userData.getPassword());
            System.out.println("Registration was successful");

    }

}
