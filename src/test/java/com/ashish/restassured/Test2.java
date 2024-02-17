package com.ashish.restassured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class Test2 {
	@Test
	public void test_1() {
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data[1].id", equalTo(8)).
		log().all();
	}
}
