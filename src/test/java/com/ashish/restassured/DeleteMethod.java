package com.ashish.restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class DeleteMethod {
    @Test
    public void testDelete() {
        baseURI = "https://reqres.in/api";
        when().delete("/users/2").then().statusCode(204);
    }
}
