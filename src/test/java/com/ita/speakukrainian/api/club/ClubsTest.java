package com.ita.speakukrainian.api.club;

import com.ita.speakukrainian.api.clients.ClubsClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.ErrorResponse;
import com.ita.speakukrainian.api.models.club.ClubsRequest;
import com.ita.speakukrainian.api.models.club.ClubsResponse;
import com.ita.speakukrainian.api.models.club.Location;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ClubsTest {
    private String authorizationToken = null;
    private static int idClub;

    @BeforeClass
    public void beforeClass() {
        SignInRequest credentials = new SignInRequest("TestTeach.ua@meta.ua", "123456789");
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
    }

    @Description("This test case verify that user as 'Керiвник гуртка' can create new club with valid data using Postman")
    @Issue("TUA-463")
    @Test(description = "TUA-463")
    public void verifyThatUserAsClubCanCreateNewClub() {
        String name = RandomStringUtils.randomAlphabetic(8);
        File file = new File("src/test/resources/json_463.json");
        String json = null;
        try {
            json = Files.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String textJson = String.format(json, name);
        ClubsClient client = new ClubsClient(this.authorizationToken);
        Response response = client.post(textJson);
        ClubsResponse clubsResponse = response.as(ClubsResponse.class);
        idClub=clubsResponse.getId();
        System.out.println(idClub);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(clubsResponse.getName(), name);
        softAssert.assertEquals(clubsResponse.getUser().getId(),264);
        softAssert.assertAll();
    }

    @Description("This test case verify that user as 'Керiвник гуртка' can delete club Postman")
    @Issue("TUA-468")
    @Test(description = "TUA-468")
    public void verifyThatUserAsClubCanDeleteClub() {
        ClubsClient client = new ClubsClient(this.authorizationToken);
        System.out.println(idClub);
        Response response = client.delete(idClub);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertAll();

    }

    @Test
    @Description("[allure] Verify that User as \"Керiвник гуртка\" can create new club is in a center using valid characters for \"Назва\" field")
    @Issue("TUA-500")
    public void leaderCanCreateCenterUsingValidCharactersTest() {
        ClubsClient client = new ClubsClient(this.authorizationToken);
        ClubsResponse ClubsResponse = new ClubsResponse();
        File file = new File("src/test/resources/json_500.json");

        String json = null;
        try {
            json = Files.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Response response = client.post(json);
        Assert.assertEquals(response.statusCode(),200);
        response = client.delete(ClubsResponse.getId());
//        response = client.delete(Integer.parseInt(response.getSessionId()));
    }

    @Description("This test case verify  that User as 'Керiвник гуртка' cannot create new club is in a center if 'Назва' field contain more than 100 characters using Postman.")
    @Issue("TUA-503")
    @Test(description = "TUA-503")
    public void verifyThatUserCannotCreateNewClubIfNameContainMore100Characters() {
        File file = new File("src/test/resources/json_503.json");
        String json = null;
        try {
            json = Files.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String textJson = String.format(json);
        ClubsClient client = new ClubsClient(this.authorizationToken);
        Response response = client.post(textJson);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "name Довжина назви має бути від 5 до 100 символів");
        softAssert.assertAll();

    }

    @Description("Verify that User as 'Керiвник гуртка' can create new club is in a center if 'Назва' field consists of a word length of 100 characters when use clubsRequest")
    @Issue("TUA-505")
    @Test(description = "TUA-505")
    public void verifyThatUserCanCreateNewClub() {
        String name= RandomStringUtils.randomAlphabetic(100);
        ClubsRequest clubsRequest = new ClubsRequest();
        clubsRequest.setName(name);
        clubsRequest.setCategoriesName(Arrays.asList("Вокальна студія, музика, музичні інструменти"));
        clubsRequest.setAgeFrom(2);
        clubsRequest.setAgeTo(18);
        clubsRequest.setUrlLogo("/upload/challenges/img2.png");
        clubsRequest.setUrlBackground("/upload/challenges/img2.png");
        clubsRequest.setOnline(true);
        clubsRequest.setDescription("{\"blocks\":[{\"key\":\"brl63\",\"text\":\"Ми поставили перед собою ціль створити мережу найкращих центрів раннього розвитку в Україні, де дітки навчатимуться з задоволенням, а батьки радітимуть від результатів.\",\"type\":\"unstyled\",\"depth\":1,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}");
        clubsRequest.setUserId("264");
        Location location = new Location();
        location.setName("Голосівська");
        location.setCityName("Київ");
        location.setDistrictName("Голосіївський");
        location.setAddress("https://speak-ukrainian.org.ua/dev/club/910");
        location.setCoordinates("50.35535081747696, 30.51765754176391");
        location.setPhone("0937777777");
        location.setKey(0.00);
        clubsRequest.setLocations(Arrays.asList(location));
        clubsRequest.setContacts("{\"1\"::\"ліл\"}");
        clubsRequest.setCenterId(2);
        ClubsClient client = new ClubsClient(this.authorizationToken);
        Response response = client.post(clubsRequest);

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Description("Verify that User as 'Керiвник гуртка' can create new club is in a center if 'Назва' field consists of a word length of 100 characters when use file json")
    @Issue("TUA-505")
    @Test(description = "TUA-505")
    public void verifyThatUserCanCreateNewClub2() {
        String name= RandomStringUtils.randomAlphabetic(100);
        File file = new File("src/test/resources/Club.json");
        String json = null;
        try {
            json = Files.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String textJson = String.format(json, name);
        ClubsClient client = new ClubsClient(this.authorizationToken);
        Response response = client.post(textJson);

        Assert.assertEquals(response.statusCode(), 200);
    }
}
