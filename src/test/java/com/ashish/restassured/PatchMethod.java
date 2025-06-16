package com.ashish.restassured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PatchMethod {
    @Test
    public void testPATCH() {
        JSONObject request = new JSONObject();
        request.put("name", "Ajeet");
//		request.put("job", "Automation Tester");

        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in/api" ;

        given()
                .header("Content-Type", "application/json").header("x-api-key","reqres-free-v1")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }
}
