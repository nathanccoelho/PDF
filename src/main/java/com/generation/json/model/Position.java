package com.generation.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Position {

	
	private String numeric;
	
	private String readable;

	public Position() {
	}

	public String getNumeric() {
		return numeric;
	}

	public void setNumeric(String numeric) {
		this.numeric = numeric;
	}

	public String getReadable() {
		return readable;
	}

	public void setReadable(String readable) {
		this.readable = readable;
	}

	
	
	
}
