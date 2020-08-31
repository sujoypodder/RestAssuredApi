package com.PostDeleteSeparate.testSuite;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostDeleteSeparateDDRun extends PostDeleteDDSeparate {

	// @Test(dataProvider = "InputData")
	public void Test_DDPost(String fname, String lname, int sid) {

		JSONObject req = new JSONObject();
		req.put("firstname", fname);
		req.put("lastname", lname);
		req.put("subjectid", sid);

		baseURI = "http://localhost:3000/";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}

	// @Test(dataProvider = "DeleteData")
	void Test_DDDelete(int userid) {

		baseURI = "http://localhost:3000/";
		when().delete("/users/" + userid).then().statusCode(200);
	}

	// ----------------- This is for test suite because this parameters value comes
	// from test suite file
	@Parameters({ "userid" })
	@Test
	void Test_DDDelete1(int userid) {

		baseURI = "http://localhost:3000/";
		when().delete("/users/" + userid).then().statusCode(200);
	}

}
