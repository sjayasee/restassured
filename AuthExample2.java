package com.rest.restassurred;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthExample2 {
	
	public String accessToken;
	
	@Test
	public void getAccessToken() {
		String client_id = "AdUV_TJPNKY_zL529RGDzdHaCVhEglMhQdwiqxbfmEFOF4u76xiWXe0uwqoUqQZJr73452oFTabFCKV-";
		String secret_id = "ELQ2OV1nRbNmvE5g-PseCVby32ljSh1p6IbwrJYhQfQ-FBk7Ajz-VoDLbsQhCQkDlRITVfIgc9UJuWxd";
		
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://api-m.sandbox.paypal.com");
		reqspec.basePath("v1/oauth2/token");

		Response res =  reqspec.auth().preemptive().basic(client_id, secret_id).param("grant_type", "client_credentials").post();
		
		accessToken = res.getBody().path("access_token");
		System.out.print(accessToken);
		System.out.println(res.getStatusCode());
		System.out.println(res.asPrettyString());
	}
	
	@Test(dependsOnMethods = "getAccessToken")
	public void listInvoice() {
   	 
        	Response response=RestAssured.given()
                                	.auth()
                                	.oauth2(accessToken)
                                    	.queryParam("page","3")
                                    	.queryParam("page_size", "4")
                                    	.queryParam("total_count_required", "true")
                                	.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
       	 
        	System.out.println(response.asPrettyString());
       	 
   	 
	}
	
	@Test
	public void getlistInvoice() {
		
		//https://api-m.sandbox.paypal.com/v1/invoicing/invoices?page=3&page_size=4&total_count_required=true\
		
		String client_id = "AdUV_TJPNKY_zL529RGDzdHaCVhEglMhQdwiqxbfmEFOF4u76xiWXe0uwqoUqQZJr73452oFTabFCKV-";
		String secret_id = "ELQ2OV1nRbNmvE5g-PseCVby32ljSh1p6IbwrJYhQfQ-FBk7Ajz-VoDLbsQhCQkDlRITVfIgc9UJuWxd";
		
		RequestSpecification reqspec =  RestAssured.given();
		reqspec.baseUri("https://api-m.sandbox.paypal.com");
		reqspec.basePath("v1/invoicing/invoices?page=3&page_size=4&total_count_required=true");

		Response res =  reqspec.auth().preemptive().basic(client_id, secret_id).param("grant_type", "client_credentials").post();
		
		accessToken = res.getBody().path("access_token");
		System.out.print(accessToken);
		System.out.println(res.getStatusCode());
		System.out.println(res.asPrettyString());
	}

	
	
	
	
	
	
	
	
	
	
//	
//	@Test
//	public void basicPAuth() {
//		RequestSpecification reqspec =  RestAssured.given();
//		reqspec.baseUri("https://httpbin.org");
//		reqspec.basePath("/basic-auth/sandhya/sandy");
//		
//		Response res =  reqspec.auth().preemptive().basic("sandhya", "sandy").get();
//		System.out.println(res.getStatusCode());
//	}
//	
//	
//	@Test
//	public void digestPAuth() {
//		RequestSpecification reqspec =  RestAssured.given();
//		reqspec.baseUri("https://httpbin.org");
//		reqspec.basePath("/basic-auth/sandhya/sandy");
//		
//		Response res =  reqspec.auth().preemptive().basic("sandhya", "sandy").get();
//		System.out.println(res.getStatusCode());
//	}
//	
//	@Test
//	public void digestPAuth1() {
//		RequestSpecification reqspec =  RestAssured.given();
//		reqspec.baseUri("https://httpbin.org");
//		reqspec.basePath("/digest-auth/undefined/sandhya/sandy");
//		
//		Response res =  reqspec.auth().digest("sandhya", "sandy").get();
//		System.out.println(res.getStatusCode());
//	}
//	
//	@Test
//	public void bearerToken() {
//		RequestSpecification reqspec =  RestAssured.given();
//		reqspec.baseUri("https://gorest.co.in");
//		reqspec.basePath("/public/v2/users");
//		
//		JSONObject jsobObj = new JSONObject();
//		jsobObj.put("name", "abcdef");
//		jsobObj.put("email", "abcdef@gmail.com");
//		jsobObj.put("gender", "female");
//		jsobObj.put("status", "active");
//		
//		String token = "Bearer 3e88417938f515a818351c0cbf80875fabffcf70eed14c53671dfe9271cadc97";
//		reqspec
//			.headers("Authorization", token)
//			.contentType(ContentType.JSON)
//			.body(jsobObj.toString());
//		
//		Response res =  reqspec.post();
//		System.out.println(res.getStatusCode());
//		System.out.println(res.asPrettyString());
//		
//	}

}
