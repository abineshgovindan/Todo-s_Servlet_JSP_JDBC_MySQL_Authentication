package com.todo_app.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;




public class Tasks implements Serializable  {
	
/**
	 * 
	 */
private static final long serialVersionUID = 6441642789872432969L;
protected int user_id;
protected int task_id;
protected String saltVale;
protected String task_description ;
protected int task_priority;
protected LocalDate  due_date ;
protected boolean completed = false;


public Tasks(int user_id, int task_id, String saltVale, String task_description, int task_priority, LocalDate due_date,
		boolean completed) {
	super();
	this.user_id = user_id;
	this.task_id = task_id;
	this.saltVale = saltVale;
	this.task_description = task_description;
	this.task_priority = task_priority;
	this.due_date = due_date;
	this.completed = completed;
}

public Tasks() {
	
}

public Tasks(int user_id,  String saltVale, String task_description, LocalDate due_date, int task_priority) {
	this.user_id = user_id;
	this.task_description = task_description;
	this.due_date = due_date;  //Date.valueOf(LocalDate.now()) ;
	
	this.task_priority = task_priority;
	this.saltVale = saltVale;
}


public String getSaltVale() {
	return saltVale;
}

public void setSaltVale(String saltVale) {
	this.saltVale = saltVale;
}

public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getTask_description() {
	return task_description;
}
public void setTask_description(String task_description) {
	this.task_description = task_description;
}
public LocalDate getDue_date() {
	return due_date;
}
public void setDue_date(LocalDate due_date) {
	this.due_date = due_date;
}
public int getTask_id() {
	return task_id;
}

public int getTask_priority() {
	return task_priority;
}

public void setTask_id(int task_id) {
	this.task_id = task_id;
}

public void setTask_priority(int task_priority) {
	this.task_priority = task_priority;
}

public boolean isCompleted() {
	return completed;
}
public void setCompleted(boolean completed) {
	this.completed = completed;
}

@Override
public String toString() {
	return "Tasks [getTask_description()=" + getTask_description() + ", getDue_date()=" + getDue_date()
			+ ", getTask_id()=" + getTask_id() + ", getTask_priority()=" + getTask_priority() + ", isCompleted()="
			+ isCompleted() + "]";
}

 
}
