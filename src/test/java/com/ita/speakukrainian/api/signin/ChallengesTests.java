package com.ita.speakukrainian.api.signin;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ChallengeClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.challenges.ChallengesResponse437;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChallengesTests extends BaseApiTestRunner {
    private String challengeName="Днипро";

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
    public void getChallengesAsAdmin() {
        ChallengeClient client = new ChallengeClient(this.authorizationToken);
        ChallengesResponse437 challengesResponse437= response.as(ChallengesResponse437.class);
        Response response = client.get(62);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(challengesResponse437.getId(), 62);
        System.out.println(response.body().asString());
        softAssert.assertAll();
    }
}
