package com.empApp.models;

import java.util.Date;

public class ResponseStatus {

	private Date timeStamp;
	private String errorMessage;
	private boolean success;
	public ResponseStatus(Date timeStamp, String errorMessage, boolean success) {
		super();
		this.timeStamp = timeStamp;
		this.errorMessage = errorMessage;
		this.success = success;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	@Override
	public String toString() {
		return "ResponseStatus [timeStamp=" + timeStamp + ", errorMessage=" + errorMessage + ", success=" + success
				+ "]";
	}
	
	
}
