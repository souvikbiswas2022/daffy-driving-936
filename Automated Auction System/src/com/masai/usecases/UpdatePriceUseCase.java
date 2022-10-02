package com.masai.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import com.masai.bean.Item;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;
import com.masai.exceptions.ItemException;

public class UpdatePriceUseCase {

	public static void updatePriceUseCase() {
		
	
		SellerDao sd=new SellerDaoImpl();
		
		try {
			
			ArrayList<Item> ownItems = sd.sellerOwnItems(LoginSellerUserCase.logedIn.getId());
			int no =1;
			for(Item i:ownItems) {
				System.out.println("-----------------"+no+"------------------------");
				System.out.println("Item name : "+i.getItemName());
				System.out.println("Current price : "+i.getBasePrice());
				no++;
				
			}
			
			
			Scanner sc=new Scanner(System.in);
		       System.out.println("< < Select Item  > >");
		       int itemNo=sc.nextInt();
				
				System.out.println("< < Enter the new Base price  > >");
				double newBasePrice=sc.nextDouble();
				

				String message=sd.updatePrice(ownItems.get(itemNo-1).getItemId(), newBasePrice);
				
				System.out.println(message);

		} catch (ItemException e) {
		
			e.printStackTrace();
		}
		
		
		
	
		

	}

}
