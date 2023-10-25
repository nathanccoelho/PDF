package com.generation.json.controller;


import java.io.FileNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.json.model.Json;
import com.lowagie.text.DocumentException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pdf")
public class JsonController {

	
	
	@PostMapping("/registerpdf")
	public Json registerPdf(@Valid @RequestBody String relatorio) throws DocumentException, FileNotFoundException{
		return new Json(relatorio);
		
	}
	
	
}
