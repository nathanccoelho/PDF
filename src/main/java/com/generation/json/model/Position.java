package com.generation.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Position {

	
	private int numeric;
	
	private String readable;

	public int getNumeric() {
		return numeric;
	}

	public void setNumeric(int numeric) {
		this.numeric = numeric;
	}

	public String getReadable() {
		return readable;
	}

	public void setReadable(String readable) {
		this.readable = readable;
	}

	
	
	
}
