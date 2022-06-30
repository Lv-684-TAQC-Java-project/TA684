package com.ita.speakukrainian.api.editProfile;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.EditProfileClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.editProfile.CreateEditProfileRequest;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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

    public void cantSaveChangesWithInvalidDataTest() {
        SoftAssert softAssert = new SoftAssert();
        EditProfileClient client = new EditProfileClient(this.authorizationToken);
        CreateEditProfileRequest request = new CreateEditProfileRequest();
        Response response = client.post(request);

        request.setId(203);
        request.setFirstName("Nastia1234");
        request.setLastName("Kukh");
        request.setPhone("999999922");
        request.setEmail("soyec48727@busantei.com");
        request.setRoleName("ROLE_MANAGER");
        request.setUrlLogo(null);
        request.setStatus("true");
        softAssert.assertEquals(response.statusCode(),400);

        request.setFirstName("NastiaNastiaNastiaNastiaNastia");
        softAssert.assertEquals(response.statusCode(),400);

        request.setFirstName("Nastia!@##$#$%");
        softAssert.assertEquals(response.statusCode(),400);

        request.setFirstName("Nastia");
        request.setLastName("Kukhar#%$#");
        softAssert.assertEquals(response.statusCode(),400);

        request.setLastName("KukharKukharKukharKukharKukharKukharKukhar#");
        softAssert.assertEquals(response.statusCode(),400);

        softAssert.assertAll();
    }
}
