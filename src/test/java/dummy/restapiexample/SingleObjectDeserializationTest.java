package dummy.restapiexample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleObjectDeserializationTest {

    @Test
    public  void validateResponse(){
        Response rs = RestAssured.given()
                .baseUri("https://api.restful-api.dev/objects/ff8081819782e69e019ba330df5c0158")
                .when()
                .get()
                .then().extract().response();

        SingleObjectDeserializationPojo sp=rs.as(SingleObjectDeserializationPojo.class);

        Assert.assertEquals(sp.getData().getPrice(),"1849.99");
        Assert.assertEquals(sp.getData().getYear(),"2019");
    }
}
