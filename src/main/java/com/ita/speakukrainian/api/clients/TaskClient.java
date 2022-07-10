package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.api.models.task.CreateTaskRequest;
import com.ita.speakukrainian.api.models.task.TaskRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class TaskClient extends BaseClient{
    private final String authorizationToken;
    private final String path = "/api/challenge/task";
    private final String path1 = "/api/challenge";

    public TaskClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }
    @Step("Update some values of task, including the id of the challenge to which it is linked ")
    public Response put (TaskRequest body, int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .put(String.format("%s%s/%s", this.baseUrl, this.path,id));
    }

    @Step("Create new task by using challenge id")
    public Response post (CreateTaskRequest body, int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
                .post(String.format("%s%s/%s/task", this.baseUrl, this.path1,id));
    }
}
