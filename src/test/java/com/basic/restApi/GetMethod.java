package com.basic.restApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class GetMethod {
	@Test
	void getTest() {

		Response res = get("https://reqres.in/api/users?page=2");
		System.out.println(res.asString());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		System.out.println(res.getTime());

		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("get status code is matching");
	}

	@Test
	void getTest1() {

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));
		// given().get().getStatusCode();
		System.out.println("get status code is matching again");
	}

}
