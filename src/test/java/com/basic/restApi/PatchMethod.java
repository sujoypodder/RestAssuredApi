package com.basic.restApi;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchMethod {

	@Test
	void patchTest1() {

		JSONObject req = new JSONObject();
		req.put("name", "sujoy");
		req.put("job", "tester");
		System.out.println(req);
		System.out.println(req.toJSONString());
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log()
				.all();

	}

}
