package com.wellnessmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellnessmanagement.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
