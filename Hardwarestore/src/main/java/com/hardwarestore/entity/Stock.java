package com.hardwarestore.entity;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table
public class Stock {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pid;
	private String pUniqueId;
	private String pName;
	
	private String pCategory;
	private String pImage;
	@ElementCollection(targetClass=String.class,fetch =FetchType.EAGER)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<StockUnit> stockunit; 
	
	
	
	
	
	
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






	public String getpName() {
		return pName;
	}






	public void setpName(String pName) {
		this.pName = pName;
	}






	public String getpCategory() {
		return pCategory;
	}






	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}






	public String getpImage() {
		return pImage;
	}






	public void setpImage(String pImage) {
		this.pImage = pImage;
	}






	public List<StockUnit> getStockunit() {
		return stockunit;
	}






	public void setStockunit(List<StockUnit> stockunit) {
		this.stockunit = stockunit;
	}






	public Stock(long pid, String pUniqueId, String pName, String pCategory, String pImage, List<StockUnit> stockunit) {
		super();
		this.pid = pid;
		this.pUniqueId = pUniqueId;
		this.pName = pName;
		this.pCategory = pCategory;
		this.pImage = pImage;
		this.stockunit = stockunit;
	}






	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
