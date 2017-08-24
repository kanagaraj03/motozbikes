package com.motoz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Column
	String Customername;
	@Id
	String Email;
	@Column
	String Emailagain;
	@Column
	String Upassword;
	@Column
	String Upasswordname;
	@Column
	String status = "true";
	@Column
	String Role = "ROLE_USER";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getCustomername() {
		return Customername;
	}

	public void setCustomername(String customername) {
		Customername = customername;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getEmailagain() {
		return Emailagain;
	}

	public void setEmailagain(String emailagain) {
		Emailagain = emailagain;
	}

	public String getUpassword() {
		return Upassword;
	}

	public void setUpassword(String upassword) {
		Upassword = upassword;
	}

	public String getUpasswordname() {
		return Upasswordname;
	}

	public void setUpasswordname(String upasswordname) {
		Upasswordname = upasswordname;
	}

}
