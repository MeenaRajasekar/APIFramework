package StepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class StepDefinition extends Utils {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String place_id;
	
	
	TestDataBuild data=new TestDataBuild();
	
	@Given("Add Place Payload with {String} {String} {String} ")
	public void add_place_payload_with(String name, String language, String address)
	{
	
		
		res=given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
	}
	
	
	@When("user calls {string} with {String} http request")
	public void user_calls_with_http_request(String resource, String method)
	{   
		//constructor will be called with value of resource you pass
		APIResources resourceAPI=APIResources.valueOf(resource);
		
		resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		     response=res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
				response=res.when().get(resourceAPI.getResource());
	}
	
	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1)
	{
		assertEquals(response.getStatusCode(),200);
	}
	
	@Then("{String} in response body is {String}")
	public void in_response_body_is(String keyvalue, String expectedvalue)
	{
		
		assertEquals(getJsonPath(response, keyvalue),expectedvalue);
	}
	
	@Then("verify place_id created maps to {String} using {String}")
	public void verify_place_id_created_maps_to (String resource, String expectedname)
	{
		
		place_id=getJsonPath(response, "place_id");
		res=given().spec(requestSpecification()).queryParam("place_id",place_id);
		user_calls_with_http_request(resource,"GET");
		String actualname=getJsonPath(response, "name");
		assertEquals(actualname,expectedname);
		
     }
	
	@Given("DeletePlace Payload")
	public void delete_place_Payload() {
		
		
		res=given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
		
	}
		
	
	
	
	
	
	
	

}
