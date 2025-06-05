package com.ashish.restassured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HemCrustLib {

    @Test
    public void test_1() {
        Response response = (Response) given().
                get("https://reqres.in/api/users?page=2").
                then().extract();

        System.out.println(response.asPrettyString());
    }
}
