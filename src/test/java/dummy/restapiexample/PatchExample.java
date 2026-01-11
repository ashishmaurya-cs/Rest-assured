package dummy.restapiexample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchExample {

    @Test
    public void patchTest(){

        // prepare payload for update size
        LaptopPojo laptopPojo = new LaptopPojo();
        laptopPojo.setName("HP");

        RestAssured.baseURI = "https://api.restful-api.dev";
        Response rs = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(laptopPojo)
                .when()
                .patch("/objects/ff8081819782e69e019ba330df5c0158")
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println(rs.jsonPath().getString("name"));

        // Assertions
        Assert.assertEquals(rs.jsonPath().getString("name"), "HP");
        Assert.assertEquals(rs.jsonPath().getInt("data.year"), 2019);
        Assert.assertEquals(rs.jsonPath().getString("data.cpuModel"), "Intel Core i9");

    }

}
