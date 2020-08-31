package com.basic.restApi;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GetMethodR {

	@Test
	void getTest1() {

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[1]", equalTo(8))
				.body("data.first_name", hasItems("Michael", "Lindsay"));
		System.out.println("get status code is matching again");
	}

}
