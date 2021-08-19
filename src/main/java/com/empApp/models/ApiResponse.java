package com.empApp.models;

import java.util.Map;

public class ApiResponse {

	Map<String, Object> responseMap;

	public Map<String, Object> getResponseMap() {
		return responseMap;
	}

	public void setResponseMap(Map<String, Object> responseMap) {
		this.responseMap = responseMap;
	}

	public ApiResponse(Map<String, Object> responseMap) {
		super();
		this.responseMap = responseMap;
	}

	
}
