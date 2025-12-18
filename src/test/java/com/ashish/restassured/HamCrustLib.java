package com.ashish.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class HamCrustLib {

    @Test
    public void testValue() {

        RequestSpecification rs= given().
                header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in");

        Response response =rs
                .when()
                .get("/api/users?page=2")
                .then()
                .assertThat()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data", hasSize(greaterThan(0)))
                .body("total_pages",equalTo(2))
                .extract().response();

        System.out.println(response.asPrettyString());
    }
}
