package com.wellnessmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

import com.wellnessmanagement.exception.ResourceNotFoundException;
import com.wellnessmanagement.model.Admin;
import com.wellnessmanagement.model.login.farmer;
import com.wellnessmanagement.model.login.product;
import com.wellnessmanagement.service.AdminService;
import com.wellnessmanagement.service.login.FarmerService;

@RestController
@RequestMapping("/wellness")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admins")
	public ResponseEntity<?> getAllAdmins() {
		if (adminService.getAllAdmins().isEmpty())
			return new ResponseEntity<>("No records found!", HttpStatus.OK);
		else
			return new ResponseEntity<>(adminService.getAllAdmins(), HttpStatus.OK);
	}
	
	@PostMapping("/admins/add")
	public ResponseEntity<?> addNewAdmin(@RequestBody Admin admin) {
		try {
			if (adminService.existsById(admin.getAid()))
				return new ResponseEntity<>(
						"Admin with ID: " + admin.getAid() + " exists already! Please provide an unique ID.",
						HttpStatus.OK);
			else
				return new ResponseEntity<>(adminService.addNewAdmin(admin), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Please check the input and format.", HttpStatus.OK);
		}
	}
	
	@PutMapping("/admins/update/{id}")
	public ResponseEntity<?> updateAdmin(@PathVariable(value = "id") Integer id, @Valid @RequestBody Admin admin) {
		try {
			return new ResponseEntity<>(adminService.updateAdmin(id, admin), HttpStatus.OK);
		} catch (NoSuchElementException noSuchElement) {
			return new ResponseEntity<>("Admin with ID: " + id + " not found!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/admins/delete/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable(value="id") Integer id) {
		try {
			adminService.deleteAdmin(id);
			return new ResponseEntity<>("Successfully deleted Student with ID as " + id, HttpStatus.OK);
		} catch (EmptyResultDataAccessException emptyResultData) {
			return new ResponseEntity<>("Admin with ID " + id + " not found!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/admins/{id}")
	public ResponseEntity<?> getById(@PathVariable(value="id") Integer id) {
		try {
			return new ResponseEntity<>(adminService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("Admin with ID " + id + " not found!").getMessage(), HttpStatus.OK);
		}
	}
	
	//Admin-Farmer Controller After registering and logging in
	
	@Autowired
	FarmerService f;
	
	
	@GetMapping("/admin/hello")
	public String hello(){
		return "hello";
		}

	@GetMapping("/admin/getdetails/{fid}/{password}")
	public List<farmer> getlist(@PathVariable(value = "fid") Integer fid,@PathVariable(value = "password") String password){
		boolean b = f.loginfarmer(fid,password );
		if(b==true) {
			return f.fetchdetails();
		}
		else {return null;}
	}
	
	@PostMapping("/admin/addfarmers")
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
	/*@PostMapping("/admin/addbyid")
	public farmer addfarmerbyid(@RequestBody farmer f6,@PathVariable(value = "fid") Integer fid)
	{ f6 = f.addfarmerbyid(fid);
		return f6;
		
	}*/
	
	
	@GetMapping("/admin/farmerproducts")
	public List<product> getFarmerProdctDetails(){
		return f.fetchproductlist();
	}
	
	

}
