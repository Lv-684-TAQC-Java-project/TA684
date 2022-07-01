package com.ita.speakukrainian.api.challenge;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ChallengeClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.challenge.ChallengeResponse;
import com.ita.speakukrainian.api.models.challenge.CreateChallengeRequest;
import com.ita.speakukrainian.api.models.ErrorResponse;
import com.ita.speakukrainian.api.models.challenge.CreatedChallengeRequest;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChallengeTests extends BaseApiTestRunner {
    private String authorizationToken = null;
    public String description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eu";

    @BeforeClass
    public void beforeClass() {
    SignInRequest credentials = new SignInRequest(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
    SignInClient client = new SignInClient();
    Response response = client.successSingInRequest(credentials);
    SignInResponse signInResponse = response.as(SignInResponse.class);
    authorizationToken = signInResponse.getAccessToken();
}

    @Test
    public void verifyUserIsNotAbleToCreateChallengeWithLessThenNeededCharacters() {
    CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
    challengeRequest.setName("nam");
    challengeRequest.setTitle("tit");
    challengeRequest.setDescription("des");
    challengeRequest.setPicture("/upload/test/test.png");
    challengeRequest.setSortNumber("1");

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.post(challengeRequest);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertTrue(errorResponse.getMessage().contains("must contain a minimum of 5 and a maximum of 50"));
    }

 @Test
    public void verifyUserIsNotAbleToCreateChallengeWithMoreThenNeededCharacters() {
    CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
    challengeRequest.setName("Lorem ipsum dolor sit amet, consect");
    challengeRequest.setTitle("Lorem ipsum dolor sit amet, consect");
    challengeRequest.setDescription(description);
    challengeRequest.setPicture("/upload/test/test.png");
    challengeRequest.setSortNumber("1");

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.post(challengeRequest);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertTrue(errorResponse
                .getMessage()
                .contains("name  must contain a minimum of 5 and a maximum of 30 letters"));
    }

    @Test
    public void verifyUserIsNotAbleToCreateChallengeWithRusCharacters() {
    CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
    challengeRequest.setName("эЭъЪыЫёЁ");
    challengeRequest.setTitle("эЭъЪыЫёЁ");
    challengeRequest.setDescription("эЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁ");
    challengeRequest.setPicture("/upload/test/test.png");
    challengeRequest.setSortNumber("1");

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.post(challengeRequest);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertTrue(errorResponse
                .getMessage().contains("Can't contain foreign language symbols except english"));
    }

    @Test
    @Description("[allure] Success created challenge test")
    @Issue("TUA-429")
    public void successCreatedChallengeTest() {
        CreateChallengeRequest createChallengeRequest = new CreateChallengeRequest();
        createChallengeRequest.setName("Example name");
        createChallengeRequest.setTitle("Example title");
        createChallengeRequest.setDescription("Lorem ipsum dolor sit amet, consectetuer adipiscin");
        createChallengeRequest.setPicture("/upload/test/test.png");
        createChallengeRequest.setSortNumber(489437645);

        ChallengeClient client = new ChallengeClient(this.authorizationToken);
        Response response = client.post(createChallengeRequest);
        ChallengeResponse challengeResponse = response.as(ChallengeResponse.class);
        Assert.assertEquals(response.statusCode(), 200);
        response = client.delete(challengeResponse.getId());
    }
}
