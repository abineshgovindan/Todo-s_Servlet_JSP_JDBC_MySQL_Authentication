package com.todo_app.model;

import java.io.Serializable;

public class User implements Serializable {
	protected String user_id;
	protected String user_name;
	protected String email_id ;
	protected String encryptedPassword;
	protected String saltVale;
	
	public User() {
		
	}
	
		
	public User(String user_id, String user_name, String email_id,  String saltVale) {
		this.user_name = user_name;
		this.email_id = email_id;
		this.saltVale = saltVale;
	}
	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public String getSaltVale() {
		return saltVale;
	}
	public void setSaltVale(String saltVale) {
		this.saltVale = saltVale;
	}
	
	

}
