package dummy.restapiexample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetExample {

    @Test
    public void getTest(){
    RestAssured.given().contentType("application/json").when()
            .get("https://dummy.restapiexample.com/api/v1/employee/24")
            .then().body(
                    "status",equalTo("success")
            );

//        System.out.println(rs.asString());
    }

}
