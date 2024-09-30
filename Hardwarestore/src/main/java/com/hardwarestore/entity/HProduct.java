package com.hardwarestore.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table
public class HProduct {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pid;
	private String pUniqueId;
	private String pName;
	private List<String> pTag;
	private long pQuantity;
	private long pPrice;
	private long pBasePrice;
	private long pUnit;
	private String pCategory;
	private long pCategoryUniqueId;
	private String pImage;
	
	
	
	public long getpBasePrice() {
		return pBasePrice;
	}



	public void setpBasePrice(long pBasePrice) {
		this.pBasePrice = pBasePrice;
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



	public String getpName() {
		return pName;
	}



	public void setpName(String pName) {
		this.pName = pName;
	}



	public List<String> getpTag() {
		return pTag;
	}



	public void setpTag(List<String> pTag) {
		this.pTag = pTag;
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



	public long getpUnit() {
		return pUnit;
	}



	public void setpUnit(long pUnit) {
		this.pUnit = pUnit;
	}



	public String getpCategory() {
		return pCategory;
	}



	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}



	public long getpCategoryUniqueId() {
		return pCategoryUniqueId;
	}



	public void setpCategoryUniqueId(long pCategoryUniqueId) {
		this.pCategoryUniqueId = pCategoryUniqueId;
	}



	public String getpImage() {
		return pImage;
	}



	public void setpImage(String pImage) {
		this.pImage = pImage;
	}



	



	public HProduct(long pid, String pUniqueId, String pName, List<String> pTag, long pQuantity, long pPrice,
			long pBasePrice, long pUnit, String pCategory, long pCategoryUniqueId, String pImage) {
		super();
		this.pid = pid;
		this.pUniqueId = pUniqueId;
		this.pName = pName;
		this.pTag = pTag;
		this.pQuantity = pQuantity;
		this.pPrice = pPrice;
		this.pBasePrice = pBasePrice;
		this.pUnit = pUnit;
		this.pCategory = pCategory;
		this.pCategoryUniqueId = pCategoryUniqueId;
		this.pImage = pImage;
	}



	public HProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
