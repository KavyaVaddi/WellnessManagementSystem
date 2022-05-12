package com.wellnessmanagement.repository.trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellnessmanagement.model.TraderProducts;

@Repository
public interface TraderProductsRepository extends JpaRepository<TraderProducts,Integer> {

}