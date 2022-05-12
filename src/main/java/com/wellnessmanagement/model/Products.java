package com.wellnessmanagement.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

//import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Products implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	int prid;
	String prname;
	//MultipartFile primage;
	int prquantity;
	double priceperquantity;
	
	public Products() {
		super();
	}
	public Products(int prid, String prname, int prquantity, double priceperquqntity) {
		super();
		this.prid = prid;
		this.prname = prname;
		//this.primage = primage;
		this.prquantity = prquantity;
		this.priceperquantity = priceperquqntity;
	}
	
	public int getPrid() {
		return prid;
	}
	public void setPrid(int prid) {
		this.prid = prid;
	}
	public String getPrname() {
		return prname;
	}
	public void setPrname(String prname) {
		this.prname = prname;
	}
	public int getPrquantity() {
		return prquantity;
	}
	public void setPrquantity(int prquantity) {
		this.prquantity = prquantity;
	}
	public double getPriceperquqntity() {
		return priceperquantity;
	}
	public void setPriceperquqntity(double priceperquqntity) {
		this.priceperquantity = priceperquqntity;
	}
	
	@Override
	public String toString() {
		return "Products [prid=" + prid + ", prname=" + prname + ", prquantity=" + prquantity
				+ ", priceperquqntity=" + priceperquantity + "]";
	}
	
}