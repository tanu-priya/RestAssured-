package tests.ic.crud;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTest;
import utils.ConfigReader;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetIMNotebooks extends BaseTest{

    
    

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
    requestSpecification.basePath(ConfigReader.get("GET_IM_NOTEBOOKS_URL"));
    requestSpecification.queryParams(queryParams);
    requestSpecification.log().all();

    response = requestSpecification.get();
    response.then().log().all();
    validatableResponse = response.then().statusCode(200).body(matchesJsonSchemaInClasspath(
                "schemas/IMNotebooksSchema.json"
            ));  

    }
    
}
