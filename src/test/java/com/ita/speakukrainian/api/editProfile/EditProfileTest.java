package com.ita.speakukrainian.api.editProfile;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.EditProfileClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.ErrorResponse;
import com.ita.speakukrainian.api.models.editProfile.CreateEditProfileRequest;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditProfileTest extends BaseApiTestRunner {
    private String authorizationToken = null;

    @BeforeClass
    public void beforeClass() {
        SignInRequest credentials = new SignInRequest(valueProvider.getBaseEmail(), valueProvider.getBasePassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
    }

    @Test
    @Description("[allure] Cant save changes with entered invalid data")
    @Issue("TUA-415")
    public void cantSaveChangesWithInvalidDataTest() {
        SoftAssert softAssert = new SoftAssert();
        EditProfileClient client = new EditProfileClient(this.authorizationToken);
        CreateEditProfileRequest request = new CreateEditProfileRequest();
        int taskId = 203;

        request.setFirstName("Nastia1234");
        request.setLastName("Kukh");
        request.setPhone("999999922");
        request.setEmail("soyec48727@busantei.com");
        request.setRoleName("ROLE_MANAGER");
        request.setUrlLogo(null);
        request.setStatus("true");

        Response response = client.put(request, taskId);
        softAssert.assertEquals(response.statusCode(), 400);

        request.setFirstName("NastiaNastiaNastiaNastiaNastia");
        response = client.put(request, taskId);
        softAssert.assertEquals(response.statusCode(), 400);

        request.setFirstName("Nastia!@##$#$%");
        response = client.put(request, taskId);
        softAssert.assertEquals(response.statusCode(), 400);

        request.setFirstName("Nastia");
        request.setLastName("Kukhar#%$#");
        response = client.put(request, taskId);
        softAssert.assertEquals(response.statusCode(), 400);

        request.setLastName("KukharKukharKukharKukharKukharKukharKukhar#");
        response = client.put(request, taskId);
        softAssert.assertEquals(response.statusCode(), 400);

        softAssert.assertAll();
    }

    @Test
    @Description("[allure] The user or manager can change their role")
    @Issue("TUA-416")
    public void userOrManagerCanChangeRoleTest() {
        SoftAssert softAssert = new SoftAssert();
        EditProfileClient client = new EditProfileClient(this.authorizationToken);
        CreateEditProfileRequest request = new CreateEditProfileRequest();
        int taskId = 203;

        request.setFirstName("Nastia");
        request.setLastName("Kukh");
        request.setPhone("0999999922");
        request.setEmail("soyec48727@busantei.com");
        request.setRoleName("ROLE_MANAGER");
        request.setUrlLogo(null);
        request.setStatus("true");
        Response response = client.put(request, taskId);
        softAssert.assertEquals(response.statusCode(), 200);

        request.setRoleName("ROLE_USER");
        response = client.put(request, taskId);
        softAssert.assertEquals(response.statusCode(), 200);

        request.setRoleName("ROLE_MANAGER");
        response = client.put(request, taskId);
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertAll();
    }

}