package com.generation.json.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Items {
	
	private String content;
	
	@JsonProperty("enumeration_type")
	private String enumerationType;
	
	@JsonProperty("has_sub")
	private boolean hasSub;
	
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEnumerationType() {
		return enumerationType;
	}

	public void setEnumerationType(String enumerationType) {
		this.enumerationType = enumerationType;
	}

	public boolean isHasSub() {
		return hasSub;
	}

	public void setHasSub(boolean hasSub) {
		this.hasSub = hasSub;
	}
	
	

}
