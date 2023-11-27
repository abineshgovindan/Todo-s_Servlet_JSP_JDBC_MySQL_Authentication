package com.todo_app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.todo_app.model.Tasks;
import com.todo_app.service.TaskService;
import com.todo_app.utils.TaskStatus;


@WebServlet("/")
public class TasksControllers extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7467539731774649480L;
	
	private TaskService taskService;
	private HttpSession session;
	
	public void init() {
		taskService = new   TaskService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);

	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getServletPath();
		try {
			switch(action) {
			case "/new":
				
				break;
			case "/insert":
				insetTask(req,res);
				break;
			case "/update":
				break;
			case "/delete":
				break;
			case "/list":
				listTask(req, res);
				break;
			case "/edit":
				break;
			default:
				System.out.println("redirected..");
				RequestDispatcher rs = req.getRequestDispatcher("/loginPage");
				rs.forward(req, res);
				
			}
			
		}catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	private void listTask(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		int user_id = (int)session.getAttribute("user_id");
		String saltVale = (String)session.getAttribute("saltVale");
		List<Tasks> taskList = taskService.getAllTasks(user_id, saltVale);
		System.out.println(taskList);
		 session = req.getSession();
		 session.setAttribute("listTasks", taskList);
		
		RequestDispatcher rs = req.getRequestDispatcher("/taskList");
		try {
			rs.forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void insetTask(HttpServletRequest req, HttpServletResponse res) {
		//user_id, saltVale, task_description, due_date, task_priority, completed
		String task_description = req.getParameter("task_description");
		System.out.println(task_description);
		LocalDate due_date = LocalDate.parse(req.getParameter("due_date"));
		System.out.println(due_date);
		int task_priority = Integer.parseInt(req.getParameter("task_priority"));
		
		session = req.getSession();
		
		System.out.println(" -> "+ task_description + due_date + task_priority  );
		int user_id = (int) session.getAttribute("user_id");
		String saltVale = (String)session.getAttribute("saltVale");
		//int user_id,  String saltVale, String task_description, LocalDate due_date, int task_priority, boolean completed
//		String saltVale = "zIkltVc1gcl2BM96QfDxhWBFZelalv";
//		int user_id = 2;
		Tasks task = new Tasks(user_id, saltVale, task_description, due_date, task_priority);
		
		try {
			TaskStatus tService  = taskService.insertNewTasks(task);
			if(tService.equals(TaskStatus.CREATED)) {
				System.out.println("Created");
				RequestDispatcher rs = req.getRequestDispatcher("/list");
				rs.forward(req, res);
				
				
			}else {
				System.out.println("ERROR");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
