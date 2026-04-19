package practice;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class GetExample {
    @Test
    public void getEmployee() {
        Response rs = given()
                .header("Content-Type", "application/json")
                .when()
                .get("https://dummy.restapiexample.com/employees")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .extract().response();

        System.out.println(rs.asString());
    }
}
