package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.masai.bean.Admin;
import com.masai.bean.BidItem;
import com.masai.bean.Buyer;
import com.masai.bean.Item;
import com.masai.bean.Seller;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.BuyerException;
import com.masai.exceptions.ItemException;
import com.masai.exceptions.SellerException;
import com.masai.utility.DBUtil;
import com.mysql.cj.xdevapi.Result;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String resisterAdmin(Admin a) {
	
		String message = "Resistration failed ...";
		
		try(Connection connection = DBUtil.provideConnection()){
			
	PreparedStatement ps=connection.prepareStatement("insert into admins values(?,?,?)");
			
			ps.setString(1, a.getName());
			ps.setString(2,a.getEmail());
			ps.setString(3, a.getPassword());
			
			int check = ps.executeUpdate();
			
			if(check>0) {
				
				message = "Resistration successfull...";
			}

		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		

		return message;
	}

	@Override
	public ArrayList<Buyer> getBuyers() throws  BuyerException{
	
		ArrayList<Buyer> buyers = new ArrayList<>();
		
		try(Connection connection = DBUtil.provideConnection()){
			
		PreparedStatement ps = connection.prepareStatement("select * from buyers");
		
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			int buyerId = rs.getInt("bid");
			String name = rs.getString("bname");
			String email = rs.getString("bemail");
			String panNo = rs.getString("bpan");
			String password = rs.getString("bpassword");
			
			buyers.add(new Buyer(buyerId,name,email,panNo,password));
		     }
			
		}catch(SQLException e) {
			throw new BuyerException(e.getMessage());
			
		}
		
		if(buyers.size() == 0) {
			throw new BuyerException("No buyers found ...");
		}

		return buyers;
	}

	@Override
	public ArrayList<Seller> getSellers() throws SellerException {
		
	ArrayList<Seller> sellers = new ArrayList<>();
		
		try(Connection connection = DBUtil.provideConnection()){
			
		PreparedStatement ps = connection.prepareStatement("select * from sellers");
		
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			
			String name = rs.getString("sname");
			String email = rs.getString("semail");
			String panNo = rs.getString("span");
			String password = rs.getString("spassword");
			
			sellers.add(new Seller(name,email,panNo,password));
		     }
			
		}catch(SQLException e) {
			
			throw new SellerException(e.getMessage());

		}
		
		if(sellers.size() == 0) {
			throw new SellerException("No seller found ...");
		}

		return sellers;
	}

	@Override
	public ArrayList<Item> getAllItems()  throws ItemException{

      ArrayList<Item>  allItems = new ArrayList<>();
		
		try(Connection connection = DBUtil.provideConnection()){
			
			PreparedStatement ps = connection.prepareStatement("select * from items ;");
			
		
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
			   Time endTime = rs.getTime("endtime");
			   String auctionStatus = rs.getString("aucStatus");
			   int buyerId = rs.getInt("bid");
					
		
			   allItems.add(new Item(salerid,itemId,itemName,category,basePrice,quantity,itemStatus,soldDate,soldPrice,startDate,endTime,auctionStatus,buyerId));	

			}
			
			
			
		}catch(SQLException e) {
			
			throw new ItemException(e.getMessage());
		}
		
		if(allItems.size() == 0) {
			throw new ItemException("No item found ...");
		}
		

		return allItems;

		
		
	}

	@Override
	public Admin loginAdmin(String email, String password)   throws  AdminException{
		
		Admin admin = null;
		
		try(Connection connection = DBUtil.provideConnection()){
			
			PreparedStatement ps = connection.prepareStatement("select * from admins where aemail =? and apassword = ?;");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			String n = rs.getString("aname");
			String e = rs.getString("aemail");
			String p = rs.getString("apassword");
			
			admin = new Admin(n,e,p);
		}
		else {
			
			throw new AdminException(" Invalid email or password ...");
		}
			
		}catch(SQLException e) {
			throw new AdminException(e.getMessage());
		}

		return admin;
	}

	@Override
	public   void algoBid() {
	
		
		ArrayList<BidItem> bidItems = new ArrayList<>();
		
		try(Connection connection  = DBUtil.provideConnection()){
			
			PreparedStatement ps = connection.prepareStatement("select * from bidcalculate");
			
			ResultSet rs =  ps.executeQuery();
			
	
			
			while(rs.next()) {
				
				int buyerId = rs.getInt("bid");
				Double bidPrice = rs.getDouble("bidPrice");
				int itemId = rs.getInt("itemid");
				
				bidItems.add(new BidItem(buyerId,bidPrice,itemId));
				
			}
			
			// exception 
			   HashSet<Integer> itemIds = new HashSet<>();
			   
				Map<Integer,Double>  map = new HashMap();
		
			for( BidItem i:bidItems) {
				
				itemIds.add(i.getItemId());
			}
			
			
			map.put(bidItems.get(0).getItemId(),bidItems.get(0).getBidPrice() );
			
			
		for(BidItem b:bidItems) {	
			
			if(map.containsKey(b.getItemId())) {
				
				if(b.getBidPrice() > map.get(b.getItemId())){
					
					map.put(b.getItemId(), b.getBidPrice());
				}
				
			}
			else {
				
				map.put(b.getItemId(), b.getBidPrice());
				
			}
			
		}
		
		
		
		for(Map.Entry<Integer, Double> m:map.entrySet()) {
			
			
        PreparedStatement ps2 = connection.prepareStatement("select bid  from bidcalculate where itemid=? and bidprice=?");
        ps2.setInt(1, m.getKey());
       ps2.setDouble(2, m.getValue());			
		ResultSet rs2=  ps2.executeQuery();
			
			if(rs2.next()) {
				int buyerId = rs2.getInt("bid");
				
				 PreparedStatement ps3 = connection.prepareStatement("update items set bid=? ,  itemstatus='SOLD' , solddate= curdate() ,soldprice=?    where itemid=? ");
					ps3.setInt(1,buyerId);
					ps3.setDouble(2,m.getValue());
					ps3.setInt(3,m.getKey());
				
					int check = ps3.executeUpdate();
		
			}
			else {
				System.out.println("//Throw error");
			}

		}

//		System.out.println(map);
		
		 PreparedStatement ps4 = connection.prepareStatement("delete from  bidcalculate");
         ps4.executeUpdate();
		 
         
         
         
         
         
         
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
	
	}

	}

