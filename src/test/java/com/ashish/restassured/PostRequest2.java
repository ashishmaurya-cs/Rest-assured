package com.ashish.restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest2 {

    @Test
    public void testCreateData(){

        //prepare payload

        EmployeePojo ep = new EmployeePojo();
        ep.setId(101);
        ep.setName("Ajay");
        ep.setSalary(12000);

            EmployeePojo.Contacts contacts = new EmployeePojo.Contacts();
            contacts.setMobile1(1234567890);
            contacts.setMobile2(1234456789);

        ep.setContacts(contacts);


        RequestSpecification rs = given()
                .contentType(ContentType.JSON)
                .baseUri("https://dummy.restapiexample.com");

        Response response = rs
                .when()
                .body(ep)
                .post("api/v1/create")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
//                .body("data.id", equalTo(101))
                .body("data.name", equalTo("Ajay"))
                .body("data.salary", equalTo(12000))
                .body("data.contacts.mobile1", equalTo(1234567890))
                .body("data.contacts.mobile2", equalTo(1234456789))
                .body("message", containsString("Successfully"))
                .extract()
                .response();

        System.out.println(response.asPrettyString());

    }
}
