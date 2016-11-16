package com.raj.dto;

public class KeyValueDto {

	private String key;
	private String value;
	
	public KeyValueDto() {
		super();
	}
	
	public KeyValueDto(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
