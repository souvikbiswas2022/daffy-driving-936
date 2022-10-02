package com.masai.usecases;

import java.util.ArrayList;

import com.masai.bean.Buyer;
import com.masai.bean.Seller;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exceptions.SellerException;

public class ViewResisteredSellersListUseCase {

	public static void viewResisteredSellersListUseCase() {
		

		AdminDao ad = new AdminDaoImpl();
		
		ArrayList<Seller> sellers;
		try {
			sellers = ad.getSellers();
			
			
			System.out.println("                                        List of Sellers   ");
			System.out.println("...............................................................................................................");
			System.out.println("     Name                                     Email                                 Pan No");
			System.out.println("...............................................................................................................");
			
			for(Seller s:sellers) {
				
				System.out.println(s.getName()+"                        "+s.getEmail() +"                 "+  s.getPanNo());
				
			}
		} catch (SellerException e) {
			System.out.println(e.getMessage());
		}


	}

}
