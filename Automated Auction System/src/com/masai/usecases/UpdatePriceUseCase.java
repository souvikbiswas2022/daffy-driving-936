package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class UpdatePriceUseCase {

	public static void updatePriceUseCase() {
		Scanner sc=new Scanner(System.in);
		System.out.println("< < Enter the Item Id  > >");
		int itemId=sc.nextInt();
		
		System.out.println("< < Enter the new Base price  > >");
		double newBasePrice=sc.nextDouble();
		
		
		SellerDao sd=new SellerDaoImpl();
		
		String message=sd.updatePrice(itemId, newBasePrice);
		
		System.out.println(message);
		

	}

}
