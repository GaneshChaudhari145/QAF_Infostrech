package com.org.beans;

import com.qmetry.qaf.automation.data.BaseFormDataBean;
import com.qmetry.qaf.automation.ui.annotations.UiElement;
import com.qmetry.qaf.automation.ui.annotations.UiElement.Type;
import com.qmetry.qaf.automation.util.Randomizer;
import com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes;

public class RegisterDataBean extends BaseFormDataBean{
	
	@Randomizer(length=10,type=RandomizerTypes.LETTERS_ONLY)
	@UiElement(fieldLoc="Register.fname.txt")
	private String firstName;
	
	@Randomizer(length=10,type=RandomizerTypes.LETTERS_ONLY)
	@UiElement(fieldLoc="Register.lname.txt")
	private String lastName;
	
	@Randomizer(length=10,type=RandomizerTypes.DIGITS_ONLY)
	@UiElement(fieldLoc="Register.phone.txt")
	private String phone;
	
	@Randomizer(length=10,type=RandomizerTypes.MIXED,suffix="@gmail.com")
	@UiElement(fieldLoc="Register.email.txt")
	private String email;
	
	@Randomizer(length=10,type=RandomizerTypes.LETTERS_ONLY)
	@UiElement(fieldLoc="Register.address.txt")
	private String address;

	@Randomizer(length=6,type=RandomizerTypes.LETTERS_ONLY)
	@UiElement(fieldLoc="Register.city.txt")
	private String city;
	
	@Randomizer(length=8,type=RandomizerTypes.LETTERS_ONLY)
	@UiElement(fieldLoc="Register.state.txt")
	private String state;
	
	@Randomizer(length=6,type=RandomizerTypes.DIGITS_ONLY)
	@UiElement(fieldLoc="Register.pincode.txt")
	private String pincode;
	
	@Randomizer(length=10,type=RandomizerTypes.MIXED)
	@UiElement(fieldLoc="Register.country.dd",fieldType=Type.selectbox)
	private String country;
	
	@Randomizer(length=10,type=RandomizerTypes.LETTERS_ONLY)
	@UiElement(fieldLoc="Register.username.txt")
	private String username;
	
	@Randomizer(length=10,type=RandomizerTypes.LETTERS_ONLY)
	@UiElement(fieldLoc="Register.password.txt")
	private String password;
	
}
