package com.masai.dao;

import java.util.List;

import com.masai.bean.Item;
import com.masai.bean.Seller;

public interface SellerDao {

	
		public String resisterSeller(Seller s);
		public String resisterItems(List<Item> i);
	
	
	
	
}
