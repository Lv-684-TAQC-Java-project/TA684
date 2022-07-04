package com.ita.speakukrainian.api.challenge;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ChallengeClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.challenge.ChallengeResponse;
import com.ita.speakukrainian.api.models.challenge.ChallengeResponse437;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChallengesTests extends BaseApiTestRunner {
    private String challengeName="Клуб української мови \\\"Розмовляй\\\"";

    private String authorizationToken = null;


    @Test
    public void getChallengesAsAdmin() {
        SignInRequest credentials = new SignInRequest(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();

        ChallengeClient clientChallenge = new ChallengeClient(this.authorizationToken);
        Response responseChallenge = clientChallenge.get(62);
        String resp  = responseChallenge.asString();
        System.out.println(resp);
//        ChallengeResponse437 challengesResponse437= null;
//        try {
//            challengesResponse437 = new ObjectMapper().readValue(resp, ChallengeResponse437.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertTrue(resp.contains(challengeName));
        softAssert.assertAll();
    }

}
