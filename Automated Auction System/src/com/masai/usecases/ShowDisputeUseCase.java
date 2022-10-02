package com.masai.usecases;

import java.util.ArrayList;

import com.masai.bean.DisputedItem;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class ShowDisputeUseCase {

	public static void showDisputeUseCase() {

  AdminDao ad = new AdminDaoImpl();
		
		ArrayList<DisputedItem> disputedItems  = ad.getDisputeReport();
		int no = 1;
		
		System.out.println("Disputed Items List ");
		
		for(DisputedItem d:disputedItems) {
			System.out.println("------------------"+no+"----------------------");
			System.out.println("Item Id : "+d.getItemId());
			System.out.println("Cause : "+d.getDisputeCause());
			System.out.println("Status : "+  d.getStatus());
			no++;
		}
		


	}

}
