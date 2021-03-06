package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.center.CreatedCenterRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CenterClient extends BaseClient {
    private final String authorizationToken;
    private final String path = "/api/center";

    public CenterClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }
    @Step("Create a new centre")
    public Response post(CreatedCenterRequest body){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s", this.baseUrl, this.path));
    }

}
