package com.wellnessmanagement.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Farmers implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	int frid;
	
	String frname, fradrr, frphone, fremailid, frfeedback;
	
	public Farmers() {
		super();
	}
	public Farmers(int frid, String frname, String fradrr, String frphone, String fremailid, String frfeedback) {
		super();
		this.frid = frid;
		this.frname = frname;
		this.fradrr = fradrr;
		this.frphone = frphone;
		this.fremailid = fremailid;
		this.frfeedback = frfeedback;
	}
	
	public int getFrid() {
		return frid;
	}
	public void setFrid(int frid) {
		this.frid = frid;
	}
	public String getFrname() {
		return frname;
	}
	public void setFrname(String frname) {
		this.frname = frname;
	}
	public String getFradrr() {
		return fradrr;
	}
	public void setFradrr(String fradrr) {
		this.fradrr = fradrr;
	}
	public String getFrphone() {
		return frphone;
	}
	public void setFrphone(String frphone) {
		this.frphone = frphone;
	}
	public String getFremailid() {
		return fremailid;
	}
	public void setFremailid(String fremailid) {
		this.fremailid = fremailid;
	}
	public String getFrfeedback() {
		return frfeedback;
	}
	public void setFrfeedback(String frfeedback) {
		this.frfeedback = frfeedback;
	}
	
	@Override
	public String toString() {
		return "Farmers [frid=" + frid + ", frname=" + frname + ", fradrr=" + fradrr + ", frphone=" + frphone
				+ ", fremailid=" + fremailid  + ", frfeedback="
				+ frfeedback + "]";
	}	
	
}
