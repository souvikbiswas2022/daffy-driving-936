package com.masai.bean;

public class SoldItem {

	
	private String itemName;
	private String buyerName;
	private String sellerName;
	
	
	public SoldItem(String itemName, String buyerName, String sellerName) {
		super();
		this.itemName = itemName;
		this.buyerName = buyerName;
		this.sellerName = sellerName;
	}


	public SoldItem() {
		super();

	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}





	public String getBuyerName() {
		return buyerName;
	}


	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}


	public String getSellerName() {
		return sellerName;
	}


	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}



	
	
	
	
	
	
	
	
}
