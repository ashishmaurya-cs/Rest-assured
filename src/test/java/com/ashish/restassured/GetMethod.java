package com.ashish.restassured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class GetMethod {

	@Test
	public void test_1() {
		given().
			get("https://jsonplaceholder.typicode.com/comments?postId=1").
		then().
			statusCode(200).
			body("[0].email", equalTo("Eliseo@gardner.biz")).
		log().all();
	}
}
