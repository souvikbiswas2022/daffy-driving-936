package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Buyer;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;

public class ResisterAdminUseCase {

	public static boolean resisterAdminUseCase() {
    
		boolean status = false;
		
	Scanner sc = new Scanner(System.in);
		
		System.out.println("< < Enter your name > >");
		String name = sc.nextLine();
		
		System.out.println("< < Enter your email > >");
		String email = sc.next();
		
		System.out.println("< < Enter password  > >");
		String password = sc.next();
		
		
		AdminDao bd = new AdminDaoImpl();
		
	
		String message = bd.resisterAdmin(new Admin(name,email,password));

		System.out.println(message);
      status = true;
      
      return status;
		
		
	}

}
