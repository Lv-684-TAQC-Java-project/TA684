package com.ita.speakukrainian.api.user;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ChallengeClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.clients.UserClient;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import com.ita.speakukrainian.api.models.user.UserRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserTest431 extends BaseApiTestRunner {
    private String authorizationToken = null;

    @Description("Verify that user can not save changes where enter invalid data in field 'Phone'")
    @Issue("TUA-431")
    @Test
    public void getChallengesAsAdmin() {
        SignInRequest data = new SignInRequest(valueProvider.getBaseEmail(), valueProvider.getBasePassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(data);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();

        UserRequest userRequest =new UserRequest();
        UserClient userClient = new UserClient(this.authorizationToken);
  //      Response responseUser = userClient.put(userRequest, 203);


    }


}
