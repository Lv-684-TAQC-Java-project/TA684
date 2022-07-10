package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.challenge.CreateChallengeRequest;
import com.ita.speakukrainian.api.models.editProfile.CreateEditProfileRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class EditProfileClient extends BaseClient {
    private final String authorizationToken;
    private final String path = "/api/user";

    public EditProfileClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }
    @Step("Send method post for url /api/user ")
    public Response post (CreateEditProfileRequest body, int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s/%s", this.baseUrl, this.path,id));
    }
    @Step("Send method put for url /api/user ")
    public Response put (CreateEditProfileRequest body, int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .put(String.format("%s%s/%s", this.baseUrl, this.path, id));
    }
}
