package com.ita.speakukrainian.api.clients;

<<<<<<< HEAD
import com.ita.speakukrainian.api.models.user.UserRequest;
import io.restassured.response.Response;

public class UserClient extends BaseClient{
    private final String authorizationToken;
    private final String path = "/api/user/";



    public UserClient(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    public Response put (UserRequest body, int id){
=======
import com.ita.speakukrainian.api.models.user.CreatedUserRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UserClient extends BaseClient {
    private String authorizationToken;
    private final String path = "/api/user/203";

    public UserClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response put(CreatedUserRequest body) {
>>>>>>> 1995b2a2d383be3a08f9585c183f729f989913fa
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", this.authorizationToken))
                .when()
                .body(body)
<<<<<<< HEAD
                .post(String.format("%s%s%s", this.baseUrl, this.path, id));
=======
                .put(String.format("%s%s", this.baseUrl, this.path));
>>>>>>> 1995b2a2d383be3a08f9585c183f729f989913fa
    }

    @Step("Update user by {id}")
    public Response put(int id, CreatedUserRequest body) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .body(body)
                .when()
                .put(String.format("%s/api/user/%s", baseUrl, id));
    }
}
