package com.wellnessmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellnessmanagement.model.Farmers;
import com.wellnessmanagement.model.Products;
import com.wellnessmanagement.service.FarmersService;

@RestController
@RequestMapping("/Farmers")
public class FarmersController {
	
	@Autowired
	FarmersService service;
	
	@GetMapping("/test")
	public String test() {
		return "From Controller Class";
	}
	
	@GetMapping("/farmersdetails")
	public List<Farmers> getFDetails(){
		return service.getFarmersDetails();
	}
	
	@PostMapping("/addfarmersdetails")
	public ResponseEntity<Farmers> saveFarmersDetails(@RequestBody Farmers s){
		service.addFarmersDetails(s);
		return new ResponseEntity<Farmers> (s, HttpStatus.OK);
	}
	
	@RequestMapping("/farmersdetailsbyid/{id}")
	public ResponseEntity<Farmers> getbyid(@PathVariable(value = "id") Integer id){
		Farmers f = service.getById(id);
		if(f != null) {
			return new ResponseEntity<> (f, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateFarmersDetails(@RequestBody Farmers s){
		String str;
		try {
		    str = service.updateFarmers(s);
			return new ResponseEntity<String> (str, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<> ("Farmer with the given id is not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/productsdetails")
	public List<Products> getPDetails(){
		return service.getProductDetails();
	}
	
	@GetMapping("/productsdetailsbyname/{str}")
	public List<Products> getProDetails(@PathVariable(value = "str") String str){
		return service.getProductListDetails(str);
	}
	
	@RequestMapping("/productsdetailsbyproductname/{str}")
	public ResponseEntity<Products> getbyid(@PathVariable(value = "str") String str){
		Products p = service.getByName(str);
		if(p != null) {
			return new ResponseEntity<> (p, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addproductsdetails")
	public ResponseEntity<Products> saveProductsDetails(@RequestBody Products s){
		service.addProductDetails(s);
		return new ResponseEntity<Products> (s, HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public List<String> getProDetails(){
		return service.getProductsName();
	}
	
	@GetMapping("/farmerproducts/{id}")
	public List<Products> getFarmerProdctDetails(@PathVariable(value = "id") int id){
		return service.farmerproducts(id);
	}
}
