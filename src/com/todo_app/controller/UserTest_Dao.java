package com.todo_app.controller;

import java.sql.SQLException;

import com.todo_app.dao.UserDao;
import com.todo_app.model.User;



public class UserTest_Dao {
	public static void main(String[] args) throws SQLException {
		UserDao userDao = new UserDao();
		//userDao.insertUser("Abinesh", "Abi1dd@gmail.com", "nsngaosngfnajon", "12635");
		
//		User user = (User)  userDao.selectUser("user1@example.com", "salt_value_1");
//		if(user != null) {
//			String name =  user.getUser_name();
//			System.out.println("UserName -> " + name);
//			
//		}else {
//			System.out.println("user obj is null");
////			
//			
//		}
		for(int i =0 ; i < 10; i++) {
			User user = (User)  userDao.selectUser("user1@example.com", "salt_value_1");
			if(user != null) {
				String name =  user.getUser_name();
				System.out.println("UserName -> " + name);
				
			}else {
				System.out.println("user obj is null");
			
		}
		
//				
//		
//		
//		
		
		}
	}

}
