package base;

import org.testng.annotations.*;

import asserts.AssertActions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import managers.AuthManagar;
import modules.PayloadManager;
import utils.AllureUtils;
import utils.ConfigReader;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public AssertActions assertActions = new AssertActions();
    public PayloadManager payloadManager = new PayloadManager();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        AuthManagar.generateToken();
    }

    @BeforeClass
    public void setUp() {
    requestSpecification = RestAssured.given();
        requestSpecification.baseUri(ConfigReader.get("BASE_URL"));
        requestSpecification.contentType("application/json");
        requestSpecification.header(
                "Authorization",
                "Bearer " + AuthManagar.getAccessToken()
            );
}
    @AfterTest(alwaysRun = true)
    public void attachAllureResponse() {
        AllureUtils.attachResponse(response);
    }
}
