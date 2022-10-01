package com.masai.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import com.masai.bean.Item;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class RemoveItemUseCase {

	public static void removeItemUseCase() {

        Scanner sc = new Scanner(System.in);
		
		System.out.println("< < Enter item id > >");
		int itemId = sc.nextInt();
		

		SellerDao sd=new SellerDaoImpl();
	
       String message= sd.removeItem(itemId);
        System.out.println(message);	

	}

}
