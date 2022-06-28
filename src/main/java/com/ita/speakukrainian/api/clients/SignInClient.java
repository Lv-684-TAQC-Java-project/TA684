package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.signin.SignInRequest;
import io.restassured.response.Response;

public class SignInClient extends BaseClient{

    public SignInClient() {
        super();
    }

    public Response successSingInRequest(SignInRequest credentials){
        return prepareRequest()
                .body(credentials)
                .when()
                .post(baseUrl+"/api/signin");
    }
}
