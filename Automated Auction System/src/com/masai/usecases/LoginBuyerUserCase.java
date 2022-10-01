package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Buyer;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;

public class LoginBuyerUserCase {

	public static boolean  loginBuyerUserCase() {
		
	boolean status = false;
			   Scanner sc = new Scanner(System.in);
			   
			   BuyerDao bd = new BuyerDaoImpl();
			   
			   System.out.println("< < Enter your email  > >");
			   String email = sc.next();
			   
			   System.out.println("< < Enter your password > >");
			   String password = sc.next();
			   
			   
			   Buyer buyer = bd.loginBuyer(email, password);
			   
			   System.out.println("Welcome "+buyer.getName());
			   System.out.println("Buyer id : "+buyer.getBuyerId());
			   status = true;
	
			   return status;
	}

}
