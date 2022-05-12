package com.wellnessmanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellnessmanagement.model.Admin;
import com.wellnessmanagement.repository.AdminRepository;
import com.wellnessmanagement.service.AdminService;

@Service
public class AdminServiceImplementation implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	

	public AdminServiceImplementation(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin addNewAdmin(Admin admin) {
		return this.adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin updateAdmin(Integer id, Admin newadmin) {
		Admin oldadmin= getById(id);
		oldadmin.setAname(newadmin.getAname());
		oldadmin.setAaddress(newadmin.getAaddress());
		oldadmin.setAphone(newadmin.getAphone());
		oldadmin.setAmailid(newadmin.getAmailid());
		oldadmin.setApassword(newadmin.getApassword());
		Admin updtad= adminRepository.save(oldadmin);
		return updtad;
	}

	@Override
	public void deleteAdmin(Integer id) {
		adminRepository.deleteById(id);		
	}

	@Override
	public Admin getById(Integer id) {
		return adminRepository.findById(id).get();
	}

	@Override
	public boolean existsById(Integer aid) {
		return adminRepository.existsById(aid);
	}

}
