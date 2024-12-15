package com.rest.restassurred;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthExample {
	
	@Test
	public void basicNPAuth() {
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://httpbin.org");
		reqspec.basePath("/basic-auth/sandhya/sandy");
		
		Response res =  reqspec.auth().basic("sandhya", "sandy").get();
		System.out.println(res.getStatusCode());
	}
	
	@Test
	public void basicPAuth() {
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://httpbin.org");
		reqspec.basePath("/basic-auth/sandhya/sandy");
		
		Response res =  reqspec.auth().preemptive().basic("sandhya", "sandy").get();
		System.out.println(res.getStatusCode());
	}
	
	
	@Test
	public void digestPAuth() {
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://httpbin.org");
		reqspec.basePath("/basic-auth/sandhya/sandy");
		
		Response res =  reqspec.auth().preemptive().basic("sandhya", "sandy").get();
		System.out.println(res.getStatusCode());
	}
	
	@Test
	public void digestPAuth1() {
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://httpbin.org");
		reqspec.basePath("/digest-auth/undefined/sandhya/sandy");
		
		Response res =  reqspec.auth().digest("sandhya", "sandy").get();
		System.out.println(res.getStatusCode());
	}
	
	@Test
	public void bearerToken() {
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://gorest.co.in");
		reqspec.basePath("/public/v2/users");
		
		JSONObject jsobObj = new JSONObject();
		jsobObj.put("name", "abcdef");
		jsobObj.put("email", "abcdef@gmail.com");
		jsobObj.put("gender", "female");
		jsobObj.put("status", "active");
		
		String token = "Bearer 3e88417938f515a818351c0cbf80875fabffcf70eed14c53671dfe9271cadc97";
		reqspec
			.headers("Authorization", token)
			.contentType(ContentType.JSON)
			.body(jsobObj.toString());
		
		Response res =  reqspec.post();
		System.out.println(res.getStatusCode());
		System.out.println(res.asPrettyString());
		
	}

}
