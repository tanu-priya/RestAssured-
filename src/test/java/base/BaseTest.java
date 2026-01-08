package base;

import org.testng.annotations.*;

import asserts.AssertActions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import managers.AuthManager;
import modules.PayloadManager;
import utils.AllureUtils;
import utils.ConfigReader;

public class BaseTest {
    private static ThreadLocal<Response> response = new ThreadLocal<>();
    public RequestSpecification requestSpecification;
    public ValidatableResponse validatableResponse;
    public AssertActions assertActions = new AssertActions();
    public PayloadManager payloadManager = new PayloadManager();

    protected void setResponse(Response res) {
        response.set(res);
    }

    protected Response getResponse() {
        return response.get();
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        AuthManager.generateToken();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        RestAssured.baseURI = ConfigReader.get("BASE_URL");

    }

    protected RequestSpecification baseRequest() {
        return RestAssured
                .given()
                .contentType("application/json")
                .header(
                        "Authorization",
                        "Bearer " + AuthManager.getAccessToken());
    }

    @AfterMethod(alwaysRun = true)
    public void attachAllureResponse() {
        if (getResponse() != null) {
            AllureUtils.attachResponse(getResponse());
        }
        response.remove();

    }

}
