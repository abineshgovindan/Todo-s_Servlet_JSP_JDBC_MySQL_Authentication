package com.todo_app.dao;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;


import com.todo_app.model.Tasks;
import com.todo_app.utils.TaskStatus;
import com.todo_app.utils.UserStatus;

public class TaskDao extends DBConnection {
	
	private static final String INSERT_NEW_TASKS = "INSERT INTO tasks (user_id, saltVale, task_description, due_date, task_priority, completed) VALUES (?, ?, ?, ?, ?, ?);";
	private static final String GET_ALL_USER_TASKS = "SELECT task_id, task_description, due_date, task_priority, completed FROM tasks WHERE user_id = ? AND saltVale = ?;";
	private static final String UPDATE_TASK = "SELECT task_id, task_description, due_date, task_priority, completed, FROM tasks WHERE user_id = ? AND saltVale = ?;";
	
	
	//getAlltasksforuser
	public List<Tasks> getAllTasks(int user_id, String saltVale){
		System.out.println("GET_ALL_USER_TASKS");
		List<Tasks> taskList = new ArrayList<Tasks>();
		try(Connection DBcon = getConnection();
    			 PreparedStatement preparedStatement = DBcon.prepareStatement(GET_ALL_USER_TASKS);) 
    	 {
			preparedStatement.setInt(1, user_id);
			preparedStatement.setString(2, saltVale);
			 ResultSet rs = preparedStatement.executeQuery();
			 while(rs.next()) {
				 Tasks tasks = new Tasks();
				 //task_id, task_description, due_date, task_priority, completed 
				 tasks.setTask_id(rs.getInt("task_id"));
				 tasks.setTask_description(rs.getString("task_description"));
				 tasks.setDue_date((rs.getDate("due_date").toLocalDate()));
				 tasks.setTask_priority(rs.getInt("task_priority"));
				 tasks.setCompleted(rs.getBoolean("completed"));
				 taskList.add(tasks);
			 
			 }
			
			
    	 }catch (SQLException e) {
			// TODO: handle exception
    		 System.out.println("SQL ERROR -> " + e);
		}
		
		
		
		return taskList;
		
	}
	
	//InsertTasks
	public TaskStatus insertTasks(Tasks task) throws SQLException {
		System.out.println("INSERT_NEW_TASKS");
		Boolean isCreated= false;
		try(Connection DBcon = getConnection();
     			 PreparedStatement preparedStatement = DBcon.prepareStatement(INSERT_NEW_TASKS);) 
     	 {
		//user_id, saltVale, task_description, due_date, task_priority, completed
			preparedStatement.setInt(1, task.getUser_id());
			preparedStatement.setString(2, task.getSaltVale());
			preparedStatement.setString(3, task.getTask_description());
			preparedStatement.setDate(4, Date.valueOf(task.getDue_date()) );
			preparedStatement.setInt(5, task.getTask_priority());
			preparedStatement.setBoolean(6, task.isCompleted());
			isCreated = preparedStatement.executeUpdate() > 0;
			if(isCreated) {
				return TaskStatus.CREATED;
			}else {
				return TaskStatus.NOT_CREATED;
			}
     	 } catch (SQLIntegrityConstraintViolationException er) {
       		 System.out.println("// Duplicate entry -> " + er);
       		return TaskStatus.ERROR;
       	    
       	} catch (SQLException sq) {
       	    System.out.println(sq);
       	 return TaskStatus.ERROR;
       	}
       	catch (Exception e) {
       		 
       		 System.out.println(e);
       		 return TaskStatus.ERROR;
       		 
            }
      
		
	}
	//updateTasks
	//deleteTasks
	
}
