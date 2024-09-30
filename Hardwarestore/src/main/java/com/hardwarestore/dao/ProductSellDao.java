package com.hardwarestore.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hardwarestore.entity.ProductSell;

public interface ProductSellDao extends JpaRepository<ProductSell, Long>{

	@Query("select b from ProductSell b")
	List<ProductSell> getAll();

	
	@Query("select u from ProductSell u where u.SellDateadded BETWEEN :n AND :n1")
	List<ProductSell> getAllbyweek(@Param("n")Date start,@Param("n1") Date end);

}
