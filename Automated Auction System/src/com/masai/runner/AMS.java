package com.masai.runner;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.usecases.AddNewItemUseCase;
import com.masai.usecases.BuyerBiddingUseCase;
import com.masai.usecases.DailySellingReportuseCase;
import com.masai.usecases.DisputeResolveUseCase;
import com.masai.usecases.FileDisputeUseCase;
import com.masai.usecases.ItemsCategoryWaiseUseCase;
import com.masai.usecases.LoginAdminUserCase;
import com.masai.usecases.LoginBuyerUserCase;
import com.masai.usecases.LoginSellerUserCase;
import com.masai.usecases.RemoveItemUseCase;
import com.masai.usecases.ResisterAdminUseCase;
import com.masai.usecases.ResisterBuyerUseCase;
import com.masai.usecases.ResisterSellerUseCase;
import com.masai.usecases.SellerItemCategoryWaiseUseCase;
import com.masai.usecases.ShowDisputeUseCase;
import com.masai.usecases.UpdatePriceUseCase;
import com.masai.usecases.UpdateQuantityUseCase;
import com.masai.usecases.ViewResisteredBuyersListUseCase;
import com.masai.usecases.ViewResisteredSellersListUseCase;
import com.masai.usecases.ViewSoldItemsUseCase;

public class AMS {

	public static void start() {

		AdminDao ad = new AdminDaoImpl();
		ad.algoBid();

		Scanner sc = new Scanner(System.in);
		System.out.println();

		System.out.println("===============================================|");
		System.out.println("   @ LOGIN/ SIGNUP ");
		System.out.println("===============================================|");
		System.out.println();
		System.out.println("Please select your option to continue : ");
		System.out.println("  1. Administrator\n  2. Seller \n  3. Buyer ");
		
		try {
		System.out.println("< < Enter your option >>");
		int choice = sc.nextInt();
		

		switch (choice) {

		case 1:
			System.out.println("===============================================");
			System.out.println("ADMINISTRATOR");
			System.out.println("===============================================");
			System.out.println();
			System.out.println("1. Login \n2. Signup");

			System.out.println("< < Select your option > >");
			int option = sc.nextInt();
//		      		System.out.println();

			switch (option) {
			case 1:

				LoginAdminUserCase login = new LoginAdminUserCase();
				if (login.loginAdmin()) {
					AMS.adminFlow();
				}

				break;
			case 2:
				ResisterAdminUseCase signup = new ResisterAdminUseCase();

				if (signup.resisterAdminUseCase()) {
					AMS.adminFlow();
				}
				break;

			}

			break;
			
			
		case 2:
			System.out.println("===============================================");
			System.out.println(" @ SELLER");
			System.out.println("===============================================");
			System.out.println();
			System.out.println("1. Login \n2. Signup");
			System.out.println("< < Select your option > >");
			int option2 = sc.nextInt();
			
			
			switch (option2) {

			case 1:
				LoginSellerUserCase sellerLogin = new LoginSellerUserCase();
				if (sellerLogin.loginSellerUserCase()) {
					AMS.sellerFlow();
				}

				break;

			case 2:
				ResisterSellerUseCase sellerResister = new ResisterSellerUseCase();

				if (sellerResister.resisterSellerUseCase()) {
					AMS.sellerFlow();

				}

				break;
			}

			break;

		case 3:
			
			System.out.println("===============================================");
			System.out.println(" @ BUYER");
			System.out.println("===============================================");
			System.out.println();
			System.out.println("1. Login \n2. Signup");
			System.out.println("< < Select your option > >");
			int option3 = sc.nextInt();
			
			
			switch (option3) {
			
			
			case 1:
				
				LoginBuyerUserCase login = new LoginBuyerUserCase();
				if (login.loginBuyerUserCase()) {
					AMS.buyerFlow();
				}
				break;
				
				
			case 2:
				
				ResisterBuyerUseCase signup = new ResisterBuyerUseCase();

				if (signup.resisterBuyerUseCase()) {
					AMS.buyerFlow();
				}
				break;

			}
			break;
			
			
          default : System.out.println("Invalid choice ...");
          break;
		}
		}catch(InputMismatchException e) {
			System.out.println();
			System.out.println("Invalid choice ... [ TRY AGAIN ]");
			AMS.start();
			
		}
		
		
	


	}

	
	
	
	
	public static void adminFlow() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("[OPTIONS]");
		System.out.println(
				"1. View Buyer List.\n2. View Seller List.\n3. View Dispute Report.\n4. View Daily Selling Report. \n5. Solve  Disputes . \n6. Back \n7. Return to main menu \n8. Exit");
		System.out.println("Please select your option ...");
//		System.out.println();
		int option = sc.nextInt();

