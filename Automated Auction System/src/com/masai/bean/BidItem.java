package com.masai.bean;

public class BidItem {

	
	private int bid;
	private double bidPrice;
	private int itemId;
	public BidItem(int bid, double bidPrice, int itemId) {
		super();
		this.bid = bid;
		this.bidPrice = bidPrice;
		this.itemId = itemId;
	}
	public BidItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	@Override
	public String toString() {
		return "BidItems [bid=" + bid + ", bidPrice=" + bidPrice + ", itemId=" + itemId + "]";
	}
	
	

}
