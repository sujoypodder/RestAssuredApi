package com.basic.restApi;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostMethod {

	@Test
	void postTest1() {

//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "sujoy");
//		map.put("job", "tester");
//		System.out.println(map);

		JSONObject req = new JSONObject();
		req.put("name", "sujoy");
		req.put("job", "tester");
		System.out.println(req);
		System.out.println(req.toJSONString());
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);

	}

}
