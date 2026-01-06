package utils;

import io.qameta.allure.Allure;
import io.restassured.response.Response;

public class AllureUtils {

    public static void attachRequest(String requestBody) {
        Allure.addAttachment(
                "Request Payload",
                "application/json",
                requestBody);
    }

    public static void attachRequestApiEndpoint(String apiEndpoint) {
        Allure.addAttachment(
                "API Endpoint",
                apiEndpoint);
    }

    public static void attachResponse(Response response) {
        if (response != null) {
            Allure.addAttachment(
                    "Response Body",
                    "application/json",
                    response.getBody().asString()
);

            Allure.addAttachment(
                    "Status Code",
                    String.valueOf(response.getStatusCode()));
        }
    }
}
