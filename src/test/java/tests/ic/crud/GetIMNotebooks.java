package tests.ic.crud;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import asserts.AssertActions;
import base.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetIMNotebooks extends BaseTest {

    @Test
    public void testGetIMNotebooks() {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("notebook_template_id", 4);
        queryParams.put("compute_stats", true);
        queryParams.put("include_insights_count", false);
        queryParams.put("page", 1);
        queryParams.put("pagesize", 5);
        queryParams.put("user_is_owner", true);
        queryParams.put("archived", false);
        RequestSpecification requestSpecification = baseRequest();
        requestSpecification.basePath(ConfigReader.get("GET_IM_NOTEBOOKS_URL"));
        requestSpecification.queryParams(queryParams);
        requestSpecification.log().all();

        Response res = requestSpecification.get();
        setResponse(res);
        getResponse().then().log().all();
        AssertActions.verifyNotNull(getResponse().getBody(), "Body should not be null");
        validatableResponse = getResponse().then().statusCode(200).body(matchesJsonSchemaInClasspath(
                "schemas/IMNotebooksSchema.json"));

    }

}
