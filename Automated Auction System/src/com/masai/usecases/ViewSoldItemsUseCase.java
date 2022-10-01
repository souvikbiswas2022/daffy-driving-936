package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Item;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class ViewSoldItemsUseCase {

	public static void viewSoldItems() {
	
    Scanner sc = new Scanner(System.in);

    System.out.println("< < Enter Seller Id > >");

	
	int sellerId = sc.nextInt();
	
	SellerDao sd = new SellerDaoImpl();
	
	List<Item> soldItems = sd.getSoldItems(sellerId);
	
	for(int i=0;i<soldItems.size();i++) {
	System.out.println("Item : "+(i+1));
	 System.out.println("Item Name : "+soldItems.get(i).getItemName());
	 System.out.println("Item Base price : "+soldItems.get(i).getBasePrice());
		
	}
		//if no sold item found then what will show?

	}

}
