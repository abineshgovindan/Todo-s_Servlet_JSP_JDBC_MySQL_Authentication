package com.todo_app.controller;
import com.todo_app.dao.UserDao;
import com.todo_app.model.User;
import com.todo_app.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.todo_app.utils.PasswordHashing;
import com.todo_app.utils.UserStatus;


public class RegisterController extends HttpServlet {
	private UserDao userdao;
	UserService userivces ;
	RequestDispatcher rd ;
	
	
	
	public void init() {
		System.out.println("initil -> fun");
		userdao = new UserDao();
		userivces = new UserService();
		  
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		try {
			System.out.println("doPost");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			PrintWriter out = res.getWriter();
			UserStatus status = (UserStatus) userivces.registerServices(name, email, password);
			 
			
			if(status == UserStatus.OK) {
				System.out.println("Successfully Created....");
				rd = req.getRequestDispatcher("/");
				rd.forward(req, res);
				
				
			}else {
				String error = null;
				if(status.equals(UserStatus.DUPLICATE_ENTRY) ) {
					error = "Sorry Email Already exists..";
				}else if(status.equals(UserStatus.ERROR)) {
					error = "Sorry try again...";
				}else if(status.equals(UserStatus.ENTER_NAME_PASSWORD)) {
					error = "  Enter your name and password...";
				}
				req.setAttribute("Error", error );
				rd = req.getRequestDispatcher("register.jsp");
				rd.forward(req, res);
				
				
				
			}
			
			
			
			
			
			
			
			
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	

}
