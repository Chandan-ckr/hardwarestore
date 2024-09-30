package com.hardwarestore.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table
public class PCategory {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pid;
	private String categoryName;
	private String cImage;
	private long puniqueId;
	
	
	public long getPuniqueId() {
		return puniqueId;
	}
	public void setPuniqueId(long puniqueId) {
		this.puniqueId = puniqueId;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getcImage() {
		return cImage;
	}
	public void setcImage(String cImage) {
		this.cImage = cImage;
	}
	
	public PCategory(long pid, String categoryName, String cImage, long puniqueId) {
		super();
		this.pid = pid;
		this.categoryName = categoryName;
		this.cImage = cImage;
		this.puniqueId = puniqueId;
	}
	public PCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
