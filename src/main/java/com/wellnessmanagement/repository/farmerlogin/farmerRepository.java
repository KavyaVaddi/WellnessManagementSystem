package com.wellnessmanagement.repository.farmerlogin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellnessmanagement.model.login.farmer;

public interface farmerRepository extends JpaRepository<farmer,Integer> {

}
