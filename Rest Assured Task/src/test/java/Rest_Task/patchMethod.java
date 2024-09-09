package Rest_Task;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class patchMethod {

    @Test
    public void updateOrder() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        String orderId = "TTMa_cHCSvIUWZFlth1dK";
        JSONObject requestBody = new JSONObject();
        requestBody.put("customerName", "Jane");

        Response updateCustomerId = given()
    		.header("Authorization", "Bearer " + "f7c990b8cdc3c17a9ccda9bf052a2e552a4aab494adc252ab27b3233bc35a475")
            .header("Content-Type", "application/json")
            .body(requestBody.toString())
            .when()
            .patch("/orders/{orderId}", orderId) 
            .then()
            .statusCode(204) 
            .log().all()
            .extract()
            .response();
        System.out.println("Response: " + updateCustomerId.asString());

    }
}

