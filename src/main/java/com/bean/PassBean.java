package com.bean;

public class PassBean {
	Integer passId,verify;
	Integer enrollmentNum;
	Integer approve;
	String reason, outTime;
	String passDate;

	public Integer getPassId() {
		return passId;
	}

	public void setPassId(Integer passId) {
		this.passId = passId;
	}

	public int getEnrollmentNum() {
		return enrollmentNum;
	}

	public void setEnrollmentNum(int enrollmentNum) {
		this.enrollmentNum = enrollmentNum;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public int getApprove() {
		return approve;
	}

	public void setApprove(int approve) {
		this.approve = approve;
	}

	public String getPassDate() {
		return passDate;
	}

	public void setPassDate(String passDate) {
		this.passDate = passDate;
	}
	public int getVerify() {
		return approve;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}
}