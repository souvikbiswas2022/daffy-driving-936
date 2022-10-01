package com.masai.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import com.masai.bean.Item;
import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;

public class ItemsCategoryWaiseUseCase {

	public static void itemsCategoryWaiseUseCase() {
	
         Scanner sc = new Scanner(System.in);
		
		BuyerDao bd = new BuyerDaoImpl();
		
		ArrayList<String> allCategories = bd.getAllCategory();
		
		System.out.println("-  -  -  List of all categories  -  -   - ");
		for(int i = 0;i < allCategories.size(); i++) {
			
		System.out.println((i+1)+" . "+allCategories.get(i));
			
		}
	// ----	
		System.out.println("< < Select your choice > >");
		int choice = sc.nextInt();
		
		ArrayList<Item> items = bd.getItemListCategoryWaise(allCategories.get(choice - 1));
		
		for(int i=0;i<items.size();i++) {
			System.out.println("Item : "+(i+1));
			 System.out.println("Item Name : "+items.get(i).getItemName());
			 System.out.println("Item Base price : "+items.get(i).getBasePrice());
				
			 System.out.println();
			}
		
		
	}

}
