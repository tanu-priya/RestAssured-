package tests.ic.crud;

import org.testng.annotations.Test;

import base.BaseTest;
import dataProviders.LoginDataProvider;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class Login extends BaseTest {

    @Test(dataProvider = "loginDataProvider", dataProviderClass = LoginDataProvider.class)
    public void testLogin(String email, String password, int statusCode) {
        String payload = payloadManager.createUserPayload(email, password);
        RequestSpecification requestSpecification = baseRequest();
        requestSpecification.basePath(ConfigReader.get("AUTH_URL"));
        requestSpecification.body(payload);
        requestSpecification.log().all();
        Response res = requestSpecification.post();
        setResponse(res);
        getResponse().then().log().all();
        validatableResponse = getResponse().then().statusCode(statusCode);
    }
}
