package com.example.demoSpring.DAO;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoSpring.DTO.Task;
import com.example.demoSpring.Repository.TaskRepository;



@Repository
public class TaskDao
{
	@Autowired
	TaskRepository repository;
	
	//to insert task into database
	public String addTask(Task task)
	{
		repository.save(task);
		
		return "task is added successfully";
	}
	
	
	//to search for task object based on id
	public Task findTaskByID(int id)
	{
		Optional<Task> opt = repository.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
	  return null;
	}
	
	//to display all objects from data base
	public List<Task> findAllTask()
	{
		return repository.findAll();
	}
	
	//to delete a task from data base
	 
	public String deleteById(int id)
	{
		Task t = findTaskByID(id);
		if(t != null) {
			repository.deleteById(id);
			return "task is deleted successfully";
			
		} 
		return "id is not found";
	}
//to update the status of a task
	public String updateStatus(int id,String status)
	{
		Optional<Task> opt = repository.findById(id);
		if(opt.isPresent())
		{
			Task t = opt.get();
			t.setStatus(status);
			repository.save(t);
			
			return "Status is updated";
		}
		return "Id is not present......)";
	}
	
	public List<Object> taskList(String target_date)
	{
		return repository.taskList(target_date);
	}
}



