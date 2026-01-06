package dummy.restapiexample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PostTest {

    @Test
    public  void postTest(){

        Response rs = RestAssured.given()
                .contentType(ContentType.JSON)
                .body()
                .when().baseUri("https://api.restful-api.dev/objects")
                .post()
                .then()
                .extract()
                .response();
        System.out.println(rs.asString());
    }
}
