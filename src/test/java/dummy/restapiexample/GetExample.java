package dummy.restapiexample;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetExample {

    @Test
    public void getTest(){
    RestAssured.given().contentType("application/json")
            .when()
            .get("https://dummy.restapiexample.com/api/v1/employee/24")
            .then().body(
                    "status",equalTo("success"),
                    "data.id",equalTo(24),
                    "message",equalTo("Successfully! Record has been fetched.")
            );

//        System.out.println(rs.asString());
    }

}
