package com.ita.speakukrainian.api.clients;

import com.ita.speakukrainian.utils.DataProvider;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class BaseClient {
    protected String baseUrl;
    protected ContentType contentType;
    protected DataProvider dataProvider;

    public BaseClient() {
        if (dataProvider == null) {
            try {
                dataProvider = new DataProvider();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        baseUrl = dataProvider.getApiUrl();
        contentType = ContentType.JSON;
    }
    @Step("Get URL for API connection")
    protected RequestSpecification prepareRequest() {
        return given().baseUri(baseUrl).contentType(contentType).accept(contentType);
    }


}
