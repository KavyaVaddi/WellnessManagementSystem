package com.wellnessmanagement.service;

import java.util.List;

import com.wellnessmanagement.model.Farmers;
import com.wellnessmanagement.model.Products;

public interface FarmersService {

	    //Farmers methods
		public List<Farmers> getFarmersDetails();
		public Farmers getById(int id);
		public void addFarmersDetails(Farmers f);
		public String updateFarmers(Farmers s);
		public List<Products> farmerproducts(int fid);
		
		//Products methods
		public List<Products> getProductDetails();
		public Products getByName(String name);
		public Products addProductDetails(Products p);
		public List<Products> getProductListDetails(String productname);
		public List<String> getProductsName();
}
