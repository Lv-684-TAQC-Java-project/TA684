package com.ita.speakukrainian.api.clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ChallengeClient extends BaseClient{
    private String authorizationToken;
    private final String path = "/api/challenge";


    public ChallengeClient(String authorizationToken) {
        super();
        this.authorizationToken=authorizationToken;
    }

    public Response get(int id) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .get(String.format("%s%s/%s", this.baseUrl, this.path, id ));
    }
}
