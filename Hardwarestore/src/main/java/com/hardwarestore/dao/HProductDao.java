package com.hardwarestore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hardwarestore.entity.HProduct;

public interface HProductDao extends JpaRepository<HProduct, Long>{

	
	@Query("select b from HProduct b")
	List<HProduct> getAll();

	
	@Query("select b from HProduct b where b.pUniqueId= :n")
	HProduct getByPuniqueId(@Param("n")String pUniqueId);


	@Query("select b from HProduct b where b.pName LIKE %?1%"
			+ " OR b.pCategory LIKE %?1%")
	List<HProduct> getALlProductBykeyword(String keyword);


	@Query("select b from HProduct b where b.pName= :n")
	HProduct getBypname(@Param("n")String pName);

}
