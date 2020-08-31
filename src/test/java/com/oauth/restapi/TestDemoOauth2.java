package com.oauth.restapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestDemoOauth2 {

	@Test
	public void testapp1() {

		Response res = RestAssured.given().auth().oauth2("1b45bb14ac74013a1b8eca27e1e2da8e4d487acb")
				.post("http://coop.apps.symfonycasts.com/api/1048/chickens-feed");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asString());
		// System.out.println(res.getBody().jsonPath().prettify());
	}

}
