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

import com.wellnessmanagement.model.Trader;
import com.wellnessmanagement.model.TraderProducts;
import com.wellnessmanagement.service.TraderProductsService;
import com.wellnessmanagement.service.TraderService;

@RestController
@RequestMapping("/admin/trader")
public class AdminTraderController {

	// Admin accessing trader table
	@Autowired
	TraderService service;
	
	@RequestMapping("/test")
    public String test() {
		System.out.print("hello trader");
		return "trader class created successfully";
	}
	
	@GetMapping("/fetch/{tname}/{tphone}/{tmailid}")
	public List<Trader> fetchTraderList(@PathVariable(value="tname")String tname,@PathVariable(value="tphone")String tphone,@PathVariable(value="tmailid")String tmailid){
		List<Trader> trader = service.fetchTraderList(tname, tphone, tmailid);
		for(Trader t:trader)
			System.out.println(t+"\n");
		return trader;
	}
	
	@PostMapping("/entertraderdetails")
	public ResponseEntity<Trader> saveTraderDetails(@RequestBody Trader t){
		Trader trader = t;
		service.saveTrader(t);
		return new ResponseEntity<Trader>(trader,HttpStatus.OK);
	}
	
	@PutMapping("/updatetrader/{tid}")
	public ResponseEntity<Trader> updateTraderDetails(@PathVariable(value="tid")Integer tid,@RequestBody Trader t){
		service.updateTrader(t, tid);
		return new ResponseEntity<Trader>(t,HttpStatus.OK);
		}
	
	@DeleteMapping("/deletetrader/{tid}")
	public ResponseEntity<Trader> deleteTrader(@PathVariable(value="tid")Integer tid){
		Trader trader = service.deleteTrader(tid);
		return new ResponseEntity<Trader>(trader,HttpStatus.OK);
	}
	
	// Admin Accessing trader products
	
	@Autowired
	TraderProductsService productservice;
	
	@GetMapping("/product/fetchdetails")
	public List<TraderProducts> fetchProductsList(){
		List<TraderProducts> pdt = productservice.fetchProductsList();
		for(TraderProducts p:pdt)
			System.out.println(p+"\n");
		return pdt;
	}
	
	@PostMapping("/product/enterproductdetails")
	public ResponseEntity<TraderProducts> saveProductDetails(@RequestBody TraderProducts p){
		TraderProducts pdt = p;
		productservice.saveProduct(p);
		return new ResponseEntity<TraderProducts>(pdt,HttpStatus.OK);
	}
	
	@GetMapping("/product/traderproducts/{id}")
	public List<TraderProducts> getTraderProductDetails(@PathVariable(value = "id")int id){
		return productservice.traderproducts(id);
	}
	
	@PutMapping("/product/updateproduct/{ppid}")
	public ResponseEntity<TraderProducts> updateProductDetails(@PathVariable(value="ppid")Integer ppid,@RequestBody TraderProducts p){
		productservice.updateProduct(p, ppid);
		return new ResponseEntity<TraderProducts>(p,HttpStatus.OK);
	}
	
	@DeleteMapping("/product/deleteproduct/{ppid}")
	public ResponseEntity<TraderProducts> deleteProduct(@PathVariable(value="ppid")Integer ppid){
		TraderProducts product = productservice.deleteProduct(ppid);
		return new ResponseEntity<TraderProducts>(product,HttpStatus.OK); 
	}
	
}
