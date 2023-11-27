package com.todo_app.dao;

import java.sql.*;


import com.todo_app.model.Login;
import com.todo_app.model.User;
import com.todo_app.utils.UserStatus;

public class UserDao  extends DBConnection{
	
   
	public UserDao() {}
//	private static final  String url = "jdbc:mysql://localhost:3306/todo_app?useSSL=false";
//	private static final  String uName = "root";
//    private static final  String password = "Abinesh#7415";
//    private static final String driver = "com.mysql.cj.jdbc.Driver";
	
//  protected  Connection getConnection() {
//	  Connection connection = null;
//	
//  try {
//  	  Class.forName(driver);
//        
//        connection = DriverManager.getConnection(url,uName, password);
//        
//    }catch (ClassNotFoundException e){
//    	System.out.println(e.getMessage());
//    } catch (SQLException e) {
//		// TODO Auto-generated catch block
//    	System.out.println(e.getMessage());
//	}
//  
//  return connection;
//}
	
    private static final String SELECT_USER_BY_ID = "SELECT user_id, user_name,  email_id, saltVale   FROM users WHERE email_id = ?;";
    private static final String INSERT_USERS_SQL ="INSERT INTO users (user_name, email_id, encryptedPassword, saltVale)  VALUES (?, ?, ?, ?);";
    private static final String DELETE_USERS_SQL ="DELETE FROM users WHERE email_id = ? AND saltVale = ? ;";
    private static final String UPDATE_USERS_SQL ="UPDATE users SET  user_name = ?, email_id = ? , encryptedPassword = ?, saltVale = ?, WHERE email_id = ? AND saltVale = ?  ";
    private static final String GET_USER_EMAIL_SALT = "SELECT encryptedPassword, saltVale, user_id FROM users WHERE email_id = ? ;";
    
    //GetUserEmail
    public Login getEmailAndSalt(String email) throws SQLException {
    	Login user = null;
    	System.out.println("GET_USER_EMAIL_SALT");
    	try(Connection DBcon = getConnection();
      			 PreparedStatement preparedStatement = DBcon.prepareStatement(GET_USER_EMAIL_SALT);) 
      	 {
    		preparedStatement.setString(1, email);
    		
    		 ResultSet rs = preparedStatement.executeQuery();
    		
    		 
    		 while(rs.next()) {
    			 String saltVale = rs.getString("saltVale");
    			 String encryptedPassword = rs.getString("encryptedPassword");
    			 int user_id = rs.getInt("user_id");
    			 System.out.println("email " +  email + " -> " + encryptedPassword );
    			 return new Login(  email, encryptedPassword, saltVale, user_id);	 
    		 }
   
      	 }catch(Exception e) {
      		 System.out.println("error ->" + e);
      	 }
    	return user;
		
    	
    }
   
    //insertUser
    public UserStatus insertUser(String userName, String email_id, String  encryptedPassword, String saltValue) throws SQLException {
   	 System.out.println("INSERT_USERS_SQL");
   	 boolean CreateUser = false;
   	 
   	 
   	try(Connection DBcon = getConnection();
   			 PreparedStatement preparedStatement = DBcon.prepareStatement(INSERT_USERS_SQL);
   			 ) 
   	 {
   		 preparedStatement.setString(1, userName);
   		 preparedStatement.setString(2, email_id);
   		 preparedStatement.setString(3, encryptedPassword);
   		 preparedStatement.setString(4, saltValue);
   		 CreateUser = preparedStatement.executeUpdate() > 0;
   		 if(CreateUser) {
   			 return UserStatus.OK;
   		 }
   		 else {
   			return UserStatus.ERROR; 
   		 }
   		 
   	 } catch (SQLIntegrityConstraintViolationException er) {
   		 System.out.println("// Duplicate entry -> " + er);
   		return UserStatus.DUPLICATE_ENTRY; 
   	    
   	} catch (SQLException sq) {
   	    System.out.println(sq);
   	 return UserStatus.ERROR;
   	}
   	catch (Exception e) {
   		 
   		 System.out.println(e);
   		 return UserStatus.ERROR;
   		 
        }
   }
    
    //selectUser 
    
    public User selectUser(String email, String salt_Vale) throws SQLException {
    	User userObj = null;
    	 System.out.println("SELECT_USER_BY_ID");
    	 try(Connection DBcon = getConnection();
    			 PreparedStatement preparedStatement = DBcon.prepareStatement(SELECT_USER_BY_ID);
    			 ) 
    	 {
    		 
    		 preparedStatement.setString(1, email);
    		 ResultSet rs = preparedStatement.executeQuery();
    		//String user_id, user_name, email_id, saltVale;
    		 
    		 while(rs.next()){  
//    			 System.out.println(rs.getInt(1)+" "+rs.getString(2));
//    			 System.out.println(rs.getString("user_id"));
//    			 System.out.println(rs.getString("user_name"));
//    			 System.out.println(rs.getString("email_id"));
//    			 System.out.println(rs.getString("saltVale"));
    			 String user_id = rs.getString("user_id");
    			 String user_name = rs.getString("user_name");
    			 String email_id = rs.getString("email_id");
    			 String saltVale = rs.getString("saltVale");
    			 System.out.println(" user " + user_name);		 
    			 return new User(user_id, user_name, email_id, saltVale);
    			 
    		 }
 
    		 
    	 
    	}catch (SQLException e) {
    		System.out.println(e.getMessage());
         }
		//return userObj;
		return userObj;
    	 
    }
    //updateUser
    public boolean updateUser(User user) throws SQLException {
    	  boolean rowUpdated = false;
   	 System.out.println("INSERT_USERS_SQL");
   	 try(Connection DBcon = getConnection();
   			 PreparedStatement preparedStatement = DBcon.prepareStatement(UPDATE_USERS_SQL);
   			 ) 
   	 {
   		 preparedStatement.setString(1, user.getUser_name());
   		 preparedStatement.setString(3, user.getEncryptedPassword());
   		 preparedStatement.setString(4, user.getSaltVale());
   		 
   		 rowUpdated = preparedStatement.executeUpdate() > 0;
   		
   	 }catch (SQLException e) {
            e.printStackTrace();
        }
   	 return  rowUpdated;
   }
    //deleteUser
    public boolean deleteUser(String email, String salt_Vale) throws SQLException {
    	   boolean rowDeleted = false;
      	 System.out.println("INSERT_USERS_SQL");
      	 try(Connection DBcon = getConnection();
      			 PreparedStatement preparedStatement = DBcon.prepareStatement(DELETE_USERS_SQL);
      			 ) 
      	 {
      		 preparedStatement.setString(1, email);
    		 preparedStatement.setString(2, salt_Vale);
      		 
      		rowDeleted = preparedStatement.executeUpdate() > 0;
      		
      		 
      	 }catch (SQLException e) {
               e.printStackTrace();
           }
      	 return rowDeleted;
      }
   
    
	

}
