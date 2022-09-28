package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Seller;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class ResisterSellerUseCase {

	public static void main(String[] args) {
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
		
		String message=sd.resisterSeller(s);
		
		System.out.println(message);
		

	}

}
