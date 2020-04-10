package com.gelmius.tsm.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gelmius.tsm.models.Task;

@Service
public class TaskService {


	private List<Task> tasks = new ArrayList<>(Arrays.asList(
			new Task("pirma", "pirma uzduotis", 12, 1,"Tomas",new ArrayList<>(Arrays.asList(
				new Task("pirma1", "pirma1 uzduotis", 4, 1,"Tomas",false),
				new Task("pirma2", "pirma2 uzduotis", 8, 1,"Tomas",false)
			)),false),
			new Task("antra", "antra uzduotis", 15, 2,"gediminas",new ArrayList<>(Arrays.asList(
					new Task("antra1", "antra1 uzduotis", 5, 1,"gediminas",false),
					new Task("antra2", "antra2 uzduotis", 5, 1,"gediminas",false),
					new Task("antra3", "antra3 uzduotis", 5, 1,"gediminas",false)
				)),false)
			));
	
	public List<Task> getAllTasks(){
		return tasks;
	}
	
	public Task getTask(String taskId) {
		return tasks.stream().filter(t -> t.getId().equals(taskId)).findFirst().get();
	}
	
	public Task getSubTask(String taskId, String subTaskId) {
		return getTask(taskId).getSubTasks().stream().filter(t -> t.getId().equals(subTaskId)).findFirst().get();
	}

	public void addTask(Task task) {
		tasks.add(task);		
	}

	public void addSubTask( String taskId, Task task) {
		getTask(taskId).getSubTasks().add(task);
	}

	public void updateTask(Task updateTask, String taskId) {
		for (Task task: tasks) {
			if(task.getId().equals(taskId)) {
				if(checkIsFinished(task, updateTask)) {					
					tasks.set(tasks.indexOf(task), updateTask);
				}
				return;
			}
		}		
	}
	
	public void updateSubTask(Task task, String taskId,String subTaskId) {
		for (Task tas: tasks) {
			if(tas.getId().equals(taskId)) {
				for(Task tas1: tas.getSubTasks()) {
					if(tas1.getId().equals(subTaskId)) {
						tas.getSubTasks().set(tas.getSubTasks().indexOf(tas1), task);
						return;
					}
				}				
			}
		}		
	}
	
	public void deleteTask(String taskId) {		
		tasks.removeIf(t -> t.getId().equals(taskId));
	}

	public void deleteSubTask(String taskId, String subTaskId) {
		for (Task task: tasks) {
			if(task.getId().equals(taskId)) {
				task.getSubTasks().removeIf(t -> t.getId().equals(subTaskId));
			}
		}		
	}
	
	//return false if making task finish but there are not finished sub-tasks
	public boolean checkIsFinished(Task task, Task updateTask) {
		if(task.isFinished()!=updateTask.isFinished() && updateTask.isFinished() == true) {
			for (Task tas: updateTask.getSubTasks()) {
				if(!tas.isFinished()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void makeFinish(String taskId) {
		for (Task task: tasks) {
			if(task.getId().equals(taskId)) {
				task.setFinished(true);
			}
		}
	}
	
}
