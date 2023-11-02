package com.generation.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Position {

	
	private int numeric;
	
	private String readadle;

	public int getNumeric() {
		return numeric;
	}

	public void setNumeric(int numeric) {
		this.numeric = numeric;
	}

	public String getReadadle() {
		return readadle;
	}

	public void setReadadle(String readadle) {
		this.readadle = readadle;
	}
	
	
}