		switch (option) {

		case 1:
			ViewResisteredBuyersListUseCase buyerList = new ViewResisteredBuyersListUseCase();
			buyerList.viewResisteredBuyersListUseCase();
			AMS.navigationOptionForAdmin();
			break;

		case 2:
			ViewResisteredSellersListUseCase sellerList = new ViewResisteredSellersListUseCase();
			sellerList.viewResisteredSellersListUseCase();
			AMS.navigationOptionForAdmin();
			break;

		case 3:
			ShowDisputeUseCase sd = new ShowDisputeUseCase();
			sd.showDisputeUseCase();
			AMS.navigationOptionForAdmin();
			break;

		case 4:
			DailySellingReportuseCase dsr = new DailySellingReportuseCase();

			dsr.dailySellingReportuseCase();
			AMS.navigationOptionForAdmin();
			break;

		case 5:
			ShowDisputeUseCase sd2 = new ShowDisputeUseCase();
			sd2.showDisputeUseCase();

			DisputeResolveUseCase dr = new DisputeResolveUseCase();

			dr.disputeResolveUseCase();
			AMS.navigationOptionForAdmin();

			break;
		case 6:
			AMS.adminFlow();

			break;

		case 7:
			AMS.start();

			break;

		case 8:
			System.exit(0);

			break;

		}
		// default case pending
	}

	public static void navigationOptionForAdmin() {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("1. Back \n2. Return to main menu \n3. Exit");
		System.out.println("Enter your option ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		switch (choice) {
		case 1:

			AMS.adminFlow();

			break;

		case 2:
			AMS.start();

			break;

		case 3:
			System.exit(0);

			break;
		}

	}

	public static void sellerFlow() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println(
				"1. Create list of items to sell\n2. Update Item price\n3. Update Item quantity\n4. Add new Item. \n5. Remove item.\n6. View  sold Item .  \n7. File dispute \n8. Return to main menu \n9. Exit");
		System.out.println("< < Select your option > >");
		int option = sc.nextInt();

		switch (option) {

		case 1:
			AddNewItemUseCase addItemToList = new AddNewItemUseCase();
			addItemToList.addNewItemUseCase();
			AMS.navigationOptionForSeller();
			break;

		case 2:
			UpdatePriceUseCase updatePrice = new UpdatePriceUseCase();
			updatePrice.updatePriceUseCase();
			AMS.navigationOptionForSeller();
			break;

		case 3:

			UpdateQuantityUseCase updateQuantity = new UpdateQuantityUseCase();
			updateQuantity.updateQuantityUseCase();
			AMS.navigationOptionForSeller();

			break;

		case 4:

			AddNewItemUseCase addItem = new AddNewItemUseCase();
			addItem.addNewItemUseCase();
			AMS.navigationOptionForSeller();

			break;

		case 5:
			RemoveItemUseCase removeItem = new RemoveItemUseCase();
			removeItem.removeItemUseCase();
			AMS.navigationOptionForSeller();
			break;

		case 6:

			ViewSoldItemsUseCase soldItems = new ViewSoldItemsUseCase();
			soldItems.viewSoldItems();
			AMS.navigationOptionForSeller();

			break;

		case 7:

			FileDisputeUseCase fd = new FileDisputeUseCase();
			fd.fileDisputeUseCase();

			AMS.navigationOptionForSeller();

			break;
		case 8:
			AMS.start();

			break;

		case 9:
			System.exit(0);

			break;

		}
		// default case pending
	}

	public static void navigationOptionForSeller() {
		System.out.println("-----------------------------");
		System.out.println("1. Back \n2. Return \n3. Exit");
		System.out.println("Enter your option ");
		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			AMS.sellerFlow();

			break;

		case 2:
			AMS.start();

			break;

		case 3:
			System.exit(0);

			break;
		}

	}

	public static void buyerFlow() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"1. Search and View Items By Category\n2. Show All  Items By Sellers \n3. Selects Items To Buy. \n4.File Disputr .\n5. Return to main menu \n6. Exit");
		System.out.println("Select your option ...");
		int option = sc.nextInt();

		switch (option) {

		case 1:
			ItemsCategoryWaiseUseCase ItemsCategoryWaise = new ItemsCategoryWaiseUseCase();
			ItemsCategoryWaise.itemsCategoryWaiseUseCase();
			AMS.navigationOptionForBuyer();
			break;

		case 2:
			SellerItemCategoryWaiseUseCase sellerItemsCategoryWaise = new SellerItemCategoryWaiseUseCase();
			sellerItemsCategoryWaise.sellerItemCategoryWaiseUseCase();
			AMS.navigationOptionForBuyer();
			break;

		case 3:

			BuyerBiddingUseCase bdc = new BuyerBiddingUseCase();
			bdc.buyerBiddingUseCase();
			AMS.navigationOptionForBuyer();

			break;

		case 4:

			FileDisputeUseCase fd = new FileDisputeUseCase();
			fd.fileDisputeUseCase();
			AMS.navigationOptionForBuyer();

			break;

		case 5:
			AMS.start();

			break;

		case 6:
			System.exit(0);

			break;

		}
		// default case pending
	}

	public static void navigationOptionForBuyer() {
		System.out.println("1. Back \n2. Return \n3. Exit");
		System.out.println("Enter your option ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			AMS.buyerFlow();

			break;

		case 2:
			AMS.start();

			break;

		case 3:
			System.exit(0);

			break;
		}

	}
}
