package dummy.restapiexample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderValidation {

    @Test
    public void getTest() {
        Response rs = RestAssured.given().contentType("application/json")
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employee/24")
                .then().extract().response();

        System.out.println(rs.headers().get("X-RateLimit-Limit")+"\n"+ rs.headers().get("retry-after"));

        Assert.assertEquals(rs.headers().get("X-RateLimit-Limit").getValue(),60);
    }

}
