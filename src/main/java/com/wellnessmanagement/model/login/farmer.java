package com.wellnessmanagement.model.login;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@SuppressWarnings("serial")
@Entity
public class farmer implements Serializable {

	
	@Id
	private int fid;
	private String fname;
	private String  faddr;
	private int fphone;
	private String fmailid;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String fpasswd;
	
	
	private String ffeedback;


	public int getFid() {
		return fid;
	}


	public void setFid(int fid) {
		this.fid = fid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getFaddr() {
		return faddr;
	}


	public void setFaddr(String faddr) {
		this.faddr = faddr;
	}


	public int getFphone() {
		return fphone;
	}


	public void setFphone(int fphone) {
		this.fphone = fphone;
	}


	public String getFmailid() {
		return fmailid;
	}


	public void setFmailid(String fmailid) {
		this.fmailid = fmailid;
	}


	public String getFpasswd() {
		return fpasswd;
	}


	public void setFpasswd(String fpasswd) {
		this.fpasswd = fpasswd;
	}


	public String getFfeedback() {
		return ffeedback;
	}


	public void setFfeedback(String ffeedback) {
		this.ffeedback = ffeedback;
	}


	public farmer(int fid, String fname, String faddr, int fphone, String fmailid, String fpasswd, String ffeedback) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.faddr = faddr;
		this.fphone = fphone;
		this.fmailid = fmailid;
		this.fpasswd = fpasswd;
		this.ffeedback = ffeedback;
	}


	public farmer() {
		super();
	}


	@Override
	public String toString() {
		return "farmer [fid=" + fid + ", fname=" + fname + ", faddr=" + faddr + ", fphone=" + fphone + ", fmailid="
				+ fmailid + ", fpasswd=" + fpasswd + ", ffeedback=" + ffeedback + "]";
	}
	
	
}
