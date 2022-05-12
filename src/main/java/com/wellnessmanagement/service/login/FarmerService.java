package com.wellnessmanagement.service.login;

import java.util.List;

import com.wellnessmanagement.model.login.farmer;
import com.wellnessmanagement.model.login.product;

public interface FarmerService {

	
	public List<farmer> fetchdetails();

	public farmer addfarmer(farmer f1);

	//void deletefarmer(farmer f2);

	//public farmer addfarmerbyid(int fid);

	public farmer deletebyId(int fid);

	List<product> fetchproductlist();

	boolean loginfarmer(int username, String password);

	String updatedetails(farmer f3);

	List<farmer> sortbyname();
	
}
