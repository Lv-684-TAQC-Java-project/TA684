package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.challenge.ChallengePutRequest;
import com.ita.speakukrainian.api.models.challenge.ChallengeRequest;
import com.ita.speakukrainian.api.models.challenge.CreateChallengeRequest;
import com.ita.speakukrainian.api.models.challenge.CreatedChallengeRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class ChallengeClient extends BaseClient {
    private String authorizationToken;
    private final String path = "/api/challenge";


    public ChallengeClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    @Step("View info about challenge")
    public Response get(int id) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .get(String.format("%s%s/%s", this.baseUrl, this.path, id));
    }

    @Step("Create new challenge")
    public Response post(ChallengeRequest body) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s", this.baseUrl, this.path));
    }

    @Step("Delete challenge")
    public Response delete(int id) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .delete(String.format("%s%s/%s", this.baseUrl, this.path, id));
    }

    @Step("Edit information about challenge by id")
    public Response put(ChallengePutRequest body, int id) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .put(String.format("%s%s/task/%s", this.baseUrl, this.path, id));
    }

    @Step("Create challenge")
    public Response put(CreatedChallengeRequest body) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s", this.baseUrl, this.path));
    }
}