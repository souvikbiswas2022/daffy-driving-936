package com.masai.dao;

import java.util.List;

import com.masai.bean.Item;
import com.masai.bean.Seller;

public interface SellerDao {

	
		public String resisterSeller(Seller s);
		public String resisterItems(List<Item> i);
		public String updatePrice(int itemid, Double newPrice);
	   public String updateQuantity(int itemid, int newQuantity);
	    public String AddNewItem(int sellerId,Item item);
	  public String removeItem(int itemid);
	   public List<Item> getSoldItems(int sellerid);
}
