package com.masai.dao;

import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Buyer;
import com.masai.bean.Item;
import com.masai.bean.Seller;

public interface AdminDao {

	
	public String resisterAdmin(Admin a);
	public ArrayList<Buyer> getBuyers();
    public ArrayList<Seller> getSellers();
    public ArrayList<Item> getAllItems(); 
    
    public Admin loginAdmin(String email, String password);

}
