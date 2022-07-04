package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.user.UserRequest;
import io.restassured.response.Response;

public class UserClient extends BaseClient{
    private final String authorizationToken;
    private final String path = "/api/user/";



    public UserClient(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    public Response put (UserRequest body, int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s%s", this.baseUrl, this.path, id));
    }
}
