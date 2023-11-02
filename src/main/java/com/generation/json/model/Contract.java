package com.generation.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contract {
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("idade")
	private String idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	
}
