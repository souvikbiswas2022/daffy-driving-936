package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;

public class FileDisputeUseCase {

	public static void fileDisputeUseCase() {

        Scanner sc = new Scanner(System.in);
        
		System.out.println("< < Enter the Item id > >");
		int itemid=sc.nextInt();
		

		sc.nextLine();
		System.out.println("< < Write your cause .... > > ");
		String disReason = sc.nextLine();
		
		
		BuyerDao bd = new BuyerDaoImpl();
		
		String message = bd.fileDispute(itemid, disReason);
		
		System.out.println(message);

	}

}
