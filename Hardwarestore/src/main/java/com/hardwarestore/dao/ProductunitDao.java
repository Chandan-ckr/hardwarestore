package com.hardwarestore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hardwarestore.entity.ProductUnit;

public interface ProductunitDao extends JpaRepository<ProductUnit, Long>{

	
	@Query("select b from ProductUnit b where b.pUniqueId= :n")
	ProductUnit getByPuniqueId(@Param("n")String pUniqueId);

	@Query("select b from ProductUnit b where b.pUniqueId= :n")
	List<ProductUnit> getByPuniqueIds(@Param("n")String pUniqueId);

	@Query("select b from ProductUnit b where b.pUniqueId= :n and b.pUnit=:k")
	ProductUnit getByPuniqueIdsUnit(@Param("n")String pUniqueId, @Param("k")long unit);

	@Query("select b from ProductUnit b where b.pUniqueId= :n and b.pUnit=:n1")
	ProductUnit getByPuniqueIdandunit(@Param("n")String pUniqueId, @Param("n1")long pUnit);

}
