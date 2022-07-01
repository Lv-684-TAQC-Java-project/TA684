package com.ita.speakukrainian.api.challenge;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ChallengeClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.challenge.CreatedChallengeRequest;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
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

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.post(challengeRequest);

        Assert.assertEquals(response.statusCode(), 400);
    }

 @Test
    public void verifyUserIsNotAbleToCreateChallengeWithMoreThenNeededCharacters() {
    CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
    challengeRequest.setName("Lorem ipsum dolor sit amet, consect");
    challengeRequest.setTitle("Lorem ipsum dolor sit amet, consect");
    challengeRequest.setDescription(description);

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.post(challengeRequest);

        Assert.assertEquals(response.statusCode(), 400);
    }

    @Test
    public void verifyUserIsNotAbleToCreateChallengeWithRusCharacters() {
    CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
    challengeRequest.setName("эЭъЪыЫёЁ");
    challengeRequest.setTitle("эЭъЪыЫёЁ");
    challengeRequest.setDescription("эЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁ");

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.post(challengeRequest);

        Assert.assertEquals(response.statusCode(), 400);
    }
}
