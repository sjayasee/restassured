package com.rest.restassurred;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;

public class TestApi {
	
	@Test
	public void validateAPI() {
		
		Response response =  RestAssured.get("https://reqres.in/api/users?page=1");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		//System.out.println(response.body().asPrettyString());
	}
	
	@Test
	public void validateAPI2() {
		
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users?page=1");
		
		Response response = reqspec.get();
		System.out.println(response.getStatusCode());
		//System.out.println(response.asPrettyString());
		System.out.println(response.getTime());
		
		ResponseBody responsebody = response.getBody();
		//System.out.println(responsebody.asPrettyString());
		//System.out.println(responsebody.htmlPath());
		//System.out.println(responsebody.jsonPath());
		
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;
		
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}
	
	@Test
	public void validateAPI3() {
		
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users?page=1");
		Response response = reqspec.get();
		
		System.out.println(response.getHeader("Connection"));
		System.out.println(response.getContentType());
		System.out.println(response.getSessionId());
	}
	
	@Test
	public void HeadersTest() {
		
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users?page=1");
		Response response = reqspec.get();
		
		Headers header = response.getHeaders();
		for( Header h:header) {
			System.out.println("Name of Header is - "+h.getName()+" - Value of Header is - "+h.getValue());
		}
		
	}
	
	@Test
	public void ResponseTest() {
		
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users?page=1");
		Response response = reqspec.get();
		
		ResponseBody responsebody = response.getBody();
		String responseString = response.asString();
		//System.out.println(responseString);
		
		JsonPath jsonPath = responsebody.jsonPath();
		System.out.println(jsonPath.get("data[0].id").toString());
		System.out.println(jsonPath.get("data[0].email").toString());
		System.out.println(jsonPath.get("data[0].first_name").toString());
		System.out.println(jsonPath.get("data[0].last_name").toString());
		System.out.println(jsonPath.get("data[0].avatar").toString());
		System.out.println();
		
		System.out.println(jsonPath.get("data[1].id").toString());
		System.out.println(jsonPath.get("data[1].email").toString());
		System.out.println(jsonPath.get("data[1].first_name").toString());
		System.out.println(jsonPath.get("data[1].last_name").toString());
		System.out.println(jsonPath.get("data[1].avatar").toString());
		System.out.println();
		
		System.out.println(jsonPath.get("data[5].id").toString());
		System.out.println(jsonPath.get("data[5].email").toString());
		System.out.println(jsonPath.get("data[5].first_name").toString());
		System.out.println(jsonPath.get("data[5].last_name").toString());
		System.out.println(jsonPath.get("data[5].avatar").toString());
		
	}
	
	@Test
	public void Validate() {
		
		String baseURI = "https://reqres.in";
		
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users?page=1");
		Response response = reqspec.get();
		
		ResponseBody responsebody = response.getBody();
		
	}

}
