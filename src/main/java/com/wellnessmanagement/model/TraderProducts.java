package com.wellnessmanagement.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")


@JsonIgnoreProperties({"hibernateLazyInitailizer","handler"})

@Entity
public class TraderProducts implements Serializable {

	@Id
	private int ppid;
	private String ppname;
	private int ppquantity;
	private double ppprice;
	public TraderProducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TraderProducts(int ppid, String ppname, int ppquantity, double ppprice) {
		super();
		this.ppid = ppid;
		this.ppname = ppname;
		this.ppquantity = ppquantity;
		this.ppprice = ppprice;
	}
	public int getPpid() {
		return ppid;
	}
	public void setPpid(int ppid) {
		this.ppid = ppid;
	}
	public String getPpname() {
		return ppname;
	}
	public void setPpname(String ppname) {
		this.ppname = ppname;
	}
	public int getPpquantity() {
		return ppquantity;
	}
	public void setPpquantity(int ppquantity) {
		this.ppquantity = ppquantity;
	}
	public double getPpprice() {
		return ppprice;
	}
	public void setPprice(double ppprice) {
		this.ppprice = ppprice;
	}
	@Override
	public String toString() {
		return "Products [ppid=" + ppid + ", ppname=" + ppname + ", ppquantity=" + ppquantity + ", ppprice=" + ppprice
				+ "]";
	}
	
}
