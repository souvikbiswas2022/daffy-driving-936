package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class DisputeResolveUseCase {

	public static void disputeResolveUseCase() {
		
		
		
		
		
	Scanner sc = new Scanner(System.in); 
	System.out.println("< < Enter the item id > >");
	int itemId = sc.nextInt();
		
		
		AdminDao ad = new AdminDaoImpl();
		
		String message = ad.solveDispute(itemId);

		System.out.println(message);

	}

}
