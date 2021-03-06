package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.club.ClubsRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class ClubsClient extends BaseClient {
    private final String authorizationToken;

    public ClubsClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    @Step("Send a request to create a new club use credentials")
    public Response post(ClubsRequest credentials) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .body(credentials)
                .when()
                .post(baseUrl + "/api/club");
    }

    @Step("Send a request to create a new club when use json")
    public Response post(String json) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .body(json)
                .when()
                .post(baseUrl + "/api/club");
    }
    @Step("Delete a new club when we  have Id")
    public Response delete (int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .delete(String.format("%s%s%s", this.baseUrl, "/api/club/",id));
    }


}
