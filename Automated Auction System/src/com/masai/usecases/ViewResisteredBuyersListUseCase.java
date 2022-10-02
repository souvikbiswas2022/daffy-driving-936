package com.masai.usecases;

import java.util.ArrayList;

import com.masai.bean.Buyer;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exceptions.BuyerException;

public class ViewResisteredBuyersListUseCase {

	public static void viewResisteredBuyersListUseCase () {
		
		AdminDao ad = new AdminDaoImpl();
		
		ArrayList<Buyer> buyers;
		try {
			buyers = ad.getBuyers();
			
			System.out.println("                                        List of Buyers   ");
			System.out.println("...............................................................................................................");
			System.out.println("     Name                                Email                            Pan No");
			System.out.println("...............................................................................................................");
			
			for(Buyer b:buyers) {
				
				System.out.println(b.getName()+"               "+b.getEmail() +"               "+  b.getPan());
				
			}
		} catch (BuyerException e) {
		
			System.out.println(e.getMessage());
		}
		
	

	}

}
