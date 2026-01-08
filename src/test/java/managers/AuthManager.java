package managers;

import utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import modules.PayloadManager;
import pojos.response.LoginResponse;

public class AuthManager {

    private static String accessToken;
    public static void generateToken() {
        PayloadManager payloadManager = new PayloadManager();
        String payload = payloadManager.createUserPayload(
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri(ConfigReader.get("BASE_URL") + ConfigReader.get("AUTH_URL"));
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(payload);

        Response response = requestSpecification.post();

        LoginResponse loginResponse = payloadManager.parseLoginResponse(response.asString());
        accessToken = loginResponse.getAccessToken();   
    }

    public static String getAccessToken() {
        if (accessToken == null) {
            generateToken();
        }
        return accessToken;
    }   
}
    

