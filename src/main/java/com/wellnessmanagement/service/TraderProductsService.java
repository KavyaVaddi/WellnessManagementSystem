package com.wellnessmanagement.service;

import java.util.List;

import com.wellnessmanagement.model.TraderProducts;

public interface TraderProductsService {

	List<TraderProducts> fetchProductsList();
	List<TraderProducts> traderproducts(int tid);
	TraderProducts updateProduct(TraderProducts p,int ppid);
	TraderProducts deleteProduct(int ppid);
	void saveProduct(TraderProducts p);
}
