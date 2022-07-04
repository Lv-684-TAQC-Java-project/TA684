package com.ita.speakukrainian.api.club;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ClubsClient;
import com.ita.speakukrainian.api.clients.EditProfileClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.club.ClubsRequest;
import com.ita.speakukrainian.api.models.club.ClubsResponse;
import com.ita.speakukrainian.api.models.editProfile.CreateEditProfileRequest;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;

public class Clubs500Test extends BaseApiTestRunner {
    private String authorizationToken = null;

    @BeforeClass
    public void beforeClass() {

        SignInRequest credentials = new SignInRequest(valueProvider.getLeaderEmail(),valueProvider.getLeaderPassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
    }

    @Test
    @Description("[allure] Verify that User as \"Керiвник гуртка\" can create new club is in a center using valid characters for \"Назва\" field")
    @Issue("TUA-500")
    public void leaderCanCreateCenterUsingValidCharactersTest() {
        SoftAssert softAssert = new SoftAssert();
        ClubsClient client = new ClubsClient(this.authorizationToken);
        ClubsRequest request = new ClubsRequest();
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

    }


}
