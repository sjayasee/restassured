package com.rest.restassurred;

import org.json.simple.JSONObject;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;

public class BDDAPITest {	
	
	@Test
	public void getApiTest() {
		baseURI="https://reqres.in/api/users?";
		
		// BDD
		given()
			.queryParam("page", 2)
		.when()
			.get()
		.then()
			.statusCode(200)
			.log().all();	
	}
	
	@Test
	public void postApiTest() {
		
		baseURI="https://reqres.in/api/users?";
		
		JSONObject jsondata	= new JSONObject();
		jsondata.put("name", "Test");
		jsondata.put("job", "Tester");
		
		given()
			.header("Content-type", "application/json")
			.body(jsondata.toJSONString())
		.when()
			.post()
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	public void putApiTest() {
		
baseURI="https://reqres.in/api/users/9";
		
		JSONObject jsondata	= new JSONObject();
		jsondata.put("name", "Test");
		jsondata.put("job", "Testerr");
		
		given()
			.header("Content-type", "application/json")
			.body(jsondata.toJSONString())
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void patchApiTest() {
		
baseURI="https://reqres.in/api/users/9";
		
		JSONObject jsondata	= new JSONObject();
		jsondata.put("name", "TestPatch");
		//jsondata.put("job", "Testerr");
		
		given()
			.header("Content-type", "application/json")
			.body(jsondata.toJSONString())
		.when()
			.patch()
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void DeleteApiTest() {
		
		baseURI="https://reqres.in/api/users/9";
		
		given()
		.when()
			.delete()
		.then()
			.statusCode(204)
			.log().all();
	}

}
