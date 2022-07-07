package com.ita.speakukrainian.api.challenge;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ChallengeClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.ErrorResponse;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChallengeTestsForUser extends BaseApiTestRunner {
    private String authorizationToken = null;

    @BeforeClass
    public void beforeClass() {
        SignInRequest credentials = new SignInRequest(valueProvider.getUserEmail(), valueProvider.getUserPassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
    }
    @Test
    @Description("Verify that user is not able to delete Challenge using non-administrator rights")
    @Issue("TUA-436")
    public void deleteChallengeAsUser(){
        ChallengeClient client = new ChallengeClient(this.authorizationToken);
        Response responseDel = client.delete(62);
        Assert.assertEquals(responseDel.statusCode(), 401);
        ErrorResponse errorResponse =responseDel.as(ErrorResponse.class);
        Assert.assertEquals(errorResponse.getMessage(), "You have no necessary permissions (role)");

    }

}
