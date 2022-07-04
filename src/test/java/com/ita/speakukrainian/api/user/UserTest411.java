package com.ita.speakukrainian.api.user;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.clients.UserClient;
import com.ita.speakukrainian.api.models.ErrorResponse;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import com.ita.speakukrainian.api.models.user.CreatedUserRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserTest411 extends BaseApiTestRunner {
    private String authorizationToken = null;

    @BeforeClass
    public void beforeClass() {

        SignInRequest credentials = new SignInRequest("soyec48727@busantei.com", "12345678");
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
    }


    @Description("This test case verifies that user can not save changes where mandatory fields are empty")
    @Issue("TUA-411")
    @Test(description = "TUA-411")
    public void VerifyThatUserCanNotSaveChangesWhereMandatoryFieldsAreEmpty() {
        CreatedUserRequest userRequest = new CreatedUserRequest();
        SoftAssert softAssert = new SoftAssert();
        userRequest.setFirstName("Nastia");
        userRequest.setLastName("Kukh");
        userRequest.setEmail("soyec48727@busantei.com");
        userRequest.setPhone("0999999922");
        userRequest.setRoleName("ROLE_MANAGER");
        userRequest.setUrlLogo(null);
        userRequest.setStatus(true);

        UserClient userClient = new UserClient(this.authorizationToken);

        userRequest.setFirstName(null);
        Response response = userClient.put(203, userRequest);
        ErrorResponse userResponse = response.as(ErrorResponse.class);
        softAssert.assertEquals(userResponse.getStatus(), 400);
        softAssert.assertEquals(userResponse.getMessage(), "\"firstName\" can`t be null");
        userRequest.setFirstName("Nastia");

        userRequest.setLastName(null);
        response = userClient.put(203, userRequest);
        userResponse = response.as(ErrorResponse.class);
        softAssert.assertEquals(userResponse.getStatus(), 400);
        softAssert.assertEquals(userResponse.getMessage(), "\"lastName\" can`t be null");
        userRequest.setLastName("Kukh");

        userRequest.setPhone(null);
        response = userClient.put(203, userRequest);
        userResponse = response.as(ErrorResponse.class);
        softAssert.assertEquals(userResponse.getStatus(), 400);
        softAssert.assertEquals(userResponse.getMessage(), "phone must not be blank");

        softAssert.assertAll();
    }
}

