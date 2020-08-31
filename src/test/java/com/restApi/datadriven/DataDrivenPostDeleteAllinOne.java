package com.restApi.datadriven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenPostDeleteAllinOne {

	public class DDCreateExamplePost {

		@DataProvider(name = "InputData")
		public Object[][] DataForInput() {

			return new Object[][] { { "gareth", "bell", 1 }, { "eden", "hazard", 2 } };

		}

		//@Test(dataProvider = "InputData")
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

	@DataProvider(name = "DeleteData")
	public Object[] DataForDelete() {
		return new Object[] { 4, 5, 6, 7 };

	}

	@Test(dataProvider = "DeleteData")
	void Test_DDDelete(int userid) {

		baseURI = "http://localhost:3000/";
		when().delete("/users/" + userid).then().statusCode(200);
	}
}
