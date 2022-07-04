package com.ita.speakukrainian.api.club;

import com.ita.speakukrainian.api.clients.ClubsClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.ErrorResponse;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;

public class ClubTest503 {
    private String authorizationToken = null;


    @BeforeClass
    public void beforeClass() {
        SignInRequest credentials = new SignInRequest("TestTeach.ua@meta.ua", "123456789");
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
    }

    @Description("This test case verify  that User as 'Керiвник гуртка' cannot create new club is in a center if 'Назва' field contain more than 100 characters using Postman.")
    @Issue("TUA-503")
    @Test(description = "TUA-503")
    public void verifyThatUserCannotCreateNewClubIfNameContainMore100Characters() {
        File file = new File("src/test/resources/json_503.json");
        String json = null;
        try {
            json = Files.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String textJson = String.format(json);
        ClubsClient client = new ClubsClient(this.authorizationToken);
        Response response = client.post(textJson);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "name Довжина назви має бути від 5 до 100 символів");
        softAssert.assertAll();

}
}
