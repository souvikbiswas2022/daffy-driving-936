package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Seller;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;
import com.masai.exceptions.SellerException;

public class ResisterSellerUseCase {

	public static boolean resisterSellerUseCase() {
		
		boolean status = true;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("< < Enter your name > >");
		String name=sc.nextLine();
		
		System.out.println("< < Enter your email > >");
		String email=sc.next();
		
		System.out.println("< < Enter your Pan No  > >");
		String panNo=sc.next();
		
		System.out.println("< < Creat Password > >");
		String password=sc.next();
		
		Seller s=new Seller(name,email,panNo,password);
		
		SellerDao sd=new SellerDaoImpl();
		
		String message;
		
		
		try {
			
			message = sd.resisterSeller(s);
			System.out.println(message);
			
		} catch (SellerException e) {
		
		System.out.println(e.getMessage());
		status = false;
		
		}
		
		

       return status;
	}

}
