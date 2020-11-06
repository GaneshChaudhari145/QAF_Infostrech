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

public class VisaRequestTest extends RestWSTestCase{

	@Test
	@QAFTestStep(description="Check Web Service For Visa Request API Task")
	public void visaRequestTest()
	{
		getWebResource("/get-Supervisors-Name").type("application/json")
		.post(ConfigurationManager.getBundle().getPropertyValue("token"));
		Response response=getResponse();

		Validator.verifyTrue(response.getStatus()==Status.OK, "Response Status is not OK", 
				"Response Status is OK");
		Validator.verifyTrue(response.getMediaType().toString().equals(MediaType.APPLICATION_JSON), "Response Media Type is not JSON", 
				"Response Media Type is JSON");
		JSONObject object=new JSONObject(response.getMessageBody());
		JSONArray array=object.getJSONObject("response").getJSONArray("results");
		Validator.verifyTrue(array.length() == 41, "Total Visa Requests are less than 40",
				"Total Visa Requests are 41");

		
		List<String> ename=new ArrayList<>(Arrays.asList("11 111","111 111","111111 111 DummyL","111111 DummyL","aa b c","aaa bb ccc","aaa rrrr","Aagam Shah",
				"Aayushi Jain","abhi gupta","Abhilasha Deolikar","Aditi Bond","Aditi Mishra","amit gupta","anika baronia","anju gupta",
				"Aparajito Sengupta","Ashish Biradar","Ashok Karania","Ashwani Kumar","BAT BAT","Brijesh Bhalodia","Check check","Gaurav Parekh","info info",
				"Keshav K Kumar","Mehul Kagrathra","mihir_manager shah","Only Pm","q Raahu                   ul Sen          garrr","qa1 qa1",
				"qa2 qa2","Rohini Baban Kadam","roni gupta","Security Testing","Shama Shama","Sona Chaurasia","Test Delivery","Test Manager",
				"TT11 TT11","Tushit b Shah","Yatendra Yatendra Vijay"));
		List<String>emp_number=new ArrayList<>(Arrays.asList("1184","1183","1185","1188","1151","1150","836","774","1056","1303","682","793",
				"1031","568","1311","1308","571","940","500","1359","1329","1365","1328","559","1330","989","519","1158","685","1106",
				"1160","1161","1322","1312","1143","1324","481","1356","1354","1332","113","1182"));
		for(int i=0;i<array.length();i++) {
			String name=array.getJSONObject(i).get("ename").toString();
			String number=array.getJSONObject(i).get("emp_number").toString();
			
			Validator.verifyTrue(ename.contains(name),name+ "::"+"ename is not Valid",
					name+ "::"+"ename is Valid");
			Validator.verifyTrue(emp_number.contains(number),number+ "::"+"emp_number is not Valid",
					number+ "::"+"emp_number is Valid");

		}
		Reporter.log("Visa Request Web Service is Verified");
	}
}
