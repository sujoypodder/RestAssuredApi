package com.oauth.restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestDemo2AccessParamOauth2 {

	@Test
	public void validtestapp() {

		Response res = RestAssured.given().formParam("Client ID", "lolApp")
				.formParam("Client Secret", "129bf217a7191bd80d0eeba40b47fc78")
				.formParam("grant_type", "client_credentials").post("http://coop.apps.symfonycasts.com/token");
//		System.out.println(res.jsonPath().prettify());
		String token = res.jsonPath().get("access_token");

		Response res1 = RestAssured.given().auth().oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/1048/chickens-feed");
		Assert.assertEquals(res1.getStatusCode(), 200);
	}

	@Test
	public void invalidtestapp() {

		Response res = RestAssured.given().formParam("Client ID", "lolApp")
				.formParam("Client Secret", "129bf217a7191bd80d0eeba40b47fc78")
				.formParam("grant_type", "client_credentials").post("http://coop.apps.symfonycasts.com/token");
		String token = res.jsonPath().get("access_token");

		Response res1 = RestAssured.given().auth().oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/1048/eggs-collect");
//		System.out.println(res1.getBody().asString());
		Assert.assertEquals(res1.getStatusCode(), 200);
	}

}
