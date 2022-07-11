package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.user.CreatedUserRequest;
import com.ita.speakukrainian.api.models.user.UsersRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UserClient extends BaseClient {
    private String authorizationToken;
    private final String path = "/api/user";
    private final String fullPass = "/api/user/203";

    public UserClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    @Step("Edit user profile")
    public Response put(CreatedUserRequest body) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .put(String.format("%s%s", this.baseUrl, this.fullPass));
    }

    @Step("Edit user profile by id {id}")
    public Response put(UsersRequest body, int id) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .put(String.format("%s%s/%s", this.baseUrl, this.path, id));
    }
}

