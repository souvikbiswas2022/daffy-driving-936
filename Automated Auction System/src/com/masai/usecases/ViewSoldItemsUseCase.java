package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Item;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;
import com.masai.exceptions.ItemException;

public class ViewSoldItemsUseCase {

	public static void viewSoldItems() {
	

	
	SellerDao sd = new SellerDaoImpl();
	
	List<Item> soldItems;
	try {
		soldItems = sd.getSoldItems(LoginSellerUserCase.logedIn.getId());
		for(int i=0;i<soldItems.size();i++) {
			System.out.println("Item : "+(i+1));
			 System.out.println("Item Name : "+soldItems.get(i).getItemName());
			 System.out.println("Item Base price : "+soldItems.get(i).getBasePrice());
				
			}
	} catch (ItemException e) {
	
	System.out.println(e.getMessage());
	}
	

	}

}
