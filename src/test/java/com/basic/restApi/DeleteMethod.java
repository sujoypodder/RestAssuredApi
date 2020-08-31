package com.basic.restApi;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteMethod {

	@Test
	void deleteTest1() {

		when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();

	}

}
