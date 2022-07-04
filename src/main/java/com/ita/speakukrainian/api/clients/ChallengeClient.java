package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.challenge.CreateChallengeRequest;
import com.ita.speakukrainian.api.models.challenge.CreatedChallengeRequest;
import io.restassured.response.Response;

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
                .get(String.format("%s%s/%s", this.baseUrl, this.path, id));
    }

    public Response post(CreatedChallengeRequest body) {
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

    public Response post(CreateChallengeRequest body) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s", this.baseUrl, this.path));
    }

    public Response put (CreateChallengeRequest body){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s", this.baseUrl, this.path));
    }

    public Response put (CreateChallengeRequest body, int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .put(String.format("%s%s/%s", this.baseUrl, this.path,id));
    }

    public Response put (CreatedChallengeRequest body){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s", this.baseUrl, this.path));
    }
}
