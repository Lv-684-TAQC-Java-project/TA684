package com.ita.speakukrainian.api.user;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.clients.UserClient;
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
        String firstName = "Anna";
        String lastName = "Kukarska";
        String phone = "+380985405099";
        int id = 203;

        userRequest.setFirstName("Nastia");
        userRequest.setLastName("Kukh");
        userRequest.setEmail("soyec48727@busantei.com");
        userRequest.setPhone("+380985405095");
        userRequest.setRoleName("ROLE_MANAGER");
        userRequest.setUrlLogo(null);
        userRequest.setStatus(true);

        UserClient userClient = new UserClient(this.authorizationToken);
        Response response = userClient.put(userRequest,id);
        Assert.assertEquals(response.statusCode(), 200);

        userRequest.setFirstName(firstName);
        response = userClient.put(userRequest,id);
        Assert.assertEquals(response.statusCode(), 200);

        userRequest.setLastName(lastName);
        response = userClient.put(userRequest,id);
        Assert.assertEquals(response.statusCode(), 200);

        userRequest.setPhone(phone);
        response = userClient.put(userRequest,id);
        Assert.assertEquals(response.statusCode(), 200);

        List<UsersEntity> result = usersService.getAllNameWhereEmail();
        String actualFirstName = result.stream().map(el -> el.getUserFirstName()).collect(Collectors.joining());
        String actualLastName = result.stream().map(el -> el.getUserLastName()).collect(Collectors.joining());
        String actualPhone = result.stream().map(el -> el.getUserPhone()).collect(Collectors.joining());

        Assert.assertEquals(actualFirstName,firstName);
        Assert.assertEquals(actualLastName,lastName);
        Assert.assertEquals(actualPhone,phone);
    }
}
