package com.task.dto;

public class Response {
	
	private String status;
	private boolean isSuccess;
	private Object response;
	
	public Response() {}
	
	public Response(String status, boolean isSuccess, Object response) {
		this.status = status;
		this.isSuccess = isSuccess;
		this.response = response;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	
	public boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
}
