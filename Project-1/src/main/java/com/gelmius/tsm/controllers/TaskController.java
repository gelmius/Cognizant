package com.gelmius.tsm.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gelmius.tsm.models.Task;
import com.gelmius.tsm.services.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@GetMapping("tasks/{id}")
	public Task getTask(@PathVariable String id) {
		return taskService.getTask(id);		
	}
	
	@GetMapping("tasks/{id}/{id1}")
	public Task getSubTask(@PathVariable String id, @PathVariable String id1) {
		return taskService.getSubTask(id, id1);
	}
	
	@PostMapping("/tasks")
	public void saveTask(@RequestBody Task task) {
		taskService.addTask(task);
	} 
	
	@PostMapping("/tasks/{id}")
	public void saveSubTask(@PathVariable String id, @RequestBody Task task) {
		taskService.addSubTask(id, task);
	}
	
	@PutMapping("/tasks/{id}")
	public void updateTask(@PathVariable String id, @RequestBody Task task) {
		taskService.updateTask(task, id);	
	}
	
	@PutMapping("/tasks/{id}/{id1}")
	public void updateSubTask(@PathVariable String id, @PathVariable String id1,  @RequestBody Task task) {
		taskService.updateSubTask(task, id, id1);
	}
	
	@DeleteMapping("/tasks/{id}")
	public void deleteTask(@PathVariable String id) {
		taskService.deleteTask(id);
		
	}
	
	@DeleteMapping("/tasks/{id}/{id1}")
	public void deleteSubTask(@PathVariable String id, @PathVariable String id1) {
		taskService.deleteSubTask(id, id1);		
	}
	
}
