package com.wellnessmanagement.service;

import java.util.List;

import com.wellnessmanagement.model.Admin;


public interface AdminService {
	Admin addNewAdmin(Admin admin);
	
	List<Admin> getAllAdmins();
	
	Admin updateAdmin(Integer id, Admin book);
	
	void deleteAdmin(Integer id);
	
	Admin getById(Integer id);

	boolean existsById(Integer aid);
}
