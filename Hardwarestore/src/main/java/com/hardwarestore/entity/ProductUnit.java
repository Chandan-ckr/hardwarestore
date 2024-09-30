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
public class ProductUnit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pid;
	private String pUniqueId;
	private long pUnit;
	private long pPrice;
	private long pBasePrice;
	private long pQuantity;
	private long pActualQuantity;
	
	
	
	public long getpActualQuantity() {
		return pActualQuantity;
	}
	public void setpActualQuantity(long pActualQuantity) {
		this.pActualQuantity = pActualQuantity;
	}
	public long getpBasePrice() {
		return pBasePrice;
	}
	public void setpBasePrice(long pBasePrice) {
		this.pBasePrice = pBasePrice;
	}
	public long getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(long pQuantity) {
		this.pQuantity = pQuantity;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getpUniqueId() {
		return pUniqueId;
	}
	public void setpUniqueId(String pUniqueId) {
		this.pUniqueId = pUniqueId;
	}
	public long getpUnit() {
		return pUnit;
	}
	public void setpUnit(long pUnit) {
		this.pUnit = pUnit;
	}
	public long getpPrice() {
		return pPrice;
	}
	public void setpPrice(long pPrice) {
		this.pPrice = pPrice;
	}
	
	
	
	public ProductUnit(long pid, String pUniqueId, long pUnit, long pPrice, long pBasePrice, long pQuantity,
			long pActualQuantity) {
		super();
		this.pid = pid;
		this.pUniqueId = pUniqueId;
		this.pUnit = pUnit;
		this.pPrice = pPrice;
		this.pBasePrice = pBasePrice;
		this.pQuantity = pQuantity;
		this.pActualQuantity = pActualQuantity;
	}
	public ProductUnit() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
