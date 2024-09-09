package Rest_Task;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;
import java.util.List;

public class getMethod {
		
	   @BeforeClass
	    public void setup() {
	        RestAssured.baseURI = "https://simple-books-api.glitch.me";
	    }
    @Test
    public void getAllBooks() {
    	Response response=  given().get("/books").then().statusCode(200).extract().response();
		List<String> bookTitles = response.jsonPath().getList("name"); 
		System.out.println("Book Titles: " + bookTitles);
        assertTrue(bookTitles.size() > 0, "The list of book titles should not be empty.");
    }
}
