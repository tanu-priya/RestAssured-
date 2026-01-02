package base;

import org.testng.annotations.*;

import asserts.AssertActions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import modules.PayloadManager;
import utils.AllureUtils;
import utils.ConfigReader;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public AssertActions assertActions = new AssertActions();
    public PayloadManager payloadManager = new PayloadManager();

    @BeforeTest
    public void setup() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(ConfigReader.get("BASE_URL"));
        requestSpecification.header("Content-Type", "application/json");
        System.out.println("Base test setup completed.");
    }

    @AfterTest(alwaysRun = true)
    public void attachAllureResponse() {
        AllureUtils.attachResponse(response);
    }
}
