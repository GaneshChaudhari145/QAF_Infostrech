package com.qmetry.qaf.example.steps;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.automation.ws.Response;
import com.qmetry.qaf.automation.ws.rest.RestWSTestCase;
import com.sun.jersey.api.client.ClientResponse.Status;

public class LeaveManagerTest extends RestWSTestCase{

	
	@Test
	@QAFTestStep(description="Check Web Service For Leave Manager API Task")
	public void leaveManagerTest() throws ParseException, IOException {

		Map<String, String> data = new HashMap<String, String>();
		data.put("token",ConfigurationManager.getBundle().getPropertyValue("Leavetoken"));
		data.put("start_date",ConfigurationManager.getBundle().getPropertyValue("start_date"));
		data.put("end_date",ConfigurationManager.getBundle().getPropertyValue("end_date"));

		getWebResource("/get-location-wise-holiday-list").header("Content-Type", "application/json").post(new Gson().toJson(data));

		Response response=getResponse();
		
		Validator.verifyTrue(response.getStatus()==Status.OK, "Response Status is not OK", "Response Status is OK");
		Validator.verifyTrue(response.getMediaType().toString().equals(MediaType.APPLICATION_JSON), "Response Media Type is not JSON","Response Media Type is JSON");
		
		Map<String, String> expected= new HashMap<>();
		expected.put("holiday_id", "299");
		expected.put("description", "April Fool");
		expected.put("date", "01-Apr-2019");
		expected.put("recurring", "0");
		expected.put("day", "Monday");
		expected.put("location", "Pune");
		
		JSONObject object=new JSONObject(response.getMessageBody());
		JSONObject details=object.getJSONObject("response").getJSONObject("results").getJSONObject("details");
		JSONArray punecities = (JSONArray)details.getJSONArray("Pune");
		
		JSONObject jsonresp = punecities.getJSONObject(0); 
		int holiday_id = jsonresp.getInt("holiday_id");
		String holiday=Integer.toString(holiday_id);
		String description = jsonresp.getString("description");
		String date=jsonresp.getString("date");
		int recurring = jsonresp.getInt("recurring");
		String recurring_resp=Integer.toString(recurring);
		String location = jsonresp.getString("location");
		String day = jsonresp.getString("day");
		
		Validator.verifyTrue(expected.containsValue(holiday),holiday+ "::"+ "Holiday id not matched with response",holiday+ "::"+"Holiday id matched with response");
		Validator.verifyTrue(expected.containsValue(description),description+ "::"+ "description is not matched with response",description+ "::"+"description is matched with response");
		Validator.verifyTrue(expected.containsValue(date),date+ "::"+ "date is not matched with response",date+ "::"+"date is matched with response");
		Validator.verifyTrue(expected.containsValue(recurring_resp),recurring_resp+ "::"+ "recurring is not matched with response",recurring_resp+ "::"+"recurring is matched with response");
		Validator.verifyTrue(expected.containsValue(location),location+ "::"+ "location is not matched with response",location+ "::"+"location is matched with response");
		Validator.verifyTrue(expected.containsValue(day),day+ "::"+ "day is not matched with response",day+ "::"+"day is matched with response");
		
		Map<String, String> anotherexpected= new HashMap<>();
		anotherexpected.put("holiday_id", "296");
		anotherexpected.put("description", "April Fool");
		anotherexpected.put("date", "01-Apr-2019");
		anotherexpected.put("recurring", "0");
		anotherexpected.put("day", "Monday");
		anotherexpected.put("location", "Ahmedabad");
		
		JSONArray ahmedabadcities = (JSONArray)details.getJSONArray("Ahmedabad");
		JSONObject jsonresp1 = ahmedabadcities.getJSONObject(0);
		int anotherholiday_id = jsonresp1.getInt("holiday_id");
		String anotherholiday=Integer.toString(anotherholiday_id);
		String anotherdescription = jsonresp1.getString("description");
		String anotherdate=jsonresp1.getString("date");
		int anotherrecurring = jsonresp1.getInt("recurring");
		String anotherrecurring_resp=Integer.toString(anotherrecurring);
		String anotherlocation = jsonresp1.getString("location");
		String anotherday = jsonresp1.getString("day");
		
		Validator.verifyTrue(anotherexpected.containsValue(anotherholiday),anotherholiday+ "::"+ "Holiday id not matched with response",anotherholiday+ "::"+"Holiday id matched with response");
		Validator.verifyTrue(anotherexpected.containsValue(anotherdescription),anotherdescription+ "::"+ "description is not matched with response",anotherdescription+ "::"+"description is matched with response");
		Validator.verifyTrue(anotherexpected.containsValue(anotherdate),anotherdate+ "::"+ "description is not matched with response",anotherdate+ "::"+"description is matched with response");
		Validator.verifyTrue(anotherexpected.containsValue(anotherrecurring_resp),anotherrecurring_resp+ "::"+ "description is not matched with response",anotherrecurring_resp+ "::"+"description is matched with response");
		Validator.verifyTrue(anotherexpected.containsValue(anotherlocation),anotherlocation+ "::"+ "location is not matched with response",anotherlocation+ "::"+"location is matched with response");
		Validator.verifyTrue(anotherexpected.containsValue(anotherday),anotherday+ "::"+ "day is not matched with response",anotherday+ "::"+"day is matched with response");
		
		Reporter.log("Leave Manager Web Service is Verified");
	}
}
