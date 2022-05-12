package com.wellnessmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name= "Admins")
public class Admin {
	
	@Id
	@Column(name="Admin_id")
	private Integer aid;
	
	@Column(name= "Admin_name")
	private String aname;
	
	@Column(name="Admin_phoneno")
	private Long aphone;
	
	@Column(name="Admin_mailid")
	private String amailid;
	
	@Column(name="Admin_address")
	private String aaddress;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="Admin_password")
	private String apassword;
	
	public Admin() {
		super();
	}
	public Admin(Integer aid, String aname, Long aphone, String amailid, String aaddress, String apassword) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.aphone = aphone;
		this.amailid = amailid;
		this.aaddress = aaddress;
		this.apassword = apassword;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Long getAphone() {
		return aphone;
	}
	public void setAphone(Long aphone) {
		this.aphone = aphone;
	}
	public String getAmailid() {
		return amailid;
	}
	public void setAmailid(String amailid) {
		this.amailid = amailid;
	}
	public String getAaddress() {
		return aaddress;
	}
	public void setAaddress(String aaddress) {
		this.aaddress = aaddress;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", aphone=" + aphone + ", amailid=" + amailid + ", aaddress="
				+ aaddress + ", apassword=" + apassword + "]";
	}
	
	
}
