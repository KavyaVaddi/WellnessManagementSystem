package com.wellnessmanagement.model.login;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class product {

	
	@Id
	int pid;
	String pname;
	String pquantity;
	String pprice;

	public void setPquantity(String pquantity) {
		this.pquantity = pquantity;
	}

	public product() {
		
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	

	public String getPprice() {
		return pprice;
	}

	public void setPprice(String pprice) {
		this.pprice = pprice;
	}

	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", pquantity=" + pquantity + ", pprice=" + pprice + "]";
	}

	public product(int pid, String pname, String pquantity, String pprice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pquantity = pquantity;
		this.pprice = pprice;
	}
	
}
