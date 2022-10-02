package com.masai.usecases;

import java.util.ArrayList;

import com.masai.bean.SoldItem;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exceptions.SoldItemException;

public class DailySellingReportuseCase {

	public static void dailySellingReportuseCase() {
		
		AdminDao ad = new AdminDaoImpl();
		
		ArrayList<SoldItem> soldItems;
		
		
		try {
			
			soldItems = ad.getDailySellingReport();
			
			for(SoldItem s:soldItems) {
				
				System.out.println("-----------------------------------------------");
				System.out.println("Item name :"+s.getItemName());
				System.out.println("Buyer name : "+s.getBuyerName());
				System.out.println("Seller name : "+s.getSellerName());
				
				
			}
			
		} catch (SoldItemException e) {

			System.out.println(e.getMessage());
			
		}
		
		

		
	}

}
