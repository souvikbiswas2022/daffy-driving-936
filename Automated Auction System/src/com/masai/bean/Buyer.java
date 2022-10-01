package com.masai.bean;

public class Buyer {

	private int buyerId;
	private String name;
	private String email;
	private String pan;
	private String password;
	
	
	public Buyer() {
		super();

	}


	public Buyer(String name, String email, String pan, String password) {
		super();
		this.name = name;
		this.email = email;
		this.pan = pan;
		this.password = password;
	}


	public Buyer(int buyerId, String name, String email, String pan, String password) {
		super();
		this.buyerId = buyerId;
		this.name = name;
		this.email = email;
		this.pan = pan;
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}


	@Override
	public String toString() {
		return "Buyer [name=" + name + ", email=" + email + ", pan=" + pan + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	

}
