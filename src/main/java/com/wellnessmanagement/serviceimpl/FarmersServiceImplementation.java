package com.wellnessmanagement.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellnessmanagement.model.Farmers;
import com.wellnessmanagement.model.Products;
import com.wellnessmanagement.repository.farmer.FarmersRepository;
import com.wellnessmanagement.repository.farmer.ProductsRepository;
import com.wellnessmanagement.service.FarmersService;

@Service
public class FarmersServiceImplementation implements FarmersService {

	
	@Autowired
	FarmersRepository frrepo;
	
	@Autowired
	ProductsRepository prrepo;
	
	@Override
	public List<Farmers> getFarmersDetails() {
		// TODO Auto-generated method stub
		return frrepo.findAll();
	}

	@Override
	public Farmers getById(int id) {
		// TODO Auto-generated method stub
		return frrepo.getById(id);
	}
    

	@Override
	public void addFarmersDetails(Farmers f) {
		// TODO Auto-generated method stub
		frrepo.save(f);
	}

	@Override
	public String updateFarmers(Farmers s) {
		// TODO Auto-generated method stub
		if(frrepo.getById(s.getFrid()) != null) {
			frrepo.save(s);
			return "Updation is successful";
		}
		else
		{
			return "Farmer with Id "+s.getFrid()+" not found";}
	}
	
	@Override
	public List<Products> farmerproducts(int fid) {
		// TODO Auto-generated method stub
		List<Products> list = prrepo.findAll();
		list = list.stream().filter(s -> String.valueOf(s.getPrid()).substring(0,5).equalsIgnoreCase(String.valueOf(fid))).collect(Collectors.toList());
		return list;
	}
	
	@Override
	public List<Products> getProductDetails() {
		// TODO Auto-generated method stub
		return prrepo.findAll();
	}

	@Override
	public Products getByName(String name) {
		// TODO Auto-generated method stub
		List<Products> list = prrepo.findAll();
		for(Products p : list) {
			if(p.getPrname().equalsIgnoreCase(name)) {
				return prrepo.getById(p.getPrid());
			}
		}
		return null;
	}

	@Override
	public Products addProductDetails(Products p) {
		// TODO Auto-generated method stub
		return prrepo.save(p);
		
	}

	@Override
	public List<Products> getProductListDetails(String productname) {
		// TODO Auto-generated method stub
		List<Products> list = prrepo.findAll();
		list = list.stream().filter(s -> s.getPrname().equalsIgnoreCase(productname)).collect(Collectors.toList());
		return list;
	}

	@Override
	public List<String> getProductsName() {
		// TODO Auto-generated method stub
		List<Products> list = prrepo.findAll();
		return list.stream().map(Products::getPrname).collect(Collectors.toList());
	}

	

}
