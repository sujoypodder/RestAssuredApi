package com.oauth.restapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestDemoOauth1 {

	@Test
	public void tweetpost() {
		// oauth basically fill up for key value and token from twitter
		Response res = RestAssured.given().auth().oauth("5091", "2643743", "1485762037", "1485794875").post(
				"https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().jsonPath().prettify());
		JsonPath json = res.jsonPath();
		String tweetId = json.get("id_str");
		System.out.println("my tweet id is " + tweetId);
	}
}
