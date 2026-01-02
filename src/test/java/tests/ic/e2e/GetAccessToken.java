package tests.ic.e2e;
import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.RestAssured;
import pojos.response.LoginResponse;
import utils.AllureUtils;
import utils.ConfigReader;

public class GetAccessToken extends BaseTest {

    @Test

    public void testAccessToken() {
        String payload = payloadManager.createUserPayload(ConfigReader.get("email"), ConfigReader.get("password"));
        AllureUtils.attachRequest(payload);
        AllureUtils.attachRequestApiEndpoint(ConfigReader.get("BASE_URL") + ConfigReader.get("AUTH_URL"));
        requestSpecification.basePath(ConfigReader.get("AUTH_URL"));
        response = RestAssured.given()
                .spec(requestSpecification)
                .body(payload)
                .when()
                .post()
                .then().statusCode(200).extract().response();
        System.out.println("Response: " + response.asString());
        LoginResponse loginResponse = payloadManager.parseLoginResponse(response.asString());
        System.out.println("loginResponse: " + loginResponse.getAccessToken());
        ;
    }

}
