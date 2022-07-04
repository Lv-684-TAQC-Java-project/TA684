package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.restassured.response.Response;

public class Authorization {
    private final SignInResponse signInResponse;
    public Authorization(String email, String password) {
        SignInRequest credentials = new SignInRequest(email, password);
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        signInResponse = response.as(SignInResponse.class);
    }

    public String getToken(){
        return signInResponse.getAccessToken();
    }
}
