package com.wellnessmanagement.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")


@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

@Entity
public class Trader implements Serializable {

	@Id
	private int tid;
	private String tname;
	private String tphone;
	private String tmailid;
	private String tpassword;
	private String tfeedback;
	public Trader() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trader(int tid, String tname, String tphone, String tmailid, String tpassword, String tfeedback) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tphone = tphone;
		this.tmailid = tmailid;
		this.tpassword = tpassword;
		this.tfeedback = tfeedback;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTphone() {
		return tphone;
	}
	public void setTphone(String tphone) {
		this.tphone = tphone;
	}
	public String getTmailid() {
		return tmailid;
	}
	public void setTmailid(String tmailid) {
		this.tmailid = tmailid;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	public String getTfeedback() {
		return tfeedback;
	}
	public void setTfeedback(String tfeedback) {
		this.tfeedback = tfeedback;
	}
	@Override
	public String toString() {
		return "Trader [tid=" + tid + ", tname=" + tname + ", tphone=" + tphone + ", tmailid=" + tmailid
				+ ", tpassword=" + tpassword + ", tfeedback=" + tfeedback + "]";
	}
}
