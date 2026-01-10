package dummy.restapiexample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutExample {
 @Test
    public void putTest(){

        // prepare payload for update size
        LaptopPojo laptopPojo = new LaptopPojo();
        laptopPojo.setName("HP");

        LaptopPojo.Data  data = new LaptopPojo.Data();

        data.setHardDiskSize("3 TB");
        data.setPrice("1849.99");
        data.setCpuModel("Intel Core i9");
        data.setYear("2019");

        laptopPojo.setData(data);

        RestAssured.baseURI = "https://api.restful-api.dev";
        Response rs = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(laptopPojo)
                .when()
                .put("/objects/ff8081819782e69e019ba330df5c0158")
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
