package com.ashish.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class PutPATCHTest {
	@Test
	public void testPut() {
		JSONObject request = new JSONObject();
		request.put("name", "Ajeet");
		request.put("job", "Automation Tester");
		
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api" ;
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/users/2")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test
	public void testPATCH() {
		JSONObject request = new JSONObject();
		request.put("name", "Ajeet");
//		request.put("job", "Automation Tester");
		
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api" ;
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("/users/2")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test
	public void testDelete() {
		baseURI = "https://reqres.in/api";
		when().delete("/users/2").then().statusCode(204);
	}
	
}
