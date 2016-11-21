package com.raj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class RequestData {

	EmpDto requestData;
	
	@JsonProperty(required = true)
    @ApiModelProperty(notes = "Request Data", required = true)
	public EmpDto getRequestData() {
		return requestData;
	}

	public void setRequestData(EmpDto requestData) {
		this.requestData = requestData;
	} 
	
}
