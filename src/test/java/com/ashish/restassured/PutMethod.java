package com.ashish.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;

public class PutMethod {
	@Test
	public void testPut() {
		JSONObject request = new JSONObject();
		request.put("name", "Ajeet");
		request.put("job", "Automation Tester");
		
		System.out.println(request.toJSONString());
		baseURI = "https://dummy.restapiexample.com/api" ;
		
		given()
			.header("Content-Type", "application/json")
				.header("x-api-key","reqres-free-v1")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/v1/update/21")
		.then()
			.statusCode(200)
				.body("message",containsString("updated"))
			.log().all();
		
	}
	
}
