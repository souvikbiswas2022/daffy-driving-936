package com.masai.usecases;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import com.masai.bean.Item;
import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;

public class SellerItemCategoryWaiseUseCase {

	public static void sellerItemCategoryWaiseUseCase() {
	
		BuyerDao bd = new BuyerDaoImpl();
		
		Map<String,ArrayList<Item>> items = bd.buyerItems();
		
       for(Entry<String, ArrayList<Item>> its: items.entrySet()) {
    	   
    	   System.out.println(its.getKey());
    	   System.out.println("---------------------");
    	   int no=1;
    	   
    	   for(Item it : its.getValue()) {
    		   System.out.println(no +". "+it.getItemName() + "      "+it.getCategory());
    		   no++;
    		   
    	   }
    	   
       }
		
	}

}
