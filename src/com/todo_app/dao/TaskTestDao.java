package com.todo_app.dao;



import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.todo_app.model.Tasks;
import com.todo_app.utils.TaskStatus;

public class TaskTestDao {
	public static void main(String[] args) {
		TaskDao taskDao = new TaskDao();
	
	System.out.println( LocalDate.now());
		//int user_id, String task_description, Date due_date,int task_priority, boolean completed
//		Tasks task = new Tasks(2, "zIkltVc1gcl2BM96QfDxhWBFZelalv","New Task 3",  LocalDate.now(), 2, false);
//		Tasks task1 = new Tasks(2, "zIkltVc1gcl2BM96QfDxhWBFZelalv","New Task 4",  LocalDate.now(), 2, false);
//		Tasks task2 = new Tasks(2, "zIkltVc1gcl2BM96QfDxhWBFZelalv","New Task 5",  LocalDate.now(), 2, false);
//		Tasks task3 = new Tasks(2, "zIkltVc1gcl2BM96QfDxhWBFZelalv","New Task 6",  LocalDate.now(), 2, false);
		try {
			//Insert function
//		  TaskStatus status =  taskDao.insertTasks(task);
//		  	if(status.equals(TaskStatus.CREATED)) {
//		  		System.out.println("Task Created");
//		  	}else {
//		  		System.out.println("Task Not Created");
//		  	}
			//getAllTasks
			List<Tasks> TaskList =  taskDao.getAllTasks(2, "zIkltVc1gcl2BM96QfDxhWBFZelalv");
			for(Tasks task :TaskList ) {
				System.out.println(task.toString());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

}
