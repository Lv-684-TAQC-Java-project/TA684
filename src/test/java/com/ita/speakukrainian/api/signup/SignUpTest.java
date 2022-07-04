package com.ita.speakukrainian.api.signup;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.EditProfileClient;
import com.ita.speakukrainian.api.clients.SignupClient;
import com.ita.speakukrainian.api.models.editProfile.CreateEditProfileRequest;
import com.ita.speakukrainian.api.models.signup.SignupRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignUpTest extends BaseApiTestRunner {
    private String authorizationToken = null;

    @Test
    @Description("[allure] Verify that a user with invalid data in \"Пароль\" field can`t be created")
    @Issue("TUA-499")
    public void userCantCreatedWithInvalidValuesTest() {
        SignupClient client = new SignupClient(this.authorizationToken);
        SignupRequest request = new SignupRequest();

        request.setFirstName("firstname");
        request.setLastName("lastname");
        request.setEmail("email");
        request.setPassword("Ab34567@");
        request.setPhone("0453567890");
        request.setRoleName("ROLE_MANAGER");

        Response response = client.post(request);
        Assert.assertEquals(response.statusCode(), 401);
    }
}
