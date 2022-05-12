package com.wellnessmanagement.repository.farmer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellnessmanagement.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
