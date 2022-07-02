package com.ita.speakukrainian.api.club;

import com.ita.speakukrainian.api.clients.ClubsClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.club.ClubsResponse;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;

public class clubsTest463And468 {
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
}
