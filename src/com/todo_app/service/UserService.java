package com.todo_app.service;

import java.sql.SQLException;

import com.todo_app.dao.UserDao;
import com.todo_app.model.Login;
import com.todo_app.model.User;
import com.todo_app.utils.PasswordHashing;
import com.todo_app.utils.UserStatus;

public class UserService {
	
	private UserDao userDao = new UserDao();
	private static Login  userData = new Login() ;
	
	public UserStatus registerServices(String name, String email, String password) throws SQLException{
		if(name.length() < 2 && password.length() < 2) {
			
			return UserStatus.ENTER_NAME_PASSWORD;
		}
		String saltValue = PasswordHashing.getSaltvalue(30);
		String hashedPassword = PasswordHashing.generateSecurePassword(password, saltValue);
		
		System.out.println("registerServices ->");
		
		UserStatus status = userDao.insertUser(name, email, hashedPassword, saltValue);
		return status;
		
		
	

	}

	public UserStatus loginServices(String email, String password) throws SQLException {
	
		Login user_data = userDao.getEmailAndSalt(email);
		if(user_data == null) {
			System.out.println("user_data is null");
			return UserStatus.NOT_FOUND;
		}
		
		boolean isValid = PasswordHashing.verifyUserPassword(password, user_data.getEncryptedPassword(), user_data.getSaltVale());
		 if(isValid) {
			 userData.setUser_id(user_data.getUser_id());
			 userData.setSaltVale(user_data.getSaltVale());
			 
			 
			 
			 return UserStatus.OK;
			 
			 
		 }
		return UserStatus.WORNG_PASSWORD;
		
		
		
	}
	public Login getUserData() {
		
		if(userData == null) {
			return null;
		}
		return userData;
		
	}
	
	

}
