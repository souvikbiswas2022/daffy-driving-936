package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class UpdateQuantityUseCase {

	public static void main(String[] args) {
	
		
		Scanner sc=new Scanner(System.in);
		System.out.println("< < Enter the Item Id  > >");
		int itemId=sc.nextInt();
		
		System.out.println("< < Enter the new Quantity  > >");
		int newQuantity=sc.nextInt();
		
		
		SellerDao sd=new SellerDaoImpl();
		
		String message=sd.updateQuantity(itemId, newQuantity);
		
		System.out.println(message);

	}

}
