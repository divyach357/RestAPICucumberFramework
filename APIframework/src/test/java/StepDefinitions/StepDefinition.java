package StepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.BuildTestBooking;
import resources.TestBuild;
import resources.Utils;

public class StepDefinition extends Utils{
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	TestBuild data = new TestBuild();
	BuildTestBooking bookingdata = new BuildTestBooking();
	@Given("Add {string} payload")
	public void add_place_payload(String string) throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
		if(string.equals("Place")) {
			res=given().spec(requestBuilder()).body(data.addPlacePayLoad());
		} else if(string.equals("Places")) {
			res=given().spec(requestBuilder()).body(data.addPlaceFailurePayload());
		}else if(string.equals("Booking")) {
			res=given().spec(bookingRequestBuilder().body("{\n" +
					"  \"firstname\" : \"Jim\",\n" +
					"  \"lastname\" : \"Brown\",\n" +
					"  \"totalprice\" : 111,\n" +
					"  \"depositpaid\" : true,\n" +
					"  \"bookingdates\" : {\n" +
					"    \"checkin\" : \"2018-01-01\",\n" +
					"    \"checkout\" : \"2019-01-01\"\n" +
					"  },\n" +
					"  \"additionalneeds\" : \"Breakfast\"\n" +
					"}"));
			System.out.println(res);
		}		
		else {
			res=given().spec(wrongRequestBuilder()).body(data.addPlaceFailurePayload());
		}
	}
	
	@Given("Retrieve {string} payload")
	public void retrieve_payload(String string) throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
		
		 if(string.equals("Booking")) {
			res=given().spec(bookingRequestBuilder());
			System.out.println(res);

		}
	}
	@When("User calls {string} with GET request")
	public void user_calls_with_get_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		response =res.when().get("/booking").
				 then().spec(resspec).extract().response();	
		System.out.println(response);
	}



	@When("User calls {string} with POST request")
	public void user_calls_with_post_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 resspec =new ResponseSpecBuilder().expectStatusCode(200).build();
		 
		
			 response =res.when().post("/booking").
						then().spec(resspec).extract().response();
			}
	
	
	@Then("the API call is successfull with status code {int}")
	public void the_api_call_is_successfull_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
		assertEquals(200,response.getStatusCode());
		
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
		String resString=response.asString();
		JsonPath js = new JsonPath(resString); 
		System.out.printf("Expected %s and got %s", expectedValue, resString);
		//assertEquals(js.get(keyValue).toString(),expectedValue);
	}




}
