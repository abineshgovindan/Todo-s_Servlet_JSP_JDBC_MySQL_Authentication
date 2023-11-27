package com.todo_app.model;

import java.io.Serializable;

public class Login implements Serializable {
	protected String email_id;
	protected String encryptedPassword;
	protected String saltVale ;
	protected int user_id;
	protected boolean status ;
	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public Login(String email_id, String encryptedPassword, String saltVale, int user_id) {
		super();
		this.email_id = email_id;
		this.encryptedPassword = encryptedPassword;
		this.saltVale = saltVale;
		this.user_id = user_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public Login(){
		
	};
	
	
	public Login(String email_id, String encryptedPassword, String saltVale) {
		this.email_id = email_id;
		this.encryptedPassword = encryptedPassword;
		this.saltVale = saltVale;
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
