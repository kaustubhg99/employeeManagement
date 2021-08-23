package com.empApp.models;

public class ApiResponse {

	Object data;
	ResponseStatus status;
	public ApiResponse(Object data, ResponseStatus status) {
		super();
		this.data = data;
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResponseStatus getStatus() {
		return status;
	}
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ApiResponse [data=" + data + ", status=" + status + "]";
	}
	
	
	

	
}
