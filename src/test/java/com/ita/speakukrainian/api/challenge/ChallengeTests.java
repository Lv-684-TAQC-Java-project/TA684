package com.ita.speakukrainian.api.challenge;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.ChallengeClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.challenge.ChallengeResponse;
import com.ita.speakukrainian.api.models.challenge.ChallengePutRequest;
import com.ita.speakukrainian.api.models.ErrorResponse;
import com.ita.speakukrainian.api.models.challenge.CreateChallengeRequest;
import com.ita.speakukrainian.api.models.challenge.CreatedChallengeRequest;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import com.ita.speakukrainian.utils.DateProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
    @Description("Verify that user is not able to create Challenge using invalid values")
    @Issue("TUA-430")
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
    @Description("Verify that user is not able to create Challenge using invalid values")
    @Issue("TUA-430")
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
    @Description("Verify that user is not able to create Challenge using invalid values")
    @Issue("TUA-430")
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

    @Test
    @Description("Verify that user is not able to create Challenge using null as values")
    @Issue("TUA-431")
    public void verifyUserIsNotAbleToCreateChallengeUsingNull() {
        CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
        challengeRequest.setName(null);
        challengeRequest.setTitle(null);
        challengeRequest.setDescription(null);
        challengeRequest.setPicture(null);
        challengeRequest.setSortNumber(null);

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.put(challengeRequest);

        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        Assert.assertEquals(response.statusCode(), 400);
        System.out.println(errorResponse.getMessage());
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(errorResponse.getMessage().contains("name must not be blank"));
        softAssert.assertTrue(errorResponse.getMessage().contains("title must not be blank"));
        softAssert.assertTrue(errorResponse.getMessage().contains("description must not be blank"));
        softAssert.assertTrue(errorResponse.getMessage().contains("sortNumber must not be null"));
        softAssert.assertTrue(errorResponse.getMessage().contains("picture must not be blank"));
        softAssert.assertAll();
    }

    @Test
    @Description("Verify that user is not able to create Challenge using spaces as values")
    @Issue("TUA-431")
    public void verifyUserIsNotAbleToCreateChallengeUsingSpace() {
        CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
        challengeRequest.setName(" ");
        challengeRequest.setTitle(" ");
        challengeRequest.setDescription(" ");
        challengeRequest.setPicture(" ");
        challengeRequest.setSortNumber(" ");

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.put(challengeRequest);

        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        Assert.assertEquals(response.statusCode(), 400);
        System.out.println(errorResponse.getMessage());
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(errorResponse.getMessage().contains("name  must contain a minimum of 5 and a maximum of 30 letters"));
        softAssert.assertTrue(errorResponse.getMessage().contains("title must contain a minimum of 5 and a maximum of 50 letters"));
        softAssert.assertTrue(errorResponse.getMessage().contains("description must not be blank"));
        softAssert.assertTrue(errorResponse.getMessage().contains("sortNumber must not be null"));
        softAssert.assertTrue(errorResponse.getMessage().contains("picture Incorrect file path. It must be like /upload/*/*.png"));
        softAssert.assertAll();
    }

    @Test
    @Description("Verify that user is not able to create Challenge with absence of symbols as values")
    @Issue("TUA-431")
    public void verifyUserIsNotAbleToCreateChallengeUsingAbsenceOfSymbols() {
        CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
        challengeRequest.setName("");
        challengeRequest.setTitle("");
        challengeRequest.setDescription("");
        challengeRequest.setPicture("");
        challengeRequest.setSortNumber("");

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.put(challengeRequest);

        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        Assert.assertEquals(response.statusCode(), 400);
        System.out.println(errorResponse.getMessage());
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(errorResponse.getMessage().contains("name  must contain a minimum of 5 and a maximum of 30 letters"));
        softAssert.assertTrue(errorResponse.getMessage().contains("title must contain a minimum of 5 and a maximum of 50 letters"));
        softAssert.assertTrue(errorResponse.getMessage().contains("description must not be blank"));
        softAssert.assertTrue(errorResponse.getMessage().contains("sortNumber must not be null"));
        softAssert.assertTrue(errorResponse.getMessage().contains("picture Incorrect file path. It must be like /upload/*/*.png"));
        softAssert.assertAll();

    }



    @Test
    @Description("[allure] Verify that user is able to edit information about Challenge using valid values")
    @Issue("TUA-432")
    public void verifyThatUserIsAbleToEditInformationAboutChallengeUsingValidValuesTest() {
        ChallengePutRequest request = new ChallengePutRequest();
        ChallengeClient client = new ChallengeClient(this.authorizationToken);
        DateProvider date = new DateProvider();
        int taskId = 388;
        Integer challengeId = 241;

        request.setName("Example name");
        request.setTitle("Example title");
        request.setHeaderText("stringstringstringstringstringstringstri");
        request.setDescription("Lorem ipsum dolor sit amet, consectetuer adipiscin");
        request.setPicture("/upload/test/test.png");
        request.setSortNumber(1);
        request.setStartDate(date.dateFuture());
        request.setChallengeId(challengeId);

        Response response = client.put(request,taskId);
        Assert.assertEquals(response.statusCode(), 200);
    }


    @Test
    @Description("[allure] Verify that user is not able to edit information about Challenge using invalid values")
    @Issue("TUA-433")
    public void verifyUserIsNotAbleToEditChallengeWithInvalidValues1Test() {
        CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
        challengeRequest.setName("nam");
        challengeRequest.setTitle("tit");
        challengeRequest.setDescription("des");
        challengeRequest.setPicture("abc");
        challengeRequest.setSortNumber("abc");

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.put(challengeRequest);

        Assert.assertEquals(response.statusCode(), 400);
    }

    @Test
    @Description("[allure] Verify that user is not able to edit information about Challenge using invalid values")
    @Issue("TUA-433")
    public void verifyUserIsNotAbleToEditChallengeWithInvalidValues2Test() {
        CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
        challengeRequest.setName("Lorem ipsum dolor sit amet, consect");
        challengeRequest.setTitle( "Lorem ipsum dolor sit amet, consect");
        challengeRequest.setDescription("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eu");
        challengeRequest.setPicture("abc");
        challengeRequest.setSortNumber("abc");

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.put(challengeRequest);

        Assert.assertEquals(response.statusCode(), 400);
    }

    @Test
    @Description("[allure] Verify that user is not able to edit information about Challenge using invalid values")
    @Issue("TUA-433")
    public void verifyUserIsNotAbleToEditChallengeWithInvalidValues3Test() {
        CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
        challengeRequest.setName("эЭъЪыЫёЁ");
        challengeRequest.setTitle("эЭъЪыЫёЁ");
        challengeRequest.setDescription("эЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁ");
        challengeRequest.setPicture("эЭъЪыЫёЁ");
        challengeRequest.setSortNumber("эЭъЪыЫёЁ");

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.put(challengeRequest);

        Assert.assertEquals(response.statusCode(), 400);
    }

    @Test
    @Description("[allure] Verify that user is not able to edit information about Challenge using invalid values")
    @Issue("TUA-433")
    public void verifyUserIsNotAbleToEditChallengeWithInvalidValues4Test() {
        CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
        challengeRequest.setName("_");
        challengeRequest.setTitle("_");
        challengeRequest.setDescription("_");
        challengeRequest.setPicture("_");
        challengeRequest.setSortNumber("_");

        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);
        Response response = challengeClient.put(challengeRequest);

        Assert.assertEquals(response.statusCode(), 400);
    }

    @Test
    @Description("[allure] Verify that user is not able to edit information about Challenge using null, spaces or absence of symbols as values")
    @Issue("TUA-434")
    public void userCantEditInformationAboutChallengeUsingNullSpacesOrAbsence1Test() {
        CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);

        challengeRequest.setName(null);
        challengeRequest.setTitle(null);
        challengeRequest.setDescription(null);
        challengeRequest.setPicture(null);
        challengeRequest.setSortNumber(null);

        Response response = challengeClient.put(challengeRequest);
        Assert.assertEquals(response.statusCode(), 400);
    }

    @Test
    @Description("[allure] Verify that user is not able to edit information about Challenge using null, spaces or absence of symbols as values")
    @Issue("TUA-434")
    public void userCantEditInformationAboutChallengeUsingNullSpacesOrAbsence2Test() {
        CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);

        challengeRequest.setName("  ");
        challengeRequest.setTitle("  ");
        challengeRequest.setDescription("  ");
        challengeRequest.setPicture("  ");
        challengeRequest.setSortNumber("  ");

        Response response = challengeClient.put(challengeRequest);
        Assert.assertEquals(response.statusCode(), 400);
    }

    @Test
    @Description("[allure] Verify that user is not able to edit information about Challenge using null, spaces or absence of symbols as values")
    @Issue("TUA-434")
    public void userCantEditInformationAboutChallengeUsingNullSpacesOrAbsence3Test() {
        CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
        ChallengeClient challengeClient = new ChallengeClient(this.authorizationToken);

        challengeRequest.setName("");
        challengeRequest.setTitle("");
        challengeRequest.setDescription("");
        challengeRequest.setPicture("");
        challengeRequest.setSortNumber("");

        Response response = challengeClient.put(challengeRequest);
        Assert.assertEquals(response.statusCode(), 400);
    }

    @Test
    @Description("[allure] Verify that user is able to delete Challenge using administrator rights")
    @Issue("TUA-435")
    public void userCanDeleteChallengeUsingAdministratorRightsTest() {
        CreatedChallengeRequest challengeRequest = new CreatedChallengeRequest();
        ChallengeClient client = new ChallengeClient(this.authorizationToken);
        CreateChallengeRequest createChallengeRequest = new CreateChallengeRequest();

        createChallengeRequest.setName("Example name");
        createChallengeRequest.setTitle("Example title");
        createChallengeRequest.setDescription("Lorem ipsum dolor sit amet, consectetuer adipiscin");
        createChallengeRequest.setPicture("/upload/test/test.png");
        createChallengeRequest.setSortNumber(489437645);

        Response response = client.post(createChallengeRequest);
        ChallengeResponse challengeResponse = response.as(ChallengeResponse.class);
        response = client.delete(challengeResponse.getId());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
