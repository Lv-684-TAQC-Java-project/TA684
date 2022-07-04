package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.challenge.CreateChallengeRequest;
import com.ita.speakukrainian.api.models.editProfile.CreateEditProfileRequest;
import io.restassured.response.Response;

public class EditProfileClient extends BaseClient {
    private final String authorizationToken;
    private final String path = "/api/user";

    public EditProfileClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response post (CreateEditProfileRequest body, int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s/%s", this.baseUrl, this.path,id));
    }

    public Response put (CreateEditProfileRequest body, int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s/%s", this.baseUrl, this.path, id));
    }
}
