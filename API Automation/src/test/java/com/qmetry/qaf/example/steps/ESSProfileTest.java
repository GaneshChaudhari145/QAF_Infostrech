package com.qmetry.qaf.example.steps;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.automation.ws.Response;
import com.qmetry.qaf.automation.ws.rest.RestWSTestCase;
import com.sun.jersey.api.client.ClientResponse.Status;

public class ESSProfileTest extends RestWSTestCase{

	@Test
	public void eSSProfileTest() {

		Map<String, String> data = new HashMap<String, String>();
		data.put("token",ConfigurationManager.getBundle().getPropertyValue("ESSProfiletoken"));
		data.put("emp_number",ConfigurationManager.getBundle().getPropertyValue("emp_number"));

		getWebResource("/get-contact-details").header("Content-Type", "application/json").post(new Gson().toJson(data));

		Response response=getResponse();

		Validator.verifyTrue(response.getStatus()==Status.OK, "Response Status is not OK", "Response Status is OK");
		Validator.verifyTrue(response.getMediaType().toString().equals(MediaType.APPLICATION_JSON), "Response Media Type is not JSON","Response Media Type is JSON");

		JSONObject object=new JSONObject(response.getMessageBody());
		JSONObject object1=object.getJSONObject("response").getJSONObject("results").getJSONObject("user_type");
		

		int isAdmin = object1.getInt("isAdmin");
		String Admin=Integer.toString(isAdmin);
		int edit_access = object1.getInt("edit_access");
		String access=Integer.toString(edit_access);
				
		Validator.verifyTrue(Admin.equals("1"),Admin+ "::"+ "isAdmin not matched with response",Admin+ "::"+"isAdmin matched with response");
		Validator.verifyTrue(access.equals("0"),access+ "::"+ "edit_access not matched with response",access+ "::"+"edit_access matched with response");
		Reporter.log("user_type is verified...");
		
		JSONObject object2=object.getJSONObject("response").getJSONObject("results").getJSONObject("details");
		int emp_number = object2.getInt("emp_number");
		String enumber=Integer.toString(emp_number);
		String emp_street1 = object2.getString("emp_street1");
		String city_code = object2.getString("city_code");
		String coun_code = object2.getString("coun_code");
		String provin_code = object2.getString("provin_code");
		int emp_zipcode = object2.getInt("emp_zipcode");
		String zipcode=Integer.toString(emp_zipcode);
		int emp_mobile = object2.getInt("emp_mobile");
		String mobile=Integer.toString(emp_mobile);
		String emp_oth_email = object2.getString("emp_oth_email");
		String bank_name = object2.getString("bank_name");
		String country = object2.getString("country");
		
		Validator.verifyTrue(enumber.equals("989"),enumber+ "::"+ "emp_number not matched with response",enumber+ "::"+"emp_number matched with response");
		Validator.verifyTrue(emp_street1.equals("TEST"),emp_street1+ "::"+ "emp_street1 not matched with response",emp_street1+ "::"+"emp_street1 matched with response");
		Validator.verifyTrue(city_code.equals("pune"),city_code+ "::"+ "city_code not matched with response",city_code+ "::"+"city_code matched with response");
		Validator.verifyTrue(coun_code.equals("IN"),coun_code+ "::"+ "coun_code not matched with response",coun_code+ "::"+"coun_code matched with response");
		Validator.verifyTrue(provin_code.equals("maharashtra"),provin_code+ "::"+ "provin_code not matched with response",provin_code+ "::"+"provin_code matched with response");
		Validator.verifyTrue(zipcode.equals("123456"),zipcode+ "::"+ "emp_zipcode not matched with response",zipcode+ "::"+"emp_zipcode matched with response");
		Validator.verifyTrue(mobile.equals("123456"),mobile+ "::"+ "emp_mobile not matched with response",mobile+ "::"+"emp_mobile matched with response");
		Validator.verifyTrue(emp_oth_email.equals("tedds2t@test.com"),emp_oth_email+ "::"+ "emp_oth_email not matched with response",emp_oth_email+ "::"+"emp_oth_email matched with response");
		Validator.verifyTrue(bank_name.equals("ICICI"),bank_name+ "::"+ "bank_name not matched with response",bank_name+ "::"+"bank_name matched with response");
		Validator.verifyTrue(country.equals("India"),country+ "::"+ "country not matched with response",country+ "::"+"country matched with response");
		Reporter.log("details is verified...");
		
		
		JSONObject object3=object.getJSONObject("response").getJSONObject("results").getJSONObject("permission");
		int edit_contact_details = object3.getInt("edit_contact_details");
		String edit_contact=Integer.toString(edit_contact_details);
		int get_contact_details = object3.getInt("get_contact_details");
		String get_contact=Integer.toString(get_contact_details);
		int declare_relationship = object3.getInt("declare_relationship");
		String relationship=Integer.toString(declare_relationship);
		
		Validator.verifyTrue(edit_contact.equals("1"),edit_contact+ "::"+ "edit_contact_details not matched with response",edit_contact+ "::"+"edit_contact_details matched with response");
		Validator.verifyTrue(get_contact.equals("1"),get_contact+ "::"+ "get_contact_details not matched with response",get_contact+ "::"+"get_contact_details matched with response");
		Validator.verifyTrue(relationship.equals("1"),relationship+ "::"+ "declare_relationship not matched with response",relationship+ "::"+"declare_relationship matched with response");
		Reporter.log("permission is verified...");
		
		Reporter.log("ESS MyProfile Web Service is Verifiedd...");
	}

}
