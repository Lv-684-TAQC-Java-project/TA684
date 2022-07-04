package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.editProfile.CreateEditProfileRequest;
import com.ita.speakukrainian.api.models.signup.SignupRequest;
import io.restassured.response.Response;

public class SignupClient extends BaseClient{
    private final String authorizationToken;
    private final String path = "/api/signup";

    public SignupClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }
    public Response post (SignupRequest body){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s", this.baseUrl, this.path));
    }

}
