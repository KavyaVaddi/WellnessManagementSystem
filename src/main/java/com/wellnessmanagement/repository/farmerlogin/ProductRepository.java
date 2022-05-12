package com.wellnessmanagement.repository.farmerlogin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellnessmanagement.model.login.product;

public interface ProductRepository extends JpaRepository<product,Integer> {

}
