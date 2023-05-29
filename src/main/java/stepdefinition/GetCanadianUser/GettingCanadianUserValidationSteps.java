package stepdefinition.GetCanadianUser;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import common.JsonUtils;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.plugin.event.Result;

public class GettingCanadianUserValidationSteps {
	String url;
	String method;
	HttpResponse<String> response;
	
	@Given("User has valid URL and Method")
	public void user_has_valid_url_and_method() {
	   url = "https://randomuser.me/api?nat=CA"; 
	   method = "GET";
	   
	}

	@When("User sends a request")
	public void user_sends_a_request() {
		//Design button theo kiểu builder:
	    HttpRequest request = HttpRequest.newBuilder()
	    		.GET()
	    		.uri(URI.create(url))
	    		.build();
	   HttpClient httpClient = HttpClient.newBuilder().build();
	  try {
	 response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Response is null");	
	}  	   
	    
	}

	@Then("Response is returned correctly")
	public void response_is_returned_correctly() {
	    assertEquals(response.statusCode(), 200);
	    String responseBody = response.body();
	    
	 JSONObject jObject =new JSONObject(responseBody);
	 JSONArray results = jObject.getJSONArray("results");
	 int count = 0;
	 for (Object result:results) {
//		 JSONObject resultObj = (JSONObject)result;
//		 Object actualLocation = resultObj.get("location");
		 Object actualLocation = JsonUtils.getValurByJsonKey(result, "location");
		 
//		 JSONObject actualCountryObj = (JSONObject)actualLocation;
//		 String actualCountry = actualCountryObj.get("country").toString();
		 
		 String actualCountry = JsonUtils.getValurByJsonKey(actualLocation, "country").toString();
		 
		 
		 if (actualCountry.equalsIgnoreCase("Canada")) {
			 count ++;			 
		 }
	 }
	 assertEquals(count,results.length());
	    
	}

}
