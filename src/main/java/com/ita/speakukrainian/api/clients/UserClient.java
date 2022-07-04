package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.user.CreatedUserRequest;
import io.restassured.response.Response;

public class UserClient extends BaseClient {
    private String authorizationToken;
    private final String path = "/api/user/203";

    public UserClient(String authorizationToken) {
        super();
        this.authorizationToken=authorizationToken;
    }

    public Response put(CreatedUserRequest body) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .put(String.format("%s%s", this.baseUrl, this.path));
    }
}
