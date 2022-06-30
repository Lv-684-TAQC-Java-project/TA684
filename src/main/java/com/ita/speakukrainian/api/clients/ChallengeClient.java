package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.challenge.CreatedChallengeRequest;
import io.restassured.response.Response;

public class ChallengeClient extends BaseClient {
    private final String authorizationToken;
    private final String path = "/api/challenge";

    public ChallengeClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response post(CreatedChallengeRequest body) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s", this.baseUrl, this.path));

    }
}
