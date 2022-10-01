package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class LoginAdminUserCase {

	public static boolean loginAdmin() {
   boolean status = false;
   Scanner sc = new Scanner(System.in);
   
   AdminDao ad = new AdminDaoImpl();
   
   System.out.println("< < Enter your email  > >");
   String email = sc.next();
   
   System.out.println("< < Enter your password > >");
   String password = sc.next();
   
   
   Admin admin = ad.loginAdmin(email, password);
   status = true;
   System.out.println("Welcome "+admin.getName());
   status = true;
   return status;
   
	}

}
