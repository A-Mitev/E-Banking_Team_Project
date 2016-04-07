package com.example.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	
	@NotNull(message = "The id is compulsory!")
	@NotBlank(message = "The id is compulsory!")
	@Size(min = 9, max = 10, message = "The id should be 9 signs for business and 10 signs for citizens!")
<<<<<<< HEAD
	@Pattern(regexp = "[0-9]+", message = "The EGN/Bulstat has invalid characters!") 
=======
	@Pattern(regexp = "[0-9]*", message = "The name has invalid characters!") 
>>>>>>> 0bae3a29f37cd86c417b0a4942a97820fe9d52c6
	private String id;
	
	@NotNull(message = "The name is compulsory!")
	@NotBlank(message = "The name is compulsory!")
<<<<<<< HEAD
	@Size(min = 2, max = 45, message = "The name should be between 2 and 45 signs!")
	@Pattern(regexp = "[a-zA-Z]+", message = "The name has invalid characters!")
=======
	@Size(min = 2, max = 45, message = "The address should be between 2 and 45 signs!")
	@Pattern(regexp = "[a-zA-Z\\c]*", message = "The name has invalid characters!")
>>>>>>> 0bae3a29f37cd86c417b0a4942a97820fe9d52c6
	private String name;
	
	@NotNull(message = "The address is compulsory!")
	@NotBlank(message = "The address is compulsory!")
	@Size(min = 2, max = 45, message = "The address should be between 2 and 45 signs!")
	private String address;
	
	@NotNull(message = "The phone is compulsory!")
	@NotBlank(message = "The phone is compulsory!")
	@Size(min = 10, max = 10, message = "The phone should be have 10 digits!")
	@Pattern(regexp = "[0-9]*", message = "The phone has invalid characters!")
	private String phone;
	
	@NotNull(message = "Email Address is compulsory!")
	@NotBlank(message = "Email Address is compulsory!")
	@Email(message = "Email Address is not a valid format!")
	private String email;
	
	@NotNull(message = "The password is compulsory!")
	@NotBlank(message = "The password is compulsory!")
<<<<<<< HEAD
	//@Pattern(regexp = "[^\\c]*", message = "The password has invalid characters!")
=======
	@Pattern(regexp = "[^\\c]*", message = "The password has invalid characters!")
>>>>>>> 0bae3a29f37cd86c417b0a4942a97820fe9d52c6
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


	public static String hashPasswordWithMD5(String password) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(password.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
