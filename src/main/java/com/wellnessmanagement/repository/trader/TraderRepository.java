package com.wellnessmanagement.repository.trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellnessmanagement.model.Trader;


@Repository
public interface TraderRepository extends JpaRepository<Trader,Integer> {

	
}