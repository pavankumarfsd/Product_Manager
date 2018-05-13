package com.task.dto;

public class LoginDto {

	private Long id;
	private String userId;
	private String password;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDto [id=" + id + ", userId=" + userId + ", password=" + password + "]";
	}
}
