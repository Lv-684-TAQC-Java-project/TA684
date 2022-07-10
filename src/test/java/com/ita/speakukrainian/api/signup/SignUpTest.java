package com.ita.speakukrainian.api.signup;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.SignupClient;
import com.ita.speakukrainian.api.models.signup.SignupRequest;
import com.ita.speakukrainian.utils.jdbc.entity.UsersEntity;
import com.ita.speakukrainian.utils.jdbc.services.UsersService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SignUpTest extends BaseApiTestRunner {
    private String authorizationToken = null;

    @Test
    @Description("[allure] Verify that a user with invalid data in \"Пароль\" field can`t be created")
    @Issue("TUA-499")
    public void userCantCreatedWithInvalidValuesTest() {
        SignupClient client = new SignupClient(this.authorizationToken);
        SignupRequest request = new SignupRequest();
        UsersService user = new UsersService();
        List<UsersEntity> list =  user.getAllNameWhereEmailIs("terasdsa123@busantei.com");

        request.setFirstName("firstname");
        request.setLastName("lastname");
        request.setEmail("terasdsa123@busantei.com");
        request.setPassword("123456");
        request.setPhone("0453567890");
        request.setRoleName("ROLE_MANAGER");

        Response response = client.post(request);
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertTrue(list.isEmpty());

    }
}
