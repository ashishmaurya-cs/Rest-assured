package dummy.restapiexample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteExample {
    @Test
    public  void testDelete(){
        RestAssured.baseURI="https://api.restful-api.dev/objects/6";

        Response rs = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete()
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println(rs.asString());
    }
}
