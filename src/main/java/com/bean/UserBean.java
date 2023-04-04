package com.bean;

public class UserBean {
	private int role,phoneNumber;
	private int enrollmentNum;
	private boolean approve;
	private String firstName,email,password,otp;
	public int getEnrollmentNum() {
		return enrollmentNum;
	}
	public void setEnrollmentNum(int enrollmentNum) {
		this.enrollmentNum = enrollmentNum;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public boolean getApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public int getPhoneNumber() {
		return enrollmentNum;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
