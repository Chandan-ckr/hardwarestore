package com.hardwarestore.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Component
@Table
public class ProductSell {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pid;
	private String pUniqueId;
	private long pQuantity;
	private long pPrice;
	private long pBasePrice;
	private long pUnit; 
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date SellDateadded;
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
	public long getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(long pQuantity) {
		this.pQuantity = pQuantity;
	}
	public long getpPrice() {
		return pPrice;
	}
	public void setpPrice(long pPrice) {
		this.pPrice = pPrice;
	}
	public long getpBasePrice() {
		return pBasePrice;
	}
	public void setpBasePrice(long pBasePrice) {
		this.pBasePrice = pBasePrice;
	}
	public long getpUnit() {
		return pUnit;
	}
	public void setpUnit(long pUnit) {
		this.pUnit = pUnit;
	}
	public Date getSellDateadded() {
		return SellDateadded;
	}
	public void setSellDateadded(Date sellDateadded) {
		SellDateadded = sellDateadded;
	}
	public ProductSell(long pid, String pUniqueId, long pQuantity, long pPrice, long pBasePrice, long pUnit,
			Date sellDateadded) {
		super();
		this.pid = pid;
		this.pUniqueId = pUniqueId;
		this.pQuantity = pQuantity;
		this.pPrice = pPrice;
		this.pBasePrice = pBasePrice;
		this.pUnit = pUnit;
		SellDateadded = sellDateadded;
	}
	public ProductSell() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
