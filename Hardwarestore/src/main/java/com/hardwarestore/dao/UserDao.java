package com.hardwarestore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hardwarestore.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

	@Query("select b from User b")
	List<User> getAll();
	
	@Query("select b from User b where b.uName= :n")
	User findByuname(@Param("n")String uname);
	
	

}
