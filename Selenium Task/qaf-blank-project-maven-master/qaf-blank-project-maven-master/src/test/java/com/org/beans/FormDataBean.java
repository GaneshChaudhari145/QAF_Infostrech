package com.org.beans;



import com.qmetry.qaf.automation.data.BaseDataBean;
import com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes;
import com.qmetry.qaf.automation.util.Randomizer;



public class FormDataBean extends BaseDataBean{
	
	@Randomizer(length=10,type=RandomizerTypes.LETTERS_ONLY)
	private String firstName;
	
	@Randomizer(length=10,type=RandomizerTypes.LETTERS_ONLY)
	private String lastName;
	
	@Randomizer(length=10,type=RandomizerTypes.DIGITS_ONLY)
	private String phone;
	
	@Randomizer(length=10,type=RandomizerTypes.MIXED,suffix="@gmail.com")
	private String email;
	
	@Randomizer(length=10,type=RandomizerTypes.LETTERS_ONLY)
	private String address;
	
	@Randomizer(length=6,type=RandomizerTypes.LETTERS_ONLY)
	private String city;
	
	@Randomizer(length=8,type=RandomizerTypes.LETTERS_ONLY)
	private String state;
	
	@Randomizer(length=6,type=RandomizerTypes.DIGITS_ONLY)
	private String pincode;
	
	@Randomizer(length=10,type=RandomizerTypes.MIXED)
	private String country;
	
	@Randomizer(length=10,type=RandomizerTypes.LETTERS_ONLY)
	private String username;
	
	@Randomizer(length=10,type=RandomizerTypes.LETTERS_ONLY)
	private String password;
	
	@Randomizer(length=10,type=RandomizerTypes.LETTERS_ONLY)
	private String confirmpassword;
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getPinCode() {
		return pincode;
	}
	public String getCountry() {
		return country;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getConfirmPassword() {
		return confirmpassword;
	}
}
