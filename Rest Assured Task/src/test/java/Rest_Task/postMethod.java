package Rest_Task;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class postMethod {


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
    }

	   @Test
	    public void submitOrder() {
	        JSONObject requestBody = new JSONObject();
	        requestBody.put("bookId", 1);
	        requestBody.put("customerName", "John Doe");
	        
	        
	        Response orderResponse = given()
	        		.header("Authorization", "Bearer " + "f7c990b8cdc3c17a9ccda9bf052a2e552a4aab494adc252ab27b3233bc35a475")
	                .header("Content-Type", "application/json") 
	                .body(requestBody.toString())             
	                .when()
	                .post("/orders")                            
	                .then()
	                .statusCode(201)                            
	                .body("orderId", notNullValue())            
	                .log().all()                                 
	                .extract()
	                .response(); 
	        String orderId = orderResponse.jsonPath().getString("orderId");
	        System.out.println("Order ID: " + orderId);
	        
	        }

	    }


