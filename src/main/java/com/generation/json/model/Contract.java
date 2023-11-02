package com.generation.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contract {
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("idade")
	private int idade;

}
