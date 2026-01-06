package dummy.restapiexample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PostTest {

    @Test
    public  void postTest(){

        //prepare body
        LaptopPojo laptopPojo = new LaptopPojo();
        laptopPojo.setName("HP");

        // static inner class preparation
        LaptopPojo.Data data= new LaptopPojo.Data();
        data.setYear("2024");
        data.setPrice("30000");
        data.setCpuModel("Intel core i3");
        data.setHardDiskSize("500 GB");

        laptopPojo.setData(data);

        Response rs = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(laptopPojo)
                .when().baseUri("https://api.restful-api.dev/objects")
                .post()
                .then()
                .extract()
                .response();
        System.out.println(rs.asString());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rs.getStatusCode(),200);
        softAssert.assertEquals(rs.jsonPath().getString("name"),"HPS");

        //Mandatory to add(otherwise all test will get pass)
        softAssert.assertAll();
    }
}
