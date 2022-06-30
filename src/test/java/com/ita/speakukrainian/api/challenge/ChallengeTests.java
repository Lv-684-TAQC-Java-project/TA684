package com.ita.speakukrainian.api.challenge;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ChallengeClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.challenge.CreateChallengeRequest;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ChallengeTests extends BaseApiTestRunner {
    private String authorizationToken = null;
    @BeforeClass
    public void beforeClass() {
        SignInRequest credentials = new SignInRequest(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
    }

    @Test
    public void successCreatedChallengeTest() {
        CreateChallengeRequest createChallengeRequest = new CreateChallengeRequest();
        createChallengeRequest.setName("Example name");
        createChallengeRequest.setTitle("Example title");
        createChallengeRequest.setDescription("Lorem ipsum dolor sit amet, consectetuer adipiscin");
        createChallengeRequest.setPicture("src/test/resources/foto.jpg");
        createChallengeRequest.setSortNumber(1235897238);

        ChallengeClient client = new ChallengeClient(this.authorizationToken);
        Response response = client.post(createChallengeRequest);
        Assert.assertEquals(response.statusCode(), 200);

    }
}
