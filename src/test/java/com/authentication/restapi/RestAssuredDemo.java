package com.authentication.restapi;

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestAssuredDemo extends BaseClass {

	@Test
	public void test1() {
		int code = RestAssured.given().get().getStatusCode();
		System.out.println("response code from server is " + code);
	}

}
// https://www.toolsqa.com/rest-assured/authentication-and-authorization-in-rest-webservices/
/*
 * without extending--
 * 
 * @Test public void test1() { int code =
 * RestAssured.given().auth().preemptive().basic("ToolsQA",
 * "TestPassword").when()
 * .get("http://restapi.demoqa.com/authentication/CheckForAuthentication/").
 * getStatusCode(); System.out.println("response code from server is " + code);
 * }
 */
