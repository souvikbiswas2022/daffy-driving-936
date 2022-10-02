package com.masai.dao;

import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.BidItem;
import com.masai.bean.Buyer;
import com.masai.bean.DisputedItem;
import com.masai.bean.Item;
import com.masai.bean.Seller;
import com.masai.bean.SoldItem;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.BuyerException;
import com.masai.exceptions.ItemException;
import com.masai.exceptions.SellerException;
import com.masai.exceptions.SoldItemException;

public interface AdminDao {

	
	public String resisterAdmin(Admin a) throws AdminException;
	
	public ArrayList<Buyer> getBuyers() throws BuyerException;
	
    public ArrayList<Seller> getSellers() throws SellerException;
    
    public ArrayList<Item> getAllItems() throws ItemException; 
    
    public Admin loginAdmin(String email, String password) throws AdminException;
    
   public void algoBid();
   
   public ArrayList<DisputedItem> getDisputeReport(); 
   
   public String solveDispute(int itemid);
   
    public ArrayList<SoldItem> getDailySellingReport() throws SoldItemException;
    
   
    
}
