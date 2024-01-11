package com.library.beans;

import java.util.Date;

//class to manage book issuance in library management system.
public class IssueBook {
	private String bid, studentid, studentname, studentmobile;
	private Date issueddate;
	private String returnstatus;

	public IssueBook() {
		// TODO Auto-generated constructor stub
	}

	public IssueBook(String bid, String studentid, String studentname, String studentmobile, Date issueddate,
			String returnstatus) {
		super();
		this.bid = bid;
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentmobile = studentmobile;
		this.issueddate = issueddate;
		this.returnstatus = returnstatus;
	}

	public IssueBook(String bid, String studentid, String studentname, String studentmobile) {
		super();
		this.bid = bid;
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentmobile = studentmobile;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentmobile() {
		return studentmobile;
	}

	public void setStudentmobile(String studentmobile) {
		this.studentmobile = studentmobile;
	}

	public Date getIssueddate() {
		return issueddate;
	}

	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}

	public String getReturnstatus() {
		return returnstatus;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}

	@Override
	public String toString() {
		return "IssueBook{" + "bid='" + bid + '\'' + ", studentid='" + studentid + '\'' + ", studentname='"
				+ studentname + '\'' + ", studentmobile='" + studentmobile + '\'' + ", issueddate=" + issueddate
				+ ", returnstatus='" + returnstatus + '\'' + '}';
	}

}
