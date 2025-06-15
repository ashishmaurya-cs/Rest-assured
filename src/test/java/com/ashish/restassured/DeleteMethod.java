package com.ashish.restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteMethod {
    @Test
    public void testDelete() {
        baseURI = "https://reqres.in/api";
        given().header("x-api-key","reqres-free-v1")
                .when().delete("/users/2").then().statusCode(204);
    }
}
