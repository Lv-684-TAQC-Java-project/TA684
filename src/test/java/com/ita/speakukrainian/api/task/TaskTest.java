package com.ita.speakukrainian.api.task;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.clients.TaskClient;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import com.ita.speakukrainian.api.models.task.CreateTaskRequest;
import com.ita.speakukrainian.api.models.task.CreateTaskPutRequest;
import com.ita.speakukrainian.utils.DateProvider;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;

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
    @Description("Verify that user can create Task with valid values. ")
    @Issue("TUA-441")
    public void cantCreateTaskWithValidValue(){
        int taskId = 1;
       // CreateTaskRequest request = new CreateTaskRequest();

        File file = new File("src/test/resources/json_469.json");
        String json = null;
        try {
            json = Files.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String textJson = String.format(json);
        TaskClient client = new TaskClient(this.authorizationToken);
        Response response = client.postJs(textJson,taskId);
        CreateTaskRequest request =response.as(CreateTaskRequest.class);
                Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    @Description("[allure] Verify that user can not create Task with invalid values ")
    @Issue("TUA-442")
    public void cantCreateTaskWithInvalidValues1Test(){
        int taskId = 1;
        TaskClient client = new TaskClient(this.authorizationToken);
        CreateTaskRequest request = new CreateTaskRequest();

        request.setName(" name");
        request.setDescription(" descriptiondescriptiondescriptiondescriptiondescription ");
        request.setPicture("/upload/test/test.png");
        request.setStartDate("2021-11-03");
        Response response = client.post(request,taskId);
        Assert.assertEquals(response.statusCode(),400);

    }

    @Test
    @Description("[allure] Verify that user can not create Task with invalid values ")
    @Issue("TUA-442")
    public void cantCreateTaskWithInvalidValues2Test(){
        int taskId = 1;
        TaskClient client = new TaskClient(this.authorizationToken);
        CreateTaskRequest request = new CreateTaskRequest();

        request.setName( " namenamenamenamenamenamenamenamenamenam");
        request.setDescription( " descriptiondescriptiondescriptiondescriptiondescription ");
        request.setPicture("/upload/test/test.png");
        request.setStartDate("2021-11-03");
        Response response = client.post(request,taskId);
        Assert.assertEquals(response.statusCode(),400);

    }

    @Test
    @Description("[allure] Verify that user can not create Task with invalid values ")
    @Issue("TUA-442")
    public void cantCreateTaskWithInvalidValues3Test(){
        int taskId = 1;
        TaskClient client = new TaskClient(this.authorizationToken);
        CreateTaskRequest request = new CreateTaskRequest();

        request.setName( " namenameЁ, Ы,Э");
        request.setDescription(  " descriptiondescriptiondescriptiondescriptiondescription ");
        request.setPicture("/upload/test/test.png");
        request.setStartDate("2021-11-03");
        Response response = client.post(request,taskId);
        Assert.assertEquals(response.statusCode(),400);

    }

    @Test
    @Description("[allure] Verify that user can not create Task with invalid values ")
    @Issue("TUA-442")
    public void cantCreateTaskWithInvalidValues4Test(){
        int taskId = 1;
        TaskClient client = new TaskClient(this.authorizationToken);
        CreateTaskRequest request = new CreateTaskRequest();

        request.setName( " namenamename ");
        request.setDescription(" descriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondedescriptiondescriptiondescridescriptionde ");
        request.setPicture("/upload/test/test.png");
        request.setStartDate("2021-11-03");
        Response response = client.post(request,taskId);
        Assert.assertEquals(response.statusCode(),400);

    }

    @Test
    @Description("[allure] Verify that user can not create Task with invalid values ")
    @Issue("TUA-442")
    public void cantCreateTaskWithInvalidValues5Test(){
        int taskId = 1;
        TaskClient client = new TaskClient(this.authorizationToken);
        CreateTaskRequest request = new CreateTaskRequest();

        request.setName(" namenamenameЁ, Ы,Э ");
        request.setDescription(" descriptiondescriptiondescriptiondescriptiondescription Ё, Ы,Э ");
        request.setPicture("/upload/test/test.png");
        request.setStartDate("2021-11-03");
        Response response = client.post(request,taskId);
        Assert.assertEquals(response.statusCode(),400);

    }

    @Test
    @Description("[allure] Verify that user can not create Task using null, spaces as values ")
    @Issue("TUA-443")
    public void cantCreateTaskUsingNull1Test(){
        int taskId = 1;
        TaskClient client = new TaskClient(this.authorizationToken);
        CreateTaskRequest request = new CreateTaskRequest();

        request.setName("     ");
        request.setDescription("     ");
        request.setPicture("/upload/test/test.png");
        request.setStartDate("2021-11-03");
        Response response = client.post(request,taskId);
        Assert.assertEquals(response.statusCode(),400);

    }

    @Test
    @Description("[allure] Verify that user can not create Task using null, spaces as values ")
    @Issue("TUA-443")
    public void cantCreateTaskUsingNull2Test(){
        int taskId = 1;
        TaskClient client = new TaskClient(this.authorizationToken);
        CreateTaskRequest request = new CreateTaskRequest();

        request.setName(" namenamena ");
        request.setDescription(" descriptiondescriptiondescriptiondescriptiondescription");
        request.setPicture("/upload/test/test.png");
        request.setStartDate("2021-11-03");
        Response response = client.post(request,taskId);
        Assert.assertEquals(response.statusCode(),400);

    }

    @Test
    @Description("[allure] Verify that user can not create Task using null, spaces as values ")
    @Issue("TUA-443")
    public void cantCreateTaskUsingNull3Test(){
        int taskId = 1;
        TaskClient client = new TaskClient(this.authorizationToken);
        CreateTaskRequest request = new CreateTaskRequest();

        request.setName(null);
        request.setDescription(null);
        request.setPicture("/upload/test/test.png");
        request.setStartDate("2021-11-03");
        Response response = client.post(request,taskId);
        Assert.assertEquals(response.statusCode(),400);

    }

    @Test
    @Description("[allure] Verify that user can edit Task with valid values ")
    @Issue("TUA-444")
    public void userCanEditTaskWithValidValuesTest(){
        int taskId = 388;
        int challengeId = 241;
        TaskClient client = new TaskClient(this.authorizationToken);
        CreateTaskPutRequest request = new CreateTaskPutRequest();
        DateProvider date = new DateProvider();

        request.setName("namenamename1213#$%");
        request.setHeaderText("stringstringstringstringstringstringstri");
        request.setDescription(" descriptiondescriptiondescriptiondescriptiondescription12345$%%^$# ");
        request.setPicture("/upload/test/test.png");
        request.setStartDate(date.dateFuture());
        request.setChallengeId(challengeId);
        Response response = client.put(request,taskId);
        Assert.assertEquals(response.statusCode(),200);

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
