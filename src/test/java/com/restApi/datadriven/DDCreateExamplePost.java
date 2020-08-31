package com.restApi.datadriven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DDCreateExamplePost {

	@DataProvider(name = "InputData")
	public Object[][] DataForInput() {

//		Object[][] data = new Object[2][3];
//
//		data[0][0] = "steven";
//		data[0][1] = "gerard";
//		data[0][2] = 1;
//
//		data[1][0] = "xabi";
//		data[1][1] = "alonso";
//		data[1][2] = 2;
//
//		return data;
		return new Object[][] { { "gareth", "bell", 1 }, { "eden", "hazard", 2 } };

	}

	@Test(dataProvider = "InputData")
	public void Test_DDPost(String fname, String lname, int sid) {

		JSONObject req = new JSONObject();
		req.put("firstname", fname);
		req.put("lastname", lname);
		req.put("subjectid", sid);

		baseURI = "http://localhost:3000/";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}

}
