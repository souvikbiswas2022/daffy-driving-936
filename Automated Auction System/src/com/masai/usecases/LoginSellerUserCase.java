package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Seller;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;
import com.masai.exceptions.SellerException;

public class LoginSellerUserCase {

	
		public static boolean loginSellerUserCase() {
      
			boolean status  = false;
	   Scanner sc = new Scanner(System.in);
	   
	   SellerDao sd = new SellerDaoImpl();
	   
	   System.out.println("< < Enter your email  > >");
	   String email = sc.next();
	   
	   System.out.println("< < Enter your password > >");
	   String password = sc.next();
	   
	   
	   Seller seller;
	try {
		seller = sd.loginSeller(email, password);
		   System.out.println("Welcome "+seller.getName());
		   status  = true;
	} catch (SellerException e) {

	System.out.println(e.getMessage());
	}
	   
	
    
	   return status;
	}

}
