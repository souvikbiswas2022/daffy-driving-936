package com.masai.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.masai.bean.Admin;
import com.masai.bean.Buyer;
import com.masai.bean.Item;
import com.masai.exceptions.BuyerException;
import com.masai.exceptions.ItemException;

public interface BuyerDao {

	
public String resisterBuyer(Buyer b);

public ArrayList<String> getAllCategory() throws ItemException;

public ArrayList<Item> getItemListCategoryWaise(String category)  throws ItemException ;
	
public Map<String,ArrayList<Item>> buyerItems() ;

public Buyer loginBuyer(String email, String password)  throws BuyerException;


public ArrayList<Item> runningAuctionItemList() throws ItemException;


String bidding(int buyerId, double bidPrice,int itemId);
	
}
