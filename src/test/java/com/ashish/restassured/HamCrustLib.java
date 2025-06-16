package com.ashish.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HamCrustLib {

    @Test
    public void testvalue() {
        RestAssured.baseURI = "https://reqres.in";
        Response response = given().header("x-api-key","reqres-free-v1")
                .when()
                .get("/api/users?page=2")
                .then()
                .assertThat()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data", hasSize(greaterThan(0)))
                .extract().response();

        System.out.println(response.asPrettyString());
    }
}
