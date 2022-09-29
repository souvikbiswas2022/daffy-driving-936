package com.masai.bean;

import java.sql.Date;

import javax.xml.crypto.Data;

public class Item {

	private int  sallerId;
	private int itemId;
	private String itemName;
	private String  category;
	private double basePrice;
	private int quantity;
	
	
	private String Itemstatus;
	private Date soldDate;
	private double soldPrice;
	private Date startDate;
	private Date endDate;
	private String auctionStatus;
	private int buyerId;
	
	
	public Item() {
		super();
	}


	public Item(int sallerId, String itemName, String category, double basePrice, int quantity) {
		super();
		this.sallerId = sallerId;
		this.itemName = itemName;
		this.category = category;
		this.basePrice = basePrice;
		this.quantity = quantity;
	}


	public Item(int sallerId, int itemId, String itemName, String category, double basePrice, int quantity,
			String itemstatus, Date soldDate, double soldPrice, Date startDate, Date endDate,
			String auctionStatus, int buyerId) {
		super();
		this.sallerId = sallerId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.basePrice = basePrice;
		this.quantity = quantity;
		Itemstatus = itemstatus;
		this.soldDate = soldDate;
		this.soldPrice = soldPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.auctionStatus = auctionStatus;
		this.buyerId = buyerId;
	}







	public int getSalerId() {
		return sallerId;
	}


	public void setSalerId(int salerId) {
		this.sallerId = salerId;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getBasePrice() {
		return basePrice;
	}


	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getItemstatus() {
		return Itemstatus;
	}


	public void setItemstatus(String itemstatus) {
		Itemstatus = itemstatus;
	}


	public Date getSoldDate() {
		return soldDate;
	}


	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}


	public double getSoldPrice() {
		return soldPrice;
	}


	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getAuctionStatus() {
		return auctionStatus;
	}


	public void setAuctionStatus(String auctionStatus) {
		this.auctionStatus = auctionStatus;
	}


	public int getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}


	@Override
	public String toString() {
		return "Item [sallerId=" + sallerId + ", itemId=" + itemId + ", itemName=" + itemName + ", category=" + category
				+ ", basePrice=" + basePrice + ", quantity=" + quantity + ", Itemstatus=" + Itemstatus + ", soldDate="
				+ soldDate + ", soldPrice=" + soldPrice + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", auctionStatus=" + auctionStatus + ", buyerId=" + buyerId + "]";
	}
	
	
	
	
	
	
	
	
}
