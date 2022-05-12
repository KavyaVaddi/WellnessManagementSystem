package com.wellnessmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellnessmanagement.model.TraderProducts;
import com.wellnessmanagement.service.TraderProductsService;

@RestController
@RequestMapping("/product")
public class TraderProductsController {
	@Autowired
	TraderProductsService service;
	
	@GetMapping("/fetchdetails")
	public List<TraderProducts> fetchProductsList(){
		List<TraderProducts> pdt = service.fetchProductsList();
		for(TraderProducts p:pdt)
			System.out.println(p+"\n");
		return pdt;
	}
	
	@PostMapping("/enterproductdetails")
	public ResponseEntity<TraderProducts> saveProductDetails(@RequestBody TraderProducts p){
		TraderProducts pdt = p;
		service.saveProduct(p);
		return new ResponseEntity<TraderProducts>(pdt,HttpStatus.OK);
	}
	
	@GetMapping("/traderproducts/{id}")
	public List<TraderProducts> getTraderProductDetails(@PathVariable(value = "id")int id){
		return service.traderproducts(id);
	}
	
	@PutMapping("/updateproduct/{ppid}")
	public ResponseEntity<TraderProducts> updateProductDetails(@PathVariable(value="ppid")Integer ppid,@RequestBody TraderProducts p){
		service.updateProduct(p, ppid);
		return new ResponseEntity<TraderProducts>(p,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteproduct/{ppid}")
	public ResponseEntity<TraderProducts> deleteProduct(@PathVariable(value="ppid")Integer ppid){
		TraderProducts product = service.deleteProduct(ppid);
		return new ResponseEntity<TraderProducts>(product,HttpStatus.OK); 
	}
	
}