package com.masai.dao;

import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Buyer;
import com.masai.bean.Item;
import com.masai.bean.Seller;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.BuyerException;
import com.masai.exceptions.ItemException;
import com.masai.exceptions.SellerException;

public interface AdminDao {

	
	public String resisterAdmin(Admin a);
	public ArrayList<Buyer> getBuyers() throws BuyerException;
    public ArrayList<Seller> getSellers() throws SellerException;
    public ArrayList<Item> getAllItems() throws ItemException; 
    
    public Admin loginAdmin(String email, String password) throws AdminException;

   public void algoBid();
    
    
    
}
