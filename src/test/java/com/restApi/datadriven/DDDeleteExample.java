package com.restApi.datadriven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDDeleteExample {

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
