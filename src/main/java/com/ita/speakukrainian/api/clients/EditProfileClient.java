package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.editProfile.CreateEditProfileRequest;
import io.restassured.response.Response;

public class EditProfileClient extends BaseClient {
    private final String authorizationToken;
    private final String path = "/api/challenge";

    public EditProfileClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response post (CreateEditProfileRequest body){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s", this.baseUrl, this.path));
    }
}
