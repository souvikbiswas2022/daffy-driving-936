package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Buyer;
import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;

public class ResisterBuyerUseCase {

	public static boolean  resisterBuyerUseCase() {
	
		boolean status = false;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("< < Enter your name > >");
		String name = sc.nextLine();
		
		System.out.println("< < Enter your email > >");
		String email = sc.next();
		
		System.out.println("< < Enter your pan number > >");
		String panNo = sc.next();
		
		System.out.println("< < Enter password  > >");
		String password = sc.next();
		
		
		BuyerDao bd = new BuyerDaoImpl();
		
	
		String message = bd.resisterBuyer(new Buyer(name,email,panNo,password));

		System.out.println(message);
		 status = true;
		 
		 
		 return status;
	}

}
