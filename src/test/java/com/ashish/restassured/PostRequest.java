package com.ashish.restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
public class PostRequest {

    @Test
    public void testPost(){

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name","ram");
        jsonObject.put("job","Tester");

        RequestSpecification rs= given()
                .header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in/api")
                .contentType(ContentType.JSON);

        Response res = rs
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
