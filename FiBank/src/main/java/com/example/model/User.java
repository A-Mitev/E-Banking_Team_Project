package com.example.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	private String id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String password;
	private TypesOfUsers typeOfUser;
	
	public User() {
	}

	public User(String id,String name, String address, String phone, String email, String password, TypesOfUsers typeOfUser) {
		setId(id);
		setName(name);
		setAddress(address);
		setPhone(phone);
		setEmail(email);
		setPassword(password);
		setTypeOfUser(typeOfUser);
	}

	

	@NotNull(message = "The id is compulsory!")
	@NotBlank(message = "The id is compulsory!")
	@Size(min = 9, max = 10, message = "The id should be 9 signs for business and 10 signs for citizens!")
	@Pattern(regexp = "[0-9]*", message = "The name has invalid characters!") 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotNull(message = "The name is compulsory!")
	@NotBlank(message = "The name is compulsory!")
	@Size(min = 2, max = 45, message = "The address should be between 2 and 45 signs!")
	@Pattern(regexp = "[a-zA-Z\\c]*", message = "The name has invalid characters!") // whatespace?
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull(message = "The address is compulsory!")
	@NotBlank(message = "The address is compulsory!")
	@Size(min = 2, max = 45, message = "The address should be between 2 and 45 signs!")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@NotNull(message = "The phone is compulsory!")
	@NotBlank(message = "The phone is compulsory!")
	@Size(min = 10, max = 10, message = "The phone should be have 10 digits!")
	@Pattern(regexp = "[0-9]*", message = "The phone has invalid characters!")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@NotNull(message = "Email Address is compulsory!")
	@NotBlank(message = "Email Address is compulsory!")
	@Email(message = "Email Address is not a valid format!")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

	@NotNull(message = "The password is compulsory!")
	@NotBlank(message = "The password is compulsory!")
	@Size(min = 6, message = "The password should be at least 6 signs!")
	@Pattern(regexp = "[^\\c]*", message = "The password has invalid characters!")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TypesOfUsers getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(TypesOfUsers typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

}
