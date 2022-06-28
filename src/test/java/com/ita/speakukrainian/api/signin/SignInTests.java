package com.ita.speakukrainian.api.signin;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.ErrorResponse;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignInTests extends BaseApiTestRunner {
    @Test
    public void successSingInTest (){
        SignInRequest credentials = new SignInRequest(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(signInResponse.getId(), 1);
        softAssert.assertEquals(signInResponse.getEmail(), "admin@gmail.com");
        softAssert.assertAll();
    }

    @Test
    public void failSingInTest (){
        String email = valueProvider.getAdminEmail()+"test";
        SignInRequest credentials = new SignInRequest(email, valueProvider.getAdminPassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 404);
        softAssert.assertEquals(errorResponse.getMessage(), "User not found by email " + email);

        softAssert.assertAll();
    }
}
