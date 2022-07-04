package com.ita.speakukrainian.api.club;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ClubsClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.ErrorResponse;
import com.ita.speakukrainian.api.models.challenge.CreatedChallengeRequest;
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


public class Test469 extends BaseApiTestRunner {
    private String authorizationToken = null;

    @BeforeClass
    public void beforeClass() {
        SignInRequest credentials = new SignInRequest(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
    }

    @Description("Verify that the duplicate club cannot be created")
    @Issue("TUA-469")
    @Test
    public void verifyTheDuplicateClubCannotBeCreated() {
        File file = new File("src/test/resources/json_469.json");
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
        softAssert.assertEquals(response.statusCode(), 403);
        softAssert.assertEquals(errorResponse.getMessage(), "Club already exist with name: Спроба1");
        softAssert.assertAll();
    }

}
