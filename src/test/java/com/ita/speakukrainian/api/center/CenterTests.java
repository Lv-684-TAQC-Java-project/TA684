package com.ita.speakukrainian.api.center;

import com.ita.speakukrainian.api.BaseApiTestRunner;
import com.ita.speakukrainian.api.clients.CenterClient;
import com.ita.speakukrainian.api.clients.SignInClient;
import com.ita.speakukrainian.api.models.center.CreatedCenterRequest;
import com.ita.speakukrainian.api.models.center.Location;
import com.ita.speakukrainian.api.models.signin.SignInRequest;
import com.ita.speakukrainian.api.models.signin.SignInResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CenterTests extends BaseApiTestRunner {
    private String authorizationToken = null;
    @BeforeClass
    public void beforeClass() {
        SignInRequest credentials = new SignInRequest(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
        SignInClient client = new SignInClient();
        Response response = client.successSingInRequest(credentials);
        SignInResponse signInResponse = response.as(SignInResponse.class);
        authorizationToken = signInResponse.getAccessToken();
    }

    @Test
    public void successCreatedCenterTest() {
        CreatedCenterRequest createdCenterRequest = new CreatedCenterRequest();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        createdCenterRequest.setName(String.format("test_%s", timestamp.getTime()));
        createdCenterRequest.setDescription("testtesttesttesttesttesttesttesttesttest");
        createdCenterRequest.setUserId(1);
        createdCenterRequest.setContacts("{\"1\"::\"0000000000\"}");
        createdCenterRequest.setClubsId(Arrays.asList(916, 978));
        Location location = new Location();
        location.setId(2199);
        location.setName("Club1");
        location.setCityName("Київ");
        location.setAddress("Мазепа 55");
        location.setLatitude(49.829104498711104);
        location.setLongitude(24.005058710351314);
        location.setPhone("0938784576");
        location.setCoordinates("49.829104498711104, 24.005058710351314");
        createdCenterRequest.setLocations(Arrays.asList(location));

        CenterClient client = new CenterClient(this.authorizationToken);
        Response response = client.post(createdCenterRequest);
        Assert.assertEquals(response.statusCode(), 200);



    }

}
