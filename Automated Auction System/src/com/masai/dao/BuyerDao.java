package com.masai.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.masai.bean.Admin;
import com.masai.bean.Buyer;
import com.masai.bean.Item;

public interface BuyerDao {

	
public String resisterBuyer(Buyer b);


public ArrayList<String> getAllCategory();


public ArrayList<Item> getItemListCategoryWaise(String category);
	

//public Map<String,ArrayList<Item>> sellerItemsCategoryWaise(int sellerId);

public Map<String,ArrayList<Item>> buyerItems();

public Buyer loginBuyer(String email, String password);
	
}
