package com.hardwarestore.entity;

import java.util.List;

public class StockUnit {
	
	private long pBaseQuantity;
	private long pQuantity;
	private long pUnit;
	private String percentage;
	public long getpBaseQuantity() {
		return pBaseQuantity;
	}
	public void setpBaseQuantity(long pBaseQuantity) {
		this.pBaseQuantity = pBaseQuantity;
	}
	public long getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(long pQuantity) {
		this.pQuantity = pQuantity;
	}
	public long getpUnit() {
		return pUnit;
	}
	public void setpUnit(long pUnit) {
		this.pUnit = pUnit;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public StockUnit(long pBaseQuantity, long pQuantity, long pUnit, String percentage) {
		super();
		this.pBaseQuantity = pBaseQuantity;
		this.pQuantity = pQuantity;
		this.pUnit = pUnit;
		this.percentage = percentage;
	}
	public StockUnit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
