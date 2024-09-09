package Rest_Task;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertNotNull;
public class generateAccessToken {


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
    }

	    @Test
	    public void submitOrder() {
	        JSONObject requestBody = new JSONObject();
	        requestBody.put("clientName", "motest12333");
	        requestBody.put("clientEmail", "motest12333@example.com");

	        Response response = given()
	                .header("Content-Type", "application/json")  
	                .body(requestBody.toString())                
	                .when()
	                .post("/api-clients/")                       
	                .then()
	                .statusCode(201)                          
	                .extract()
	                .response();                                

	        
	            String token = response.jsonPath().getString("accessToken");

	   
	            System.out.println("Access Token: " + token);

	      
	            assertNotNull(token, "The access token should not be null");
	    }
	}


