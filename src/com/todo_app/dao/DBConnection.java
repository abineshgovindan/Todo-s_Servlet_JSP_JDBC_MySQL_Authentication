package com.todo_app.dao;

import java.sql.*;

public  class DBConnection {
	private static final  String url = "jdbc:mysql://localhost:3306/todo_app?useSSL=false";
	private static final  String uName = "root";
    private static final  String password = "********";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    protected  static Connection connection = null ;
 
    protected  Connection getConnection() {
  	  Connection connection = null;
  	
      try {
      	  Class.forName(driver);
            
            connection = DriverManager.getConnection(url,uName, password);
            
        }catch (ClassNotFoundException e){
        	System.out.println(e.getMessage());
        } catch (SQLException e) {
			// TODO Auto-generated catch block
        	System.out.println(e.getMessage());
		}
      
      return connection;
  }

    
    

}
