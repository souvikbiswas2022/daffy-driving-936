package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.masai.bean.Admin;
import com.masai.bean.Buyer;
import com.masai.bean.Item;
import com.masai.utility.DBUtil;

public class BuyerDaoImpl implements BuyerDao {

	@Override
	public String resisterBuyer(Buyer b) {
	
		String message="Resistration failled ...";
		
		
		try(Connection connection = DBUtil.provideConnection()){
			
			PreparedStatement ps=connection.prepareStatement("insert into buyers(bname,bemail,bpan,bpassword) values(?,?,?,?)");
			
			ps.setString(1, b.getName());
			ps.setString(2,b.getEmail());
			ps.setString(3,b.getPan());
			ps.setString(4, b.getPassword());
			
			int check = ps.executeUpdate();
			
			if(check>0) {
				
				message = "resistration successfull...";
			}

		}catch(SQLException e) {
			
			e.printStackTrace();

		}

		return message;
	}

	@Override
	public ArrayList<String>  getAllCategory() {

		ArrayList<String> allCategory =  new ArrayList<>();
		
	  try(Connection connection = DBUtil.provideConnection()){
		  
		  PreparedStatement ps = connection.prepareStatement("select itemcategory from items group by itemcategory;");
		  
		  ResultSet rs = ps.executeQuery();
		  
		  while(rs.next()) {
			  
			  String category = rs.getString("itemcategory");
			  
			  allCategory.add(category);
		  }
 
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }

		return allCategory;
	}

	@Override
	public ArrayList<Item> getItemListCategoryWaise(String itemCategory) {

		ArrayList<Item>  itemList = new ArrayList<>();
		
		try(Connection connection = DBUtil.provideConnection()){
			
			PreparedStatement ps = connection.prepareStatement("select * from items where itemcategory=?;");
			
			ps.setString(1, itemCategory);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
			    int salerid = rs.getInt("sid");
				 int itemId = rs.getInt("itemid");
				 
				String itemName = rs.getString("itemname");
				String  category = rs.getString("itemcategory");
			    double basePrice = rs.getDouble("baseprice");
				int quantity = rs.getInt("qn");
				
				
				String itemStatus =rs.getString("itemstatus");
			    Date soldDate = rs.getDate("solddate");
			    double soldPrice = rs.getDouble("soldprice");
			   Date startDate = rs.getDate("startdate");
			   Date endDate = rs.getDate("enddate");
			   String auctionStatus = rs.getString("aucStatus");
			   int buyerId = rs.getInt("bid");
					
		
			   itemList.add(new Item(salerid,itemId,itemName,category,basePrice,quantity,itemStatus,soldDate,soldPrice,startDate,endDate,auctionStatus,buyerId));	

			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

		return itemList;
	}

	@Override
	public Map<String, ArrayList<Item>> buyerItems() {
		Map<String, ArrayList<Item>>  buyerAndItems = new HashMap<String, ArrayList<Item>> ();
		
		
		try(Connection connection = DBUtil.provideConnection()){
			
			AdminDao bd = new AdminDaoImpl();
			
			ArrayList<Buyer> buyers = bd.getBuyers();
			ArrayList<Item> allItems = bd.getAllItems();
			
			for(Buyer b:buyers) {
			    ArrayList<Item> Items = new ArrayList<Item> () ;
				for(Item i:allItems) {
	
			
				 if(b.getBuyerId() == i.getBuyerId()) {
					Items.add(i);
				 }

				}
				buyerAndItems.put(b.getName(), Items);

			}
			

		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		

		return buyerAndItems;
	}

	@Override
	public Buyer loginBuyer(String email, String password) {
	
		
		Buyer buyer = null;
		
		try(Connection connection = DBUtil.provideConnection()){
			
			PreparedStatement ps = connection.prepareStatement("select * from buyers where bemail =? and bpassword = ?;");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int id = rs.getInt("bid");
			String nm = rs.getString("bname");
			String eml = rs.getString("bemail");
			String pan = rs.getString("bpan");
			String pass = rs.getString("bpassword");
			
			buyer = new Buyer(id,nm,eml,pan,pass);
		}
		else {
			
			System.out.println(" -> through exception");
		}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}

		return buyer;

	}
	}


