package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {

  @Test
  public void testPut() {
				
		JSONObject request = new JSONObject();
		
		request.put("name", "Rahul");
		request.put("job", "Engineer");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		 header("Content-Type", "application/json").
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(request.toJSONString()).
		when().
		 post("/users/2").
		then().
		 statusCode(201)
		 .log().all();
		 
	}
  
  @Test
  public void testPatch() {
				
		JSONObject request = new JSONObject();
		
		request.put("name", "Rahul");
		request.put("job", "Engineer");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().
		 header("Content-Type", "application/json").
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(request.toJSONString()).
		when().
		 patch("/api/users/2").
		then().
		 statusCode(200)
		 .log().all();
		 
	}
  
  @Test
  public void testDelete() {
	  
	  baseURI = "https://reqres.in";
	  
	  when().
		 delete("/api/users/2").
		then().
		 statusCode(204)
		 .log().all();
  }
}

