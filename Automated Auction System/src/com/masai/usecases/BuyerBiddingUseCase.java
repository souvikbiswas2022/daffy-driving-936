package com.masai.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import com.masai.bean.Item;
import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;
import com.masai.exceptions.ItemException;

public class BuyerBiddingUseCase { 

	public static void buyerBiddingUseCase() {

		BuyerDao bd = new BuyerDaoImpl();
    
    
    try {
		ArrayList<Item>  items = bd.runningAuctionItemList();
		Scanner sc = new Scanner(System.in);
		
		
		
		
		System.out.println(" Item name     Base price");
		System.out.println("---------------------------------");
		int no =1;
		for(Item i:items) {
			
		System.out.println(no+". "+i.getItemName()+"  ---->  Rs. "+i.getBasePrice() );
		no++;

		}
		System.out.println();
		System.out.println("< < Select  item > >");
		int itemId = items.get(sc.nextInt()-1).getItemId();
		
		System.out.println("< < Enter your price  > >");
		double bidPrice = sc.nextDouble();
		
		System.out.println("< < Enter Buyer id > >");
		int bid = sc.nextInt();
		
		
		String message = bd.bidding(bid, bidPrice, itemId);
		
		System.out.println(message);
		
	} catch (ItemException e) {
//	e.printStackTrace();
		System.out.println(e.getMessage());
	
	}
    

	}

}
