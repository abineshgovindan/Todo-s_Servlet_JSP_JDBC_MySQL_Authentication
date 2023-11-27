package com.todo_app.service;

import java.sql.SQLException;
import java.util.List;

import com.todo_app.dao.TaskDao;
import com.todo_app.model.Tasks;
import com.todo_app.utils.TaskStatus;

public class TaskService {
	TaskDao taskDao = new TaskDao();
	
	public TaskStatus insertNewTasks(Tasks task) throws SQLException {
		
		TaskStatus status = taskDao.insertTasks(task);
		return status;
		
	}
	
	public List<Tasks> getAllTasks(int user_id, String saltVale) {
		List<Tasks> taskList = taskDao.getAllTasks(user_id, saltVale);
		
		return taskList;
	}
	
	
	

}
