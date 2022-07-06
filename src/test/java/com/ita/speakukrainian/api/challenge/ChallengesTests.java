package com.ita.speakukrainian.api.challenge;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ChallengeClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.challenge.ChallengeResponseForGet;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChallengesTests extends BaseApiTestRunner {
    private int challengeId = 62;
    private String challengeName="Клуб української мови \"Розмовляй\"";
    private String challengeDescription = "Клуб української мови \"Розмовляй\" допоможе опанувати мовні практики, здолати мовні бар’єри, створити середовище підтримки та обміну досвідом між батьками дошкільнят, здобути необхідну лексичну базу українською мовою для повсякденного спілкування з дітьми.";

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
        ChallengeResponseForGet challengesResponse=responseChallenge.as(ChallengeResponseForGet.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200);

        softAssert.assertEquals(challengesResponse.getId(),challengeId);
        softAssert.assertTrue(challengesResponse.getName().contains(challengeName));
        softAssert.assertTrue(challengesResponse.getDescription().contains(challengeDescription));

        softAssert.assertAll();
    }

}
