package com.todo_app.dao;

import java.sql.SQLException;

import com.todo_app.model.Login;
import com.todo_app.model.User;



public class UserTestDao {
	public static void main(String[] args) throws SQLException {
		UserDao userDao = new UserDao();
		
		Login userd = userDao.getEmailAndSalt("Abi@gmail");
		if(userd != null) {
			System.out.println(userd.getEncryptedPassword());
			
		}else {
			System.out.println("Error.....");
		}
		
		//userDao.insertUser("Abinesh", "Abi1@gmail.com", "nsngaosngfnajon", "12635");
//		
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
		
//				
//		
//		
//		
		
	}

}
