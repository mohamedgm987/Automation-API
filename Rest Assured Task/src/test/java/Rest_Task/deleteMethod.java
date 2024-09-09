package Rest_Task;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class deleteMethod {

    @Test
    public void cancelOrder() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        String orderId = "TTMa_cHCSvIUWZFlth1dK";
        Response response = given()
        	.header("Authorization", "Bearer " + "f7c990b8cdc3c17a9ccda9bf052a2e552a4aab494adc252ab27b3233bc35a475")
            .header("Content-Type", "application/json")
            .when()
            .delete("/orders/{orderId}", orderId) 
            .then()
            .statusCode(204) 
            .log().all().extract().response();
        
        System.out.println("Response: " + response.asString());

    }
}
