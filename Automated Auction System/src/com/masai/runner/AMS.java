package com.masai.runner;

import java.util.Scanner;

import com.masai.usecases.AddNewItemUseCase;
import com.masai.usecases.ItemsCategoryWaiseUseCase;
import com.masai.usecases.LoginAdminUserCase;
import com.masai.usecases.LoginBuyerUserCase;
import com.masai.usecases.LoginSellerUserCase;
import com.masai.usecases.RemoveItemUseCase;
import com.masai.usecases.ResisterAdminUseCase;
import com.masai.usecases.ResisterBuyerUseCase;
import com.masai.usecases.ResisterSellerUseCase;
import com.masai.usecases.SellerItemCategoryWaiseUseCase;
import com.masai.usecases.UpdatePriceUseCase;
import com.masai.usecases.UpdateQuantityUseCase;
import com.masai.usecases.ViewResisteredBuyersListUseCase;
import com.masai.usecases.ViewResisteredSellersListUseCase;
import com.masai.usecases.ViewSoldItemsUseCase;

public class AMS {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
	      System.out.println();
		
		System.out.println("===============================================");
		System.out.println("   LOGIN/ SIGNUP ");
		System.out.println("===============================================");
        System.out.println();
        System.out.println("Please select your option to continue : ");
		System.out.println("  1. Administrator\n  2. Seller \n  3. Buyer ");
		System.out.println("< < Enter your option >>");
		
		int choice = sc.nextInt();
		System.out.println();
		
