package com.masai.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import com.masai.bean.Item;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;
import com.masai.exceptions.ItemException;

public class UpdateQuantityUseCase {

	public static void updateQuantityUseCase() {
	
		SellerDao sd=new SellerDaoImpl();
		Scanner sc=new Scanner(System.in);
		try {
			ArrayList<Item> ownItems = sd.sellerOwnItems(LoginSellerUserCase.logedIn.getId());
			int no =1;
			for(Item i:ownItems) {
				System.out.println("-----------------"+no+"------------------------");
				System.out.println("Item name : "+i.getItemName());
				System.out.println("Item Id : "+i.getItemId());
				System.out.println("Current quantity : "+i.getQuantity());
				no++;
				
			}
			
			
			System.out.println("< < Select Item  > >");
			int itemNo=sc.nextInt();
			
			System.out.println("< < Enter the new Quantity  > >");
			int newQuantity=sc.nextInt();

			
			String message=sd.updateQuantity(ownItems.get(itemNo-1).getItemId(), newQuantity);
			
			System.out.println(message);
		}catch (ItemException e) {
		
			e.printStackTrace();
		}
		
		
		
	

	}

}
