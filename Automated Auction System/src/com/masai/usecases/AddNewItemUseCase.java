package com.masai.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import com.masai.bean.Item;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class AddNewItemUseCase {

	public static void addNewItemUseCase() {
	
		
       Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("< <  How many items you want to add > >");
		int noOfItems = sc.nextInt();
		
		ArrayList<Item> items=new ArrayList<>();
		
		for(int i=0;i<noOfItems;i++) {
			System.out.println("Item no : "+(i+1));
			sc.nextLine();
			System.out.println("< < Enter Item Name > >");
			String itemName = sc.nextLine();
			
			System.out.println("< <  Enter Item Category > >");
			String itemCategory = sc.nextLine();
			
			System.out.println("< <  Enter Quantity    > >");
			int  quantity = sc.nextInt();
			
			System.out.println("< < Enter Base Price  > >");
			double  basePrice = sc.nextDouble();
			

			items.add(new Item(LoginSellerUserCase.logedIn.getId(),itemName,itemCategory,basePrice,quantity));
			
		}
		
		SellerDao sd=new SellerDaoImpl();
	
       String message= sd.resisterItems(items);
        
        System.out.println(message);

	}

}