		switch(choice) {
		
		case 1 : 
			System.out.println("===============================================");
			         System.out.println("ADMINISTRATOR");
			         System.out.println("===============================================");
			     	System.out.println();
			          System.out.println("1. Login \n2. Signup");

		              System.out.println("< < Select your option > >");
		      		 int option = sc.nextInt();
		      		System.out.println();
		      		
		              switch(option) {
		              case 1 :
		            	  
		            	  LoginAdminUserCase login = new LoginAdminUserCase();
		                   if(login.loginAdmin()) {
		                	   AMS.adminFlow();
		                   }
		             
		              break;
				    case 2 :
				    	  ResisterAdminUseCase signup = new ResisterAdminUseCase();
				    	
				    	  if(signup.resisterAdminUseCase()) {
		                	   AMS.adminFlow();
		                   }
				     break;
				
		              }

		break;
		case 2 : System.out.println("1. login \n2. signup");
	    System.out.println("< < Select your option > >");
 		 int option2 = sc.nextInt();
         switch(option2) {
        
	    case 1 :
	    	LoginSellerUserCase sellerLogin = new LoginSellerUserCase();
	    	if(sellerLogin.loginSellerUserCase()) {
	    		AMS.sellerFlow();
	    	}

	     break;
	     
	    case 2 :
	    	ResisterSellerUseCase sellerResister = new ResisterSellerUseCase();
	    
	    	if(sellerResister.resisterSellerUseCase()) {
	    		AMS.sellerFlow();
	    		
	    	}

	     break;
         }

		break;
		
		case 3 : System.out.println("1. login \n2. signup");
        System.out.println("< < Select your option > >");
		 int option3 = sc.nextInt();
        switch(option3) {
        case 1 :
        	LoginBuyerUserCase login = new LoginBuyerUserCase();
             if(login.loginBuyerUserCase()) {
      	   AMS.buyerFlow();
             }
       
        break;
	    case 2 :
	    	ResisterBuyerUseCase signup = new ResisterBuyerUseCase();
	    	
	    	  if(signup.resisterBuyerUseCase()) {
	    	   	   AMS.buyerFlow();
             }
	     break;
	
        }

break;
		}
		
	}
	
	public static void adminFlow() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("1. View the registered buyer list.\n2. View the registered Seller list.\n3. View the daily dispute report.\n4. View the daily selling report. \n5. Solve the dispute report. \n6. Back \n7. Return to main menu \n8. Exit");
		System.out.println("Select your option ...");
		System.out.println();
		int option = sc.nextInt();
		
		switch(option) {
		
		case 1 : 
			ViewResisteredBuyersListUseCase buyerList = new ViewResisteredBuyersListUseCase();
		    buyerList.viewResisteredBuyersListUseCase();
		    AMS.navigationOptionForAdmin();
			break;
		
		
	case 2 : 
		ViewResisteredSellersListUseCase  sellerList = new ViewResisteredSellersListUseCase();
		sellerList.viewResisteredSellersListUseCase();
		AMS.navigationOptionForAdmin();
		break;
		
	case 3 : 
		System.out.println("pending : View the daily dispute report ");
		
		break;
		
	case 4 : 
		System.out.println("pending : View the daily selling report ");
		
		break;
		
	case 5 : 
		System.out.println("pending : Solve the dispute report. ");
		
		break;
	case 6 : 
		AMS.adminFlow();
		
		break;
		
	case 7 : 
		AMS.main(null);
		
		break;
		
	case 8 : 
		System.exit(0);
		
		break;

	}
		//default case pending
	}
		
	
	public static void navigationOptionForAdmin() {
		System.out.println("1. Back \n2. Return \n3. Exit");
		System.out.println("Enter your option ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
	
		switch(choice) {
		case 1 : 
			AMS.adminFlow();
			
			break;
			
		case 2 : 
			AMS.main(null);
			
			break;
			
		case 3 : 
			System.exit(0);
			
			break;
		}
		
		
	}
		
	
	public static void sellerFlow() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Create list of items to sell\n2. Update Item price\n3. Update Item quantity\n4. Add new Item in the list. \n5. Remove items from the list.\n6. View the sold Item history.  \n7. Return to main menu \n8. Exit");
		System.out.println("Select your option ...");
		int option = sc.nextInt();
		
		switch(option) {
		
		case 1 : 
			AddNewItemUseCase addItemToList = new AddNewItemUseCase();
			addItemToList.addNewItemUseCase();
                AMS.navigationOptionForSeller();
			break;
		
		
	case 2 : 
		UpdatePriceUseCase  updatePrice = new UpdatePriceUseCase();
		updatePrice.updatePriceUseCase();
		 AMS.navigationOptionForSeller();
		break;
		
	case 3 : 
		
		UpdateQuantityUseCase updateQuantity = new UpdateQuantityUseCase();
		updateQuantity.updateQuantityUseCase();
		 AMS.navigationOptionForSeller();
		
		break;
		
	case 4 : 
	
		AddNewItemUseCase addItem= new AddNewItemUseCase();
		addItem.addNewItemUseCase();
		 AMS.navigationOptionForSeller();
		
		break;
		
	case 5 : 
		RemoveItemUseCase removeItem = new RemoveItemUseCase();
		removeItem.removeItemUseCase();
		 AMS.navigationOptionForSeller();
		break;
		
	case 6: 
		
		ViewSoldItemsUseCase soldItems = new ViewSoldItemsUseCase();
		soldItems.viewSoldItems();
		 AMS.navigationOptionForSeller();
		
	
		break;
	case 7 : 
		AMS.main(null);
		
		break;
		
	case 8 : 
		System.exit(0);
		
		break;

	}
		//default case pending
	}
	
	
	public static void navigationOptionForSeller() {
		System.out.println("1. Back \n2. Return \n3. Exit");
		System.out.println("Enter your option ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
	
		switch(choice) {
		case 1 : 
			AMS.sellerFlow();
			
			break;
			
		case 2 : 
			AMS.main(null);
			
			break;
			
		case 3 : 
			System.exit(0);
			
			break;
		}
		
		
	}
	
	
	
	public static void buyerFlow() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Search and view Items by category\n2. Select and view all the buyers and also their Items \n3. Selects Items to buy. \n4. Return to main menu \n5. Exit");
		System.out.println("Select your option ...");
		int option = sc.nextInt();
		
		switch(option) {
		
		case 1 : 
			ItemsCategoryWaiseUseCase ItemsCategoryWaise = new ItemsCategoryWaiseUseCase();
			ItemsCategoryWaise.itemsCategoryWaiseUseCase();
			AMS.navigationOptionForBuyer() ;
			break;
		
		
	case 2 : 
		SellerItemCategoryWaiseUseCase  sellerItemsCategoryWaise = new SellerItemCategoryWaiseUseCase();
		sellerItemsCategoryWaise.sellerItemCategoryWaiseUseCase();
		AMS.navigationOptionForBuyer() ;
		break;
		
	case 3 : 
		
		System.out.println("// Pending");
		AMS.navigationOptionForBuyer() ;
		
		break;

	case 4 : 
		AMS.main(null);
		
		break;
		
	case 5 : 
		System.exit(0);
		
		break;

	}
		//default case pending
	}
	
	public static void navigationOptionForBuyer() {
		System.out.println("1. Back \n2. Return \n3. Exit");
		System.out.println("Enter your option ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
	
		switch(choice) {
		case 1 : 
			AMS.buyerFlow();
			
			break;
			
		case 2 : 
			AMS.main(null);
			
			break;
			
		case 3 : 
			System.exit(0);
			
			break;
		}
		
		
	}
	}
	
	


