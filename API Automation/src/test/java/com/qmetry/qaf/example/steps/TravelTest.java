package com.qmetry.qaf.example.steps;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.automation.ws.Response;
import com.qmetry.qaf.automation.ws.rest.RestWSTestCase;
import com.sun.jersey.api.client.ClientResponse.Status;

public class TravelTest extends RestWSTestCase{

	@Test
	public void MyTravelRequestTest() throws IOException {

		getWebResource("/get-travel-locations").type("application/json")
		.post(ConfigurationManager.getBundle().getPropertyValue("traveltoken"));

		Response response=getResponse();
		//System.out.println(response);
		Validator.verifyTrue(response.getStatus()==Status.OK, "Response Status is not OK", "Response Status is OK");
		Validator.verifyTrue(response.getMediaType().toString().equals(MediaType.APPLICATION_JSON), "Response Media Type is not JSON", 
				"Response Media Type is JSON");
		
		JSONObject object=new JSONObject(response.getMessageBody());
		JSONObject object1=object.getJSONObject("response").getJSONObject("results");
		JSONArray array=object1.getJSONArray("details");
		
		ArrayList<String> travelDetails=new ArrayList<>();
		for(int i=0; i<array.length();i++) {
			JSONObject obj=array.getJSONObject(i);
			if(obj.get("trvl_travel_location_id").toString().equals("66")) {
				travelDetails.add(obj.getString("trvl_travel_location_id").toString());
				travelDetails.add(obj.getString("title").toString());
				travelDetails.add(obj.getString("type").toString());
				travelDetails.add(obj.getString("status").toString());
				travelDetails.add(obj.getString("created_date").toString());
				travelDetails.add(obj.getString("updated_date").toString());	    		
			}
		}
		ArrayList<String> expectedTravelDetails= getExpectedResponse();
		Validator.verifyTrue(expectedTravelDetails.containsAll(travelDetails), "Expected and Actual JSON response is not equal", "Expected and Actual JSON response is equal");
		Reporter.log("My Travel Request Web Service is Verifiedd...");
	}
	private ArrayList<String> getExpectedResponse() {
		ArrayList<String> expectedTravelDetails=new ArrayList<>();
		String expected = ConfigurationManager.getBundle().getPropertyValue("travelResponse");
		JSONObject expectedObject=new JSONObject(expected);
		expectedTravelDetails.add(expectedObject.getString("trvl_travel_location_id").toString());
		expectedTravelDetails.add(expectedObject.getString("title").toString());
		expectedTravelDetails.add(expectedObject.getString("type").toString());
		expectedTravelDetails.add(expectedObject.getString("status").toString());
		expectedTravelDetails.add(expectedObject.getString("created_date").toString());
		expectedTravelDetails.add(expectedObject.getString("updated_date").toString());
		return expectedTravelDetails;
	}
}



