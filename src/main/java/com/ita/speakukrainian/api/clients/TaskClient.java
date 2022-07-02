package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.editProfile.CreateEditProfileRequest;
import com.ita.speakukrainian.api.models.task.CreateTaskRequest;
import io.restassured.response.Response;

public class TaskClient extends BaseClient{
    private final String authorizationToken;
    private final String path = "/api/challenge/task";

    public TaskClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response put (CreateTaskRequest body, int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s/%s", this.baseUrl, this.path,id));
    }
}
