package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Buyer;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;
import com.masai.exceptions.AdminException;

public class ResisterAdminUseCase {

	public static boolean resisterAdminUseCase() {
    
		boolean status = true;
		String message = null;
		
		
	Scanner sc = new Scanner(System.in);
		
		System.out.println("< < Enter your name > >");
		String name = sc.nextLine();
		
		System.out.println("< < Enter your email > >");
		String email = sc.next();
		
		System.out.println("< < Enter password  > >");
		String password = sc.next();
		
		
		AdminDao bd = new AdminDaoImpl();
		

		
		try {
			
			message = bd.resisterAdmin(new Admin(name,email,password));
			
		} catch (AdminException e) {
			
		    status = false;
		    
		System.out.println(e.getMessage());
		
		}

		System.out.println(message);
    
      
      return status;
		
		
	}

}
