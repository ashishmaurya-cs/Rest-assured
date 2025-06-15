package com.ashish.restassured;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
public class PostRequest {

    @Test
    public void testPost(){
    baseURI="https://reqres.in/api/";

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name","ram");
        jsonObject.put("job","Tester");
        Response res = given()
                .headers("Content-Type", "application/json",
                        "x-api-key","reqres-free-v1")
                .body(jsonObject.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .response();

        System.out.println(res.asPrettyString());
    }
}
