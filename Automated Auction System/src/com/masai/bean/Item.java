package com.masai.bean;

public class Item {

	private int  salerId;
	private int itemId;
	private String itemName;
	private String  category;
	private double basePrice;
	private int quantity;
	
	
	private String Itemstatus;
	private String soldDate;
	private double soldPrice;
	private String startDate;
	private String endDate;
	private String auctionStatus;
	private int buyerId;
	
	
	public Item() {
		super();
	}


	public Item(int salerId, String itemName, String category, double basePrice, int quantity) {
		super();
		this.salerId = salerId;
		this.itemName = itemName;
		this.category = category;
		this.basePrice = basePrice;
		this.quantity = quantity;
	}


	public int getSalerId() {
		return salerId;
	}


	public void setSalerId(int salerId) {
		this.salerId = salerId;
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


	public String getSoldDate() {
		return soldDate;
	}


	public void setSoldDate(String soldDate) {
		this.soldDate = soldDate;
	}


	public double getSoldPrice() {
		return soldPrice;
	}


	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
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
		return "Item [salerId=" + salerId + ", itemId=" + itemId + ", itemName=" + itemName + ", category=" + category
				+ ", basePrice=" + basePrice + ", quantity=" + quantity + ", Itemstatus=" + Itemstatus + ", soldDate="
				+ soldDate + ", soldPrice=" + soldPrice + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", auctionStatus=" + auctionStatus + ", buyerId=" + buyerId + "]";
	}
	
	
	
	
	
	
	
	
}
