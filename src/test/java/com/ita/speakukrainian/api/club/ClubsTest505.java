package com.ita.speakukrainian.api.club;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ClubsClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.club.Location;
import com.ita.speakukrainian.api.models.signin.ClubsRequest;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.reporters.Files;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class ClubsTest505 extends BaseApiTestRunner {
    private String authorizationToken = null;

    @BeforeClass
    public void beforeClass() {
        SignInRequest credentials = new SignInRequest("TestTeach.ua@meta.ua", "123456789");
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
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
