package com.generation.json.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Appendixes {
	
	private String description;
	
	@Autowired
	private List<Items> items;
	
	private Position position;
	
	private String title;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	

}
