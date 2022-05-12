package com.wellnessmanagement.controller;

import java.util.ArrayList;
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

import com.wellnessmanagement.model.login.farmer;
import com.wellnessmanagement.model.login.product;
import com.wellnessmanagement.service.login.FarmerService;

@RestController
@RequestMapping("/farmerlogin")
public class FarmerController {

	
	@Autowired
	FarmerService f;
	
	
	@GetMapping("/hello")
	public String hello(){
		return "hello";
		}

	@GetMapping("/getdetails/{fid}/{password}")
	public List<farmer> getlist(@PathVariable(value = "fid") Integer fid,@PathVariable(value = "password") String password){
		boolean b = f.loginfarmer(fid,password );
		if(b==true) {
			return f.fetchdetails();
		}
		else {return null;}
	}
	
	@PostMapping("/addfarmers")
	public farmer addfarmer(@RequestBody farmer f2){
		farmer list = f.addfarmer(f2);
		return list;
	}
	
	@DeleteMapping("/deletefarmers/{fid}")
	public farmer deletefarmer(@PathVariable(value = "fid") Integer fid) {
		farmer list = f.deletebyId(fid);
		return list;
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updatedetails(@RequestBody farmer f4) {
		String str;
		try {
		    str = f.updatedetails(f4);
			return new ResponseEntity<String> (str, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<> ("Farmer with the given id is not found", HttpStatus.NOT_FOUND);
		}
		
		}
	
		
		
	@GetMapping("/sortedlist")
	public List<farmer> sortlist(){
		List<farmer> list = new ArrayList<farmer>();
		list =f.sortbyname();
		return list;
	}
	/*@PostMapping("/addbyid")
	public farmer addfarmerbyid(@RequestBody farmer f6,@PathVariable(value = "fid") Integer fid)
	{ f6 = f.addfarmerbyid(fid);
		return f6;
		
	}*/
	
	
	@GetMapping("/farmerproducts")
	public List<product> getFarmerProdctDetails(){
		return f.fetchproductlist();
	}
}
