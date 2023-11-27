package com.todo_app.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.todo_app.dao.UserDao;

@WebServlet("/user")
public class UserController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao userdao;
	
	public void init() {
		userdao = new UserDao();
		
	}
	
	
	

}
