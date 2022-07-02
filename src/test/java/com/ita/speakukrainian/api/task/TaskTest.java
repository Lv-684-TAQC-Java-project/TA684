package com.ita.speakukrainian.api.task;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.clients.TaskClient;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import com.ita.speakukrainian.api.models.task.CreateTaskRequest;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TaskTest extends BaseApiTestRunner {
    private String authorizationToken = null;
    @BeforeClass
    public void beforeClass() {
        SignInRequest credentials = new SignInRequest(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
    }

    @Test
    @Description("[allure] Can not edit task with invalid values ")
    @Issue("TUA-445")
    public void cantSaveTaskChangesWithInvalidDataTest(){
        int taskId = 388;
        SoftAssert softAssert = new SoftAssert();
        TaskClient client = new TaskClient(this.authorizationToken);
        CreateTaskRequest request = new CreateTaskRequest();

        request.setName(" name");
        request.setDescription(" descriptiondescriptiondescriptiondescriptiondescription ");
        request.setPicture("/upload/test/test.png");
        request.setStartDate("2021-11-03");
        Response response = client.put(request,taskId);
        softAssert.assertEquals(response.statusCode(),400);

        request.setName(" namenameЁ, Ы,Э");
        request.setDescription(" descriptiondescriptiondescriptiondescriptiondescription ");
        request.setPicture("/upload/test/test.png");
        request.setStartDate("2021-11-03");
        response = client.put(request,taskId);
        softAssert.assertEquals(response.statusCode(),400);

        request.setName(" name");
        response = client.put(request,taskId);
        softAssert.assertEquals(response.statusCode(),400);

        request.setName(" namenamename ");
        request.setDescription(" descriptiondescriptiondescriptiondescri ");
        response = client.put(request,taskId);
        softAssert.assertEquals(response.statusCode(),400);

        request.setDescription(" descriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondedescriptiondescriptiondescridescriptionde ");
        response = client.put(request,taskId);
        softAssert.assertEquals(response.statusCode(),400);

        request.setName(" namenamenameЁ, Ы,Э ");
        request.setDescription(" descriptiondescriptiondescriptiondescriptiondescription Ё, Ы,Э ");
        response = client.put(request,taskId);
        softAssert.assertEquals(response.statusCode(),400);
        softAssert.assertAll();

    }


}
