package com.masai.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import com.masai.bean.Item;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class AddNewItemUseCase {

	public static void main(String[] args) {
	
		
Scanner sc = new Scanner(System.in);
		
		System.out.println("< < Enter your id > >");
		int sellerId = sc.nextInt();
		
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
			
			System.out.println("< < Enter Base Price  > >");
			double  basePrice = sc.nextDouble();
			
			System.out.println("< <  Enter Quantity    > >");
			int  quantity = sc.nextInt();
			
			
			items.add(new Item(sellerId,itemName,itemCategory,basePrice,quantity));
			
		}
		
		SellerDao sd=new SellerDaoImpl();
	
       String message= sd.resisterItems(items);
        
        System.out.println(message);
		
		
		
		
		
		

	}

}
