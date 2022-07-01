package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.challenge.CreateChallengeRequest;
import io.restassured.response.Response;

public class ChallengeClient  extends BaseClient{
    private final String authorizationToken;
    private final String path = "/api/challenge";

    public ChallengeClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response post (CreateChallengeRequest body){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s", this.baseUrl, this.path));
    }

    public Response delete (int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .delete(String.format("%s%s/%s", this.baseUrl, this.path,id));
    }
}
