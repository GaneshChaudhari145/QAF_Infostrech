package com.qmetry.qaf.example.steps;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.automation.ws.Response;
import com.qmetry.qaf.automation.ws.rest.RestWSTestCase;
import com.sun.jersey.api.client.ClientResponse.Status;

public class ApplyLeaveTest extends RestWSTestCase{

	@Test
	@QAFTestStep(description="Check Web Service For Apply Leave API Task")
	public void applyLeaveTest()
	{
		getWebResource("/get-leave-reasons").type("application/json")
		.post(ConfigurationManager.getBundle().getPropertyValue("token"));
		Response response=getResponse();
		//System.out.println(response);
		Validator.verifyTrue(response.getStatus()==Status.OK, "Response Status is not OK", "Response Status is OK");
		Validator.verifyTrue(response.getMediaType().toString().equals(MediaType.APPLICATION_JSON), "Response Media Type is not JSON", 
				"Response Media Type is JSON");

		JSONObject object=new JSONObject(response.getMessageBody());
		JSONArray array=object.getJSONObject("response").getJSONArray("results");
		Validator.verifyTrue(array.length() == 8, "Total No.Leaves are greter than 8",
				"Total No.Leaves are 8");
		List<String> leaveReason=new ArrayList<>(Arrays.asList("Family Function","Sick","Personal Commitment",
				"Out of Town","Birthday","Anniversary","Vacation","Other"));

		List<String>leaveId=new ArrayList<>(Arrays.asList("6","7","8","9","10","11","12","13"));

		for(int i=0;i<array.length();i++) {
			String reason=array.getJSONObject(i).get("reason").toString();
			String leave=array.getJSONObject(i).get("leaveid").toString();

			Validator.verifyTrue(leaveReason.contains(reason),reason+ "::"+"Leave reason is not Valid",
					reason+ "::"+"Leave reason is Valid");
			Validator.verifyTrue(leaveId.contains(leave),leave+ "::"+"Leave id is not Valid",
					leave+ "::"+"Leave id is Valid");
		}
		Reporter.log("Apply Leave Web Service is Verified");
		
		
		//newly added1
		//by gitbash
	}

	
}
