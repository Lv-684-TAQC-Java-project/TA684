package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.signin.SignInRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class SignInClient extends BaseClient{

    public SignInClient() {
        super();
    }

    @Step("Method  for url /api/signin")
    public Response successSingInRequest(SignInRequest credentials){
        return prepareRequest()
                .body(credentials)
                .when()
                .post(baseUrl+"/api/signin");
    }
}
