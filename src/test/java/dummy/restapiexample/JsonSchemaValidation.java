package dummy.restapiexample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidation {

    @Test
    public void getTestSchemaValidation() {
         RestAssured.given().contentType("application/json")
                .when()
                .get("https://api.restful-api.dev/objects/ff8081819782e69e019ba330df5c0158")
                .then().assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }
}
