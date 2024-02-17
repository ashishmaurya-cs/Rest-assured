package com.ashish.restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
public class Test3 {
	@Test
	public void test_2() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
		.body("data[1].id", equalTo(8)).
		body("data.first_name", hasItems("George","Rachel"));
	}
	
	@Test
	public void testPost() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Ram");
//		map.put("job", "Engineer");
//		System.out.println(map);
		
		
//		JSONObject request = new JSONObject(map);
		JSONObject request = new JSONObject();
		request.put("name", "Ram");
		request.put("job", "Engineer");
		System.out.println(request.toJSONString());
		given()
			.headers("Content-Type","application/json")
			.contentType(io.restassured.http.ContentType.JSON)
			.accept(io.restassured.http.ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("https://reqres.in/api/users").
		then()
			.statusCode(201).log().all();
	}

}
