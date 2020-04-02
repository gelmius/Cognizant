package com.gelmius.tsm.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
	
	private String id;
	private String name;
	private int timeSpent;
	private int group;
	private String assignee;
	private List<Task> subTasks;
	private boolean isFinished;
	
	public Task(String id, String name, int timeSpent, int group, String assignee, List<Task> subTasks,
			boolean isFinished) {
		this.id = id;
		this.name = name;
		this.timeSpent = timeSpent;
		this.group = group;
		this.assignee = assignee;
		this.subTasks = subTasks;
		this.isFinished = isFinished;
	}
	
	public Task(String id, String name, int timeSpent, int group, String assignee,
			boolean isFinished) {
		this.id = id;
		this.name = name;
		this.timeSpent = timeSpent;
		this.group = group;
		this.assignee = assignee;
		this.isFinished = isFinished;
	}
	
	public Task() {

	}
}
