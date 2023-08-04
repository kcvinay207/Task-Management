package com.example.demoSpring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoSpring.DAO.TaskDao;
import com.example.demoSpring.DTO.Task;

@RestController
public class TaskController {
	
	
	@Autowired
	TaskDao dao;
    
	
	@PostMapping("/task")
	public String  addTask(@RequestBody Task task)
	{
		
		
		return dao.addTask(task);
	}
	
	@GetMapping("/task")
	public Task findTaskByID(@RequestParam int id)
	{
		return dao.findTaskByID(id);

	}
	
	@GetMapping("/alltask")
	
	public List<Task> findAllTask()
	{
		return dao.findAllTask();

	}
	
	@DeleteMapping("/task")
	public String deleteById(@RequestParam int id)
	{
		return dao.deleteById(id);

	}
	
	@PutMapping("/task")
	public String updateStatus(@RequestParam int id,@RequestParam String status)
	{
		return dao.updateStatus(id, status);
	}
	
	@GetMapping("/list")
	public List<Object> listOfTask(@RequestParam String target_date)
	{
		return dao.taskList(target_date);
	}
}






























