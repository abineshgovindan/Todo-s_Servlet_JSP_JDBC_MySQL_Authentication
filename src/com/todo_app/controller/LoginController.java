package com.todo_app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo_app.dao.UserDao;
import com.todo_app.model.Login;
import com.todo_app.service.UserService;
import com.todo_app.utils.UserStatus;

public class LoginController extends HttpServlet {
	
	private UserDao userdao;
	UserService userivces ;
	RequestDispatcher rd ;
	UserStatus status ;
	
	
	
	public void init() {
		System.out.println("initil -> fun");
		userdao = new UserDao();
		userivces = new UserService();
		  
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
		
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			 status =  (UserStatus)userivces.loginServices(email, password);
			PrintWriter out = res.getWriter();
			if(status.equals(UserStatus.OK)) {
				Login data =  userivces.getUserData();
				HttpSession session = req.getSession();
				session.setAttribute("user_id", data.getUser_id());
				session.setAttribute("saltVale", data.getSaltVale());
				RequestDispatcher rs = req.getRequestDispatcher("/list");
				rs.forward(req, res);
				
			}else {
				String error = null;
				if(status.equals(UserStatus.NOT_FOUND) ) {
					error = "Sorry UserName don't exists..";
				}else if(status.equals(UserStatus.ERROR)) {
					error = "Sorry try again...";
				}else if(status.equals(UserStatus.WORNG_PASSWORD)) {
					error = "Worng password...";
				}
				req.setAttribute("Error", error );
				rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, res);
				
				out.print("<h2>Worng credentials...</h2>");
			}
			
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
