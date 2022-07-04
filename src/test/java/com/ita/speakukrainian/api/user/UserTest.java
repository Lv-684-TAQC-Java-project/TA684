package com.ita.speakukrainian.api.user;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.clients.UserClient;
import com.ita.speakukrainian.api.models.ErrorResponse;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import com.ita.speakukrainian.api.models.user.CreatedUserRequest;
import com.ita.speakukrainian.utils.jdbc.entity.UsersEntity;
import com.ita.speakukrainian.utils.jdbc.services.UsersService;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class UserTest extends BaseApiTestRunner {
    private String authorizationToken = null;
    UsersService usersService = new UsersService();
    private String firstName = "Anna";

    @BeforeClass
    public void beforeClass() {
        SignInRequest credentials = new SignInRequest(valueProvider.getBaseEmail(), valueProvider.getBasePassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
    }

    @Test
    @Description("User can edit profile with valid data")
    @Issue("TUA-408")
    public void userCanEditProfileWithValidDdata() {
        CreatedUserRequest userRequest = new CreatedUserRequest();
        userRequest.setFirstName(firstName);
        userRequest.setLastName("Kukarska");
        userRequest.setEmail("soyec48727@busantei.com");
        userRequest.setPhone("+380985405095");
        userRequest.setRoleName("ROLE_MANAGER");
        userRequest.setUrlLogo(null);
        userRequest.setStatus(true);

        UserClient userClient = new UserClient(this.authorizationToken);
        Response response = userClient.put(userRequest);

        Assert.assertEquals(response.statusCode(), 200);

        List<UsersEntity> result = usersService.getAllNameWhereEmail();
        String actualResult = result.stream().map(el -> el.getUserFirstName()).collect(Collectors.joining());

        Assert.assertEquals(actualResult,firstName);
    }

    @Description("Verify that user can not save changes where enter to much numbers in field 'Phone'")
    @Issue("TUA-421")
    @Test
    public void userCanEditProfileWithValidNumberOfPhone() {
        CreatedUserRequest userRequest = new CreatedUserRequest();
        userRequest.setFirstName("Nastia");
        userRequest.setLastName("Kukh");
        userRequest.setEmail("soyec48727@busantei.com");
        userRequest.setPhone("123456789121212");
        userRequest.setRoleName("ROLE_MANAGER");
        userRequest.setUrlLogo(null);
        userRequest.setStatus(true);

        UserClient userClient = new UserClient(this.authorizationToken);
        Response response = userClient.put(userRequest);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(errorResponse.getMessage(), "phone Phone number must contain 10 numbers and can`t contain other symbols");
    }

    @Description("Verify that user can not save changes where enter letters in field 'Phone'")
    @Issue("TUA-421")
    @Test
    public void userCanEditProfileWithLettersInPhoneField() {
        CreatedUserRequest userRequest = new CreatedUserRequest();
        userRequest.setFirstName("Nastia");
        userRequest.setLastName("Kukh");
        userRequest.setEmail("soyec48727@busantei.com");
        userRequest.setPhone("aasss");
        userRequest.setRoleName("ROLE_MANAGER");
        userRequest.setUrlLogo(null);
        userRequest.setStatus(true);

        UserClient userClient = new UserClient(this.authorizationToken);
        Response response = userClient.put(userRequest);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(errorResponse.getMessage(), "phone Phone number must contain 10 numbers and can`t contain other symbols");
    }
    @Description("Verify that user can not save changes where enter invalid symbols in field 'Phone'")
    @Issue("TUA-421")
    @Test
    public void userCanEditProfileWithSymbolsInPhoneField() {
        CreatedUserRequest userRequest = new CreatedUserRequest();
        userRequest.setFirstName("Nastia");
        userRequest.setLastName("Kukh");
        userRequest.setEmail("soyec48727@busantei.com");
        userRequest.setPhone("@$#%#%^");
        userRequest.setRoleName("ROLE_MANAGER");
        userRequest.setUrlLogo(null);
        userRequest.setStatus(true);

        UserClient userClient = new UserClient(this.authorizationToken);
        Response response = userClient.put(userRequest);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(errorResponse.getMessage(), "phone Phone number must contain 10 numbers and can`t contain other symbols");
    }
}
