package com.basic.restApi;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class OwnMadeApiAll {

	// GET
	// @Test
	public void get_Test() {

		baseURI = "http://localhost:3000/";
		given().param("name", "automation").get("/subjects").then().statusCode(200).log().all(); // only show
																									// automation
																									// subject
																									// beacause of
																									// parametarization
	}

	// POST
	// @Test
	public void post_Test() {

		JSONObject req = new JSONObject();
		req.put("firstname", "bradly");
		req.put("lastname", "cooper");
		req.put("subjectid", 2);

		baseURI = "http://localhost:3000/";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}

	// PATCH
	// @Test
	public void patch_Test() {

		JSONObject req = new JSONObject();
		req.put("lastname", "marrie");

		baseURI = "http://localhost:3000/";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJSONString()).when().patch("/users/4").then().statusCode(200).log().all();
	}

	// PUT
	// @Test
	public void put_Test() {

		JSONObject req = new JSONObject();
		req.put("firstname", "toni");
		req.put("lastname", "kroos's");
		req.put("subjectid", 2);

		baseURI = "http://localhost:3000/";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJSONString()).when().put("/users/4").then().statusCode(200).log().all();
	}

	// DELETE
	@Test
	public void delete_Test() {

		baseURI = "http://localhost:3000/";
		when().delete("/users/4").then().statusCode(404); // delete always take 204 but sometimes it takes 200/404
	}

}
