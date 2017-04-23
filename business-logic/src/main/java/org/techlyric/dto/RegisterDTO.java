package org.techlyric.dto;

public class RegisterDTO {
	public RegisterDTO(){}
	public RegisterDTO(String email, String phone, String postal){
		email_address = email;
		phone_number = phone;
		postal_code = postal;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	String email_address;
	String phone_number;
	String postal_code;
}
