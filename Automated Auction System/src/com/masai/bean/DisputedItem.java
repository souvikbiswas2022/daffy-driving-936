package com.masai.bean;

public class DisputedItem {

	private int itemId;
	private String disputeCause;
	private String status;
	
	
	public DisputedItem(int itemId, String disputeCause, String status) {
		super();
		this.itemId = itemId;
		this.disputeCause = disputeCause;
		this.status = status;
	}
	
	
	public DisputedItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getDisputeCause() {
		return disputeCause;
	}
	public void setDisputeCause(String disputeCause) {
		this.disputeCause = disputeCause;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "DisputedItem [itemId=" + itemId + ", disputeCause=" + disputeCause + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
}
